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
import org.restlet.data.Form;


import gr.ntua.ece.databases.data.model.User;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public class UserProfileResource extends DatastoreResource {
    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        // Read the mandatory URI attributes
        Long userId = Long.valueOf(getMandatoryAttribute("UserId", "UserId is missing"));
        // Our platfom supports only JSON formating
        Format format = Format.valueOf("JSON");

        try {
            User result = dataAccess.fetchUserProfile(userId);
            return format.generateRepresentationUserProfile(result);
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation put(Representation entity) throws ResourceException {

        // Specify barcode of product
        Form form = new Form(entity);
        String email = form.getFirstValue("E-mail");
        String firstName = form.getFirstValue("First Name");
        String lastName = form.getFirstValue("Last Name");
        Date dateOfBirth = Date.valueOf(form.getFirstValue("Date of Birth"));
        String sex = form.getFirstValue("Sex");
        String addressCity = form.getFirstValue("Address City");
        String addressStreet = form.getFirstValue("Address Street");
        Integer addressNumber = Integer.valueOf(form.getFirstValue("Address Number"));
        String addressPostalCode = form.getFirstValue("Address Postal Code");
        String phoneNumber = form.getFirstValue("Phone Number");
        String maritalStatus = form.getFirstValue("Marital Status");
        Integer numberOfChildren = Integer.valueOf(form.getFirstValue("Number of Children"));
        Integer points = Integer.valueOf(form.getFirstValue("points"));


        try {
            dataAccess.updateUserProfile(email,firstName,lastName,dateOfBirth,sex,addressCity,addressStreet,addressNumber,addressPostalCode,phoneNumber,maritalStatus,numberOfChildren,points);
            return new JsonMapRepresentation(Map.of("status", "OK"));
        }
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }

    @Override
    protected Representation delete() throws ResourceException {

        // Read the mandatory URI attributes
        Long userId = Long.valueOf(getMandatoryAttribute("UserId", "UserId is missing"));

        try {
            dataAccess.deleteUser(userId);
            return new JsonMapRepresentation(Map.of("status", "OK"));
        } 
        catch (Exception e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, e.getMessage(), e);
        }

    }
}