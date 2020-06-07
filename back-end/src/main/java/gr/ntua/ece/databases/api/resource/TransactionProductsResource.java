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
import java.lang.IllegalArgumentException;
import java.lang.RuntimeException;
import java.net.http.HttpRequest;
import java.net.URLDecoder;

import gr.ntua.ece.databases.data.model.TransactionProduct;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.sql.Timestamp;
import java.util.Optional;

public class TransactionProductsResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            // Read the mandatory URI attributes
            Timestamp datetime = Timestamp.valueOf(getMandatoryAttribute("date", "Date is missing") + " " +
                                                getMandatoryAttribute("time", "Time is missing"));
            Long cardNumber = Long.valueOf(getMandatoryAttribute("cardNumber", "Card Number is missing"));

            List<TransactionProduct> result = dataAccess.fetchTransactionProducts(datetime, cardNumber);
            return format.generateRepresentationTransactionProducts(result);
        }
        catch (IllegalArgumentException e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}