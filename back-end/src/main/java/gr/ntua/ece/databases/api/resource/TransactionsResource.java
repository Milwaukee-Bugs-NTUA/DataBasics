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

import gr.ntua.ece.databases.data.model.UserInfo;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TransactionsResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Read the mandatory URI attributes
        Long storeId = Long.valueOf(getMandatoryAttribute("storeId", "StoreId is missing"));
        String startingDate = getMandatoryAttribute("startingDate", "startingDate is missing");
        String endingDate = getMandatoryAttribute("endingDate", "EndingDate is missing");
        String paymentMethod = getMandatoryAttribute("paymentMethod", "Payment method is missing");
        String numPrdLow = getMandatoryAttribute("numPrdLow", "NumberPrdLow is missing");
        String numPrdHigh = getMandatoryAttribute("numPrdHigh", "NumberPrdHigh is missing");

        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            UserInfo result = dataAccess.fetchTransactionsResource(storeId, startingDate, endingDate, paymentMethod, numPrdLow, numPrdHigh);
            return format.generateRepresentationTransactionsResource(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}

//{StoreId}/transactions/startingDate/{startingDate}/endingDate/{endingDate}/paymentMethod/{paymentMethod}/numPrdLow/{numPrdLow}/numPrdHigh/{numPrdHigh}"