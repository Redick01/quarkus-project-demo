package io.redick.quarkus.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.redick.quarkus.db.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Redick01
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * get order by no
     * @param orderNo order no
     * @return order
     */
    @Select("SELECT id as id, order_no as orderNo, product_id as productId, pay_count as payCount, create_time as createTime FROM `order` WHERE order_no = #{orderNo}")
    Order getOrderByOrderNo(String orderNo);
}
