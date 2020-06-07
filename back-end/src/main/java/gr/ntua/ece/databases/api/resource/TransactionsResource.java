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
import java.util.List;
import java.sql.Date;
import java.util.Optional;

public class TransactionsResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Read the mandatory URI attributes
        Long storeId = Long.valueOf(getMandatoryAttribute("StoreId", "StoreId is missing"));
        String date1 = getMandatoryAttribute("startingDate", "Starting Date is missing");
        System.out.println("Resource file " + date1);
        Date startingDate = Date.valueOf(date1);
        Date endingDate = Date.valueOf(getMandatoryAttribute("endingDate", "Ending Date is missing"));
        String paymentMethod = getMandatoryAttribute("paymentMethod", "Payment method is missing");
        Integer numPrdLow = Integer.parseInt(getMandatoryAttribute("numPrdLow", "Low Threshold is missing"));
        Integer numPrdHigh = Integer.parseInt(getMandatoryAttribute("numPrdHigh", "High Threshold is missing"));

        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            List<Transaction> result = dataAccess.fetchTransactions(storeId, startingDate, endingDate, paymentMethod, numPrdLow, numPrdHigh);
            return format.generateRepresentationTransactions(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}

//{StoreId}/transactions/startingDate/{startingDate}/endingDate/{endingDate}/paymentMethod/{paymentMethod}/numPrdLow/{numPrdLow}/numPrdHigh/{numPrdHigh}"