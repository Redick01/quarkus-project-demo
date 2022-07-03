package io.redick.quarkus;

import io.quarkus.arc.All;
import io.quarkus.arc.InstanceHandle;
import io.quarkus.arc.log.LoggerName;
import io.redick.quarkus.dto.Animals;
import io.redick.quarkus.observes.EventMessage;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Redick01
 */
@Path("/animals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnimalsResource {

    private final List<Animals> list = new ArrayList<>();

    @Inject
    Logger logger;

    @LoggerName("fooLogger")
    Logger fooLog;

    @Inject
    Event<EventMessage> event;

    @Inject
    @All
    List<InstanceHandle<io.redick.quarkus.dependency.Animals>> instanceHandles;

    @Inject
    @All
    List<io.redick.quarkus.dependency.Animals> animals;

    public AnimalsResource() {
        list.add(new Animals("Cat", "猫"));
        list.add(new Animals("Dog", "狗"));
        list.add(new Animals("Pig", "猪"));
    }

    @GET
    public Multi<List<Animals>> list() {
        return Multi.createFrom().item(list);
    }

    @GET
    @Path("/dependency")
    public Multi<List<String>> dependency() {
        List<String> res = new ArrayList<>();
        instanceHandles.forEach(e -> {
            res.add(e.get().name());
        });
        return Multi.createFrom().item(res);
    }

    @GET
    @Path("/dependency1")
    public Multi<List<String>> dependency1() {
        List<String> res = new ArrayList<>();
        animals.forEach(e -> {
            res.add(e.name());
        });
        return Multi.createFrom().item(res);
    }

    @GET
    @Path("/{index}")
    public Uni<Animals> getOne(Integer index) {
        return Uni.createFrom().item(list.get(index));
    }

    @GET
    @Path("/response")
    public Response response() {
        logger.info("this is @Inject Logger");
        fooLog.info("this is @LoggerName(\"fooLogger\") Logger");
        EventMessage eventMessage = new EventMessage();
        eventMessage.setMessage("事件发出");
        event.fire(eventMessage);
        return Response.ok(list).build();
    }
}
