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

        Format format = Format.valueOf("JSON");
        Form form = new Form(entity);
        String s = form.getFirstValue("Size");
        Integer size = Integer.valueOf(s);
        String city = form.getFirstValue("Address City");
        String street = form.getFirstValue("Address Street");
        Integer streetNumber = Integer.valueOf(form.getFirstValue("Address Number"));
        String postalCode = form.getFirstValue("Address PostalCode");
        Time openingHour = Time.valueOf(form.getFirstValue("Opening Time"));
        Time closingHour = Time.valueOf(form.getFirstValue("Closing Time"));

        try {
            int result = dataAccess.addStore(
                                                size,
                                                city,
                                                street,
                                                streetNumber,
                                                postalCode,
                                                openingHour,
                                                closingHour
                                            );
            Store newStore = new Store();
            newStore.setSize(size);
            newStore.setAddressCity(city);
            newStore.setAddressStreet(street);
            newStore.setAddressNumber(streetNumber);
            newStore.setAddressPostalCode(postalCode);
            newStore.setOpeningHour(openingHour);
            newStore.setClosingHour(closingHour);
            return format.generateRepresentationStorePage(newStore);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}