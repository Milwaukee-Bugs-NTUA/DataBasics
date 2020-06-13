package gr.ntua.ece.databases.api;

import gr.ntua.ece.databases.api.resource.*;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.engine.application.CorsFilter;
import org.restlet.routing.Router;
import java.sql.Date;

import java.util.Set;

public class RestfulApp extends Application {

    @Override
    public synchronized Restlet createInboundRoot() {

        Router router = new Router(getContext());

        //Perform a heath check
        router.attach("/HealthCheck", HealthCheck.class);
        router.attach("/stores", StoresResource.class);
        router.attach("/stores/insert", StoresResource.class);
        router.attach("/storePage/{StoreId}", StorePageResource.class);
        router.attach("/storePage/{StoreId}/transactions/{startingDate}/{endingDate}/{paymentMethod}/{numPrdLow}/{numPrdHigh}", TransactionsResource.class);
        router.attach("/transactionProducts/{date}/{time}/{cardNumber}", TransactionProductsResource.class);
        router.attach("/users", UsersResource.class);
        router.attach("/users/insert", UsersResource.class);
        router.attach("/profile/{UserId}",UserProfileResource.class);
        router.attach("/profile/{UserId}/userInfo",UserInfoResource.class);
        router.attach("/products",ProductsResource.class);
        router.attach("/product/{Barcode}", ProductResource.class);
        router.attach("/product/{Barcode}/priceHistory", PriceHistoryResource.class);
        router.attach("/productsStats", ProductsStatisticsResource.class);
        router.attach("/usersStats", UsersStatisticsResource.class);

        
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
