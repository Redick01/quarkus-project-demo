package io.redick.quarkus.lifecycle;

import io.quarkus.runtime.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author Redick01
 */
@Startup
@ApplicationScoped
public class LifeCycle {

    private static final Logger log = LoggerFactory.getLogger(LifeCycle.class);

    @PostConstruct
    void init() {
        log.info("初始化");
    }

    @PreDestroy
    void destroy() {
        log.info("销毁");
    }
}
