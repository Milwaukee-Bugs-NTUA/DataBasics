package gr.ntua.ece.databasics.api.resource;

import gr.ntua.ece.databasics.api.representation.JsonMapRepresentation;
import gr.ntua.ece.databasics.conf.Configuration;
import gr.ntua.ece.databasics.data.DataAccess;
import gr.ntua.ece.databasics.data.DataAccessException;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.util.Map;

public class HealthCheck extends ServerResource {

    private final DataAccess dataAccess = Configuration.getInstance().getDataAccess();

    @Override
    protected Representation get() throws ResourceException {

        try {
            System.out.println("Reached healthcheck class");
            dataAccess.accessDataCheck();
            return new JsonMapRepresentation(Map.of("status", "OK"));
        }
        catch(DataAccessException e) {
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL, "Data access exception: " + e.getMessage(), e);
        }


    }
}
