package gr.ntua.ece.databases.api.resource;

import gr.ntua.ece.databases.api.Format;
import gr.ntua.ece.databases.api.representation.JsonMapRepresentation;
import gr.ntua.ece.databases.conf.Configuration;
import gr.ntua.ece.databases.data.DataAccess;
import gr.ntua.ece.databases.data.DataAccessException;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import java.lang.RuntimeException;
import java.net.http.HttpRequest;
import org.restlet.data.Form;
import java.net.URLDecoder;

import gr.ntua.ece.databases.data.model.Product;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public class ProductsResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            List<Product> result = dataAccess.fetchProducts();
            return format.generateRepresentationProducts(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation post(Representation entity) throws ResourceException {
        
        Form form = new Form(entity);
        String name = form.getFirstValue("Name");
        String brand = form.getFirstValue("Brand");
        Float  price = Float.valueOf(form.getFirstValue("Price"));
        Long categoryId = Long.valueOf(form.getFirstValue("CategoryId"));
        Long offeredInStore = Long.valueOf(form.getFirstValue("OfferedInStore"));
        String alleyNumber = form.getFirstValue("AlleyNumber");;
        String shelfNumber = form.getFirstValue("ShelfNumber");;
        
        try {
            dataAccess.addProduct(
                                    name,
                                    brand,
                                    price,
                                    categoryId,
                                    offeredInStore,
                                    alleyNumber,
                                    shelfNumber
                                    );
            return new JsonMapRepresentation(Map.of("status", "OK"));
        }
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }
    }

}