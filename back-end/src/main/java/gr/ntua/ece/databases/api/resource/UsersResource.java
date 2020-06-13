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

import gr.ntua.ece.databases.data.model.User;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.sql.Date;
import java.util.Optional;
import java.util.Map;
import org.restlet.data.Form;

public class UsersResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            List<User> result = dataAccess.fetchUsers();
            return format.generateRepresentationUsers(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation post(Representation entity) throws ResourceException {

        Form form = new Form(entity);
        String email = form.getFirstValue("Email");
        String firstName = form.getFirstValue("FirstName");
        String lastName = form.getFirstValue("LastName");        
        Date dateOfBirth = Date.valueOf(form.getFirstValue("DateOfBirth"));
        String sex = form.getFirstValue("Sex");
        String addressCity = form.getFirstValue("AddressCity");
        String addressStreet = form.getFirstValue("AddressStreet");
        Integer addressNumber = Integer.valueOf(form.getFirstValue("AddressNumber"));
        String addressPostalCode = form.getFirstValue("AddressPostalCode");
        String phoneNumber = form.getFirstValue("PhoneNumber");
        String maritalStatus = form.getFirstValue("MaritalStatus");
        Integer numberOfChildren = Integer.valueOf(form.getFirstValue("NumberOfChildren"));
        Integer points = Integer.valueOf(form.getFirstValue("Points"));
       
        try {
            dataAccess.addUser(
                                email,
                                firstName,
                                lastName,
                                dateOfBirth,
                                sex,
                                addressCity,
                                addressStreet,
                                addressNumber,
                                addressPostalCode,
                                phoneNumber,
                                maritalStatus,
                                numberOfChildren,
                                points
                                );
            return new JsonMapRepresentation(Map.of("status", "OK"));
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

}