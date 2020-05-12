package gr.ntua.ece.databasics.api;

import gr.ntua.ece.databasics.api.resource.*;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.engine.application.CorsFilter;
import org.restlet.routing.Router;

import java.util.Set;

public class RestfulApp extends Application {

    @Override
    public synchronized Restlet createInboundRoot() {

        Router router = new Router(getContext());

        //Perform a heath check
        System.out.println("Just before router part");
        router.attach("/HealthCheck", HealthCheck.class);
        
        //Enable CORS for all origins (don't use this in a production service)
        CorsFilter corsFilter = new CorsFilter(getContext(), router);
        corsFilter.setAllowedOrigins(Set.of("*"));
        corsFilter.setAllowedCredentials(true);
        corsFilter.setAllowedHeaders(Set.of("X-OBSERVATORY-AUTH"));
        corsFilter.setDefaultAllowedMethods(Set.of(Method.GET, Method.PUT, Method.POST, Method.DELETE));
        corsFilter.setAllowingAllRequestedHeaders(true);
        corsFilter.setSkippingResourceForCorsOptions(true);
        corsFilter.setMaxAge(10);
        return corsFilter;
    }


}