package io.redick.quarkus.resource;


import io.redick.quarkus.bean.Fruit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Redick01
 */
@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    public List<Fruit> fruits = new ArrayList<>();

    public FruitResource() {
        fruits.add(new Fruit("Apple", "苹果"));
        fruits.add(new Fruit("Orange", "桔子"));
    }

    @GET
    public List<Fruit> list() {
        return fruits;
    }

    @POST
    public List<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @DELETE
    public List<Fruit> del(String name) {
        fruits.forEach(e -> {
            if (name.equals(e.getName())) {
                fruits.remove(e);
            }
        });
        return fruits;
    }
}
