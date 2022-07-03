package io.redick.quarkus.dependency;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Redick01
 */
@ApplicationScoped
@Slf4j
public class Cat implements Animals {

    @Override
    public String name() {
        log.info("this is cat service");
        return "cat";
    }
}
