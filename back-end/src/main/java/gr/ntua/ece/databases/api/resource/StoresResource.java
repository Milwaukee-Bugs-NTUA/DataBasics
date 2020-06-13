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
import java.sql.Time;
import java.lang.RuntimeException;
import java.net.http.HttpRequest;
import org.restlet.data.Form;
import java.net.URLDecoder;

import gr.ntua.ece.databases.data.model.Store;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public class StoresResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            List<Store> result = dataAccess.fetchStores();
            return format.generateRepresentationStores(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation post(Representation entity) throws ResourceException {

        Form form = new Form(entity);
        Integer size = Integer.valueOf(form.getFirstValue("Size"));
        String city = form.getFirstValue("AddressCity");
        String street = form.getFirstValue("AddressStreet");
        Integer streetNumber = Integer.valueOf(form.getFirstValue("AddressNumber"));
        String postalCode = form.getFirstValue("AddressPostalCode");
        Time openingHour = Time.valueOf(form.getFirstValue("OpeningHour"));
        Time closingHour = Time.valueOf(form.getFirstValue("ClosingHour"));

        try {
            dataAccess.addStore(
                                size,
                                city,
                                street,
                                streetNumber,
                                postalCode,
                                openingHour,
                                closingHour
                                );
            return new JsonMapRepresentation(Map.of("status", "OK"));
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}