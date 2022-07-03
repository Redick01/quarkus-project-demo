package io.redick.quarkus.observes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * @author Redick01
 */
@ApplicationScoped
public class Observe {

    private static final Logger log = LoggerFactory.getLogger(Observe.class);

    public void watch(@Observes EventMessage message) {
        log.info("收到事件信息：{}", message);
    }
}
