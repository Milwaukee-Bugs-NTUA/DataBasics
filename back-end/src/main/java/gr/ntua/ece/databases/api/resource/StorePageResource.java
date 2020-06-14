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
import java.net.URLDecoder;

import gr.ntua.ece.databases.data.model.Store;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public class StorePageResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        Long storeId = Long.valueOf(getMandatoryAttribute("StoreId", "StoreId is missing"));
        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            Store result = dataAccess.fetchStorePage(storeId);
            return format.generateRepresentationStorePage(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation delete() throws ResourceException {

        // Read the mandatory URI attributes
        Long storeId = Long.valueOf(getMandatoryAttribute("StoreId", "StoreId is missing"));

        try {
            dataAccess.deleteStore(storeId);
            return new JsonMapRepresentation(Map.of("status", "OK"));
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }
}