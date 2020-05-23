package gr.ntua.ece.databases.api.resource;

import gr.ntua.ece.databases.api.Format;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Optional;

public class DatastoreResource extends ServerResource {

    private static final String EMPTY_STRING = "";
    
    protected String getAttributeDecoded(String attr) {
        String value = getAttribute(attr);
        return value == null ?  null : sanitize(URLDecoder.decode(value, StandardCharsets.UTF_8));
    }

    protected String getMandatoryAttribute(String attr, String message) {
        String value = getAttributeDecoded(attr);
        if (value.length() == 0) {
            throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, message);
        }
        return value;
    }

    static String sanitize(String s) {
        return s == null ? EMPTY_STRING : s.trim();
    }

}
