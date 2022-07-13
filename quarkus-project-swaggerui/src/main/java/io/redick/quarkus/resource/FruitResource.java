package io.redick.quarkus.resource;


import io.redick.quarkus.bean.Fruit;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Redick01
 */
@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class FruitResource {

    public List<Fruit> fruits = new ArrayList<>();

    private AtomicLong counter = new AtomicLong(0);

    public FruitResource() {
        fruits.add(new Fruit("Apple", "苹果"));
        fruits.add(new Fruit("Orange", "桔子"));
    }

    @GET
    public List<Fruit> list() {
        maybeFail();
        return fruits;
    }

    @GET
    @Path("retry")
    @Retry(maxRetries = 4)
    public List<Fruit> retry() {
        maybeFail();
        return fruits;
    }

    @GET
    @Path("/delay")
    @Timeout(250)
    @Fallback(fallbackMethod = "fallback")
    public List<Fruit> delay() throws InterruptedException {
        randomDelay();
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

    @GET
    @Path("availability")
    public Response availability() {
        try {
            Integer i = getAvailability();
            return Response.ok(i).build();
        } catch (RuntimeException e) {
            String message = e.getClass().getSimpleName() + ": " + e.getMessage();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(message)
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .build();
        }
    }


    private void maybeFail() {
        if (new Random().nextBoolean()) {
            log.error("failure");
            throw new RuntimeException("Resource failure.");
        }
    }

    private void randomDelay() throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
    }

    private List<Fruit> fallback() {
        return Collections.singletonList(new Fruit("watermelon", "西瓜"));
    }


    @CircuitBreaker(requestVolumeThreshold = 4)
    public Integer getAvailability() {
        maybeFailBreaker();
        return new Random().nextInt(30);
    }

    private void maybeFailBreaker() {
        final long invocationNumber = counter.getAndIncrement();
        // alternate 2 successful and 2 failing invocations
        if (invocationNumber % 4 > 1) {
            throw new RuntimeException("Service failed.");
        }
    }
}
