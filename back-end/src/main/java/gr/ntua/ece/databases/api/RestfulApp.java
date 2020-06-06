package gr.ntua.ece.databases.api;

import gr.ntua.ece.databases.api.resource.*;
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
        router.attach("/HealthCheck", HealthCheck.class);
        router.attach("/stores", StoresInfo.class);
        router.attach("/storeHomepage/{StoreId}", StoreHomepage.class);
        router.attach("/storeHomepage/{StoreId}/transactions/startingDate/{startingDate}/endingDate/{endingDate}/paymentMethod/{paymentMethod}/numPrdLow/{numPrdLow}/numPrdHigh/{numPrdHigh}", TransactionsResource.class);
        router.attach("/users", UsersIndex.class);
        router.attach("/profile/{UserId}",UserProfile.class);
        router.attach("/profile/{UserId}/userInfo",UserInfoResource.class);
        router.attach("/products",ProductsIndex.class);
        router.attach("/product/{Barcode}", ProductResource.class);
        router.attach("/product/{Barcode}/priceHistory", PriceHistoryResource.class);
        
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
