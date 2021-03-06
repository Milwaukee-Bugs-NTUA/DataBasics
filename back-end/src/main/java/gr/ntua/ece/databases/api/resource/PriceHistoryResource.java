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

import gr.ntua.ece.databases.data.model.PriceHistory;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PriceHistoryResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Specify Barcode
        Long barcode = Long.valueOf(getMandatoryAttribute("Barcode", "Barcode is missing"));
        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            List<PriceHistory> result = dataAccess.fetchPriceHistory(barcode);
            return format.generateRepresentationPriceHistory(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}