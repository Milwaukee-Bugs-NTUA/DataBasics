package gr.ntua.ece.databases.api;

import com.google.gson.stream.JsonWriter;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.WriterRepresentation;
import org.restlet.resource.ResourceException;

import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.util.List;
import java.util.function.Consumer;

import gr.ntua.ece.databases.data.model.*;
import gr.ntua.ece.databases.api.representation.RepresentationGenerator;

public enum Format implements RepresentationGenerator {
    JSON {
        public Representation generateRepresentationUserProfile(User user) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginObject(); // {
                    w.name("CardNumber").value(Long.toString(user.getCardNumber()));
                    w.name("Email").value(user.getEmail());
                    w.name("FirstName").value(user.getFirstName());
                    w.name("LastName").value(user.getLastName());
                    w.name("DateOfBirth").value(String.valueOf(user.getDateOfBirth()));
                    w.name("Sex").value(String.valueOf(user.getSex()));
                    w.name("AddressStreet").value(user.getAddressStreet());
                    w.name("AddressNumber").value(Integer.toString(user.getAddressNumber()));
                    w.name("AddressPostalCode").value(user.getAddressPostalCode());
                    w.name("AddressCity").value(user.getAddressCity());
                    w.name("PhoneNumber").value(user.getPhoneNumber());
                    w.name("MaritalStatus").value(String.valueOf(user.getMaritalStatus()));
                    w.name("NumberOfChildren").value(Integer.toString(user.getNumberOfChildren()));
                    w.name("Points").value(Integer.toString(user.getPoints()));
                    w.endObject(); // }
                    w.flush();
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationStores(List<Store> result) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                   w.beginArray(); // [
                    for(Store rec: result) {
                        w.beginObject(); // {
                        w.name("Store_Id").value(rec.getStoreID());
                        w.name("City").value(rec.getAddressCity());                 
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationStoreHomepage(Store store) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginObject(); // {
                    w.name("Store_Id").value(Long.toString(store.getStoreID()));
                    w.name("Size").value(Integer.toString(store.getSize()));
                    w.name("AddressCity").value(store.getAddressCity());
                    w.name("AddressValue").value(Integer.toString(store.getAddressNumber()));
                    w.name("AddressPostalCode").value(store.getAddressPostalCode());
                    w.name("OpeningHour").value(String.valueOf(store.getClosingHour()));
                    w.name("ClosingHour").value(String.valueOf(store.getClosingHour()));
                    w.endObject(); // }
                    w.flush();
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }


    };
    private static final class CustomJsonRepresentation extends WriterRepresentation {

        private final Consumer<JsonWriter> consumer;

        CustomJsonRepresentation(Consumer<JsonWriter> consumer) {
            super(MediaType.APPLICATION_JSON);
            this.consumer = consumer;
        }

        @Override
        public void write(Writer writer) throws IOException {
            JsonWriter jsonWriter = new JsonWriter(writer);
            consumer.accept(jsonWriter);
        }
    }
}
