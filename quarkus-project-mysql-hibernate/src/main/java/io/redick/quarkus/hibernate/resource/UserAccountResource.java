package io.redick.quarkus.hibernate.resource;

import io.redick.quarkus.dto.http.HttpResponseDTO;
import io.redick.quarkus.hibernate.annotation.Logged;
import io.redick.quarkus.hibernate.db.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Redick01
 */
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserAccountResource {

    private static final Logger log = LoggerFactory.getLogger(UserAccountResource.class);

    @Inject
    UserAccountService userCountService;

    @GET
    @Path("/getAll")
    @Logged
    public Response order() {

        HttpResponseDTO<Object> responseDTO = HttpResponseDTO
                .builder()
                .resCode("0000")
                .resMessage("成功")
                .resData(userCountService.getUserCount())
                .build();
        return Response.ok(responseDTO).build();
    }

    @POST
    @Path("/create")
    @Logged
    public Response createUserCount() {
        userCountService.createUserCount();
        HttpResponseDTO<Object> responseDTO = HttpResponseDTO
                .builder()
                .resCode("0000")
                .resMessage("成功")
                .resData(userCountService.getUserCount())
                .build();
        return Response.ok(responseDTO).build();
    }
}
