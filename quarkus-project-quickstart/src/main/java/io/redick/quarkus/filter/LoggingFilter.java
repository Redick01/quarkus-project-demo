package io.redick.quarkus.filter;

import io.quarkus.logging.Log;
import io.vertx.core.http.HttpServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author Redick01
 */
@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger log = LoggerFactory.getLogger(LoggingFilter.class);

    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        final String method = containerRequestContext.getMethod();
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();
        log.info("Request {} {} from IP {}", method, path, address);
        Log.info("this is Panache record log");
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        final Integer code = containerResponseContext.getStatus();
        final Object res = containerResponseContext.getEntity();
        log.info("Response code {} entity {}", code, res.toString());
        Log.info("this is Panache record log");
    }


}
