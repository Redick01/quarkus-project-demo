package io.redick.quarkus.resource;

import io.quarkus.logging.Log;
import io.redick.quarkus.db.mapper.OrderMapper;
import io.redick.quarkus.db.model.Order;
import io.redick.quarkus.dto.http.HttpResponseDTO;
import io.redick.quarkus.resource.dto.AddOrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * @author Redick01
 */
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private static final Logger log = LoggerFactory.getLogger(OrderResource.class);

    @Inject
    OrderMapper orderMapper;

    @GET
    @Path("/order/{orderNo}")
    public Response order(@PathParam("orderNo") String orderNo) {
        log.info("请求参数：{}", orderNo);
        Order order = orderMapper.getOrderByOrderNo(orderNo);
        log.info("根据orderNo查询数据：{}", order.toString());
        HttpResponseDTO<Object> responseDTO = HttpResponseDTO
                .builder()
                .resCode("0000")
                .resMessage("成功")
                .resData(order)
                .build();
        return Response.ok(responseDTO).build();
    }

    @POST
    @Path("/addOrder")
    public Response addOrder(AddOrderRequest request) {
        if (null == request || null == request.getCount() || null == request.getProductId()) {
            HttpResponseDTO<Object> responseDTO = HttpResponseDTO
                    .builder()
                    .resCode("A001")
                    .resMessage("参数为空")
                    .build();
            return Response.ok(responseDTO).build();
        } else {
            Order order = new Order();
            order.setOrderNo(UUID.randomUUID().toString());
            order.setProductId(request.getProductId());
            order.setPayCount(request.getCount());

            HttpResponseDTO<Object> responseDTO = HttpResponseDTO
                    .builder()
                    .resCode("0000")
                    .resMessage("成功")
                    .build();
            return Response.ok(responseDTO).build();
        }
    }
}
