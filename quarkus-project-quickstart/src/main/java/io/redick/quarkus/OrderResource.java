package io.redick.quarkus;

import io.agroal.api.AgroalDataSource;
import io.redick.quarkus.db.Order;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Redick01
 */
@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    AgroalDataSource agroalDataSource;

    @GET
    public List<Order> list() throws SQLException {
        PreparedStatement statement = agroalDataSource.getConnection().prepareStatement("SELECT * FROM `order`;");
        ResultSet rs = statement.executeQuery();
        List<Order> res = new ArrayList<>();
        while (rs.next()) {
            res.add(new Order(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDate(5)));
        }
        return res;
    }
}
