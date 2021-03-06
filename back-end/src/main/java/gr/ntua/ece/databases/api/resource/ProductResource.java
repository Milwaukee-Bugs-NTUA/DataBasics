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

public class ProductResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Specify barcode of product
        Long barcode = Long.valueOf(getMandatoryAttribute("Barcode", "Barcode is missing"));
        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            Product result = dataAccess.fetchProduct(barcode);
            return format.generateRepresentationProduct(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation put(Representation entity) throws ResourceException {

        // Specify barcode of product
        Form form = new Form(entity);
        Long barcode = Long.valueOf(getMandatoryAttribute("Barcode", "Barcode is missing"));
        String name = form.getFirstValue("Name");
        String brand = form.getFirstValue("Brand");
        Long categoryId = Long.valueOf(form.getFirstValue("CategoryId"));

        try {
            dataAccess.updateProduct(barcode,name,brand,categoryId);
            return new JsonMapRepresentation(Map.of("status", "OK"));
        }
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation post(Representation entity) throws ResourceException {

        // Specify barcode of product
        Form form = new Form(entity);
        Long barcode = Long.valueOf(getMandatoryAttribute("Barcode", "Barcode is missing"));
        Float price = Float.valueOf(form.getFirstValue("Price"));

        try {
            dataAccess.updateProductPrice(barcode,price);
            return new JsonMapRepresentation(Map.of("status", "OK"));
        }
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation delete() throws ResourceException {

        // Read the mandatory URI attributes
        Long barcode = Long.valueOf(getMandatoryAttribute("Barcode", "Barcode is missing"));

        try {
            dataAccess.deleteProduct(barcode);
            return new JsonMapRepresentation(Map.of("status", "OK"));
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}