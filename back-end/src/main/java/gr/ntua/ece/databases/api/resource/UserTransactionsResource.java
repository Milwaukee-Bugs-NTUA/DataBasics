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

import gr.ntua.ece.databases.data.model.Transaction;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import java.util.List;
import java.sql.Date;
import java.util.Optional;

public class UserTransactionsResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Read the mandatory URI attributes
        Long userId = Long.valueOf(getMandatoryAttribute("UserId", "UserId is missing"));
        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            List<Transaction> result = dataAccess.fetchUserTransactions(userId);
            return format.generateRepresentationTransactions(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}