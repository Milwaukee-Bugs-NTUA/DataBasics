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
                        w.name("StoreId").value(rec.getStoreID());
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

        public Representation generateRepresentationStorePage(Store store) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginObject(); // {
                    w.name("StoreId").value(Long.toString(store.getStoreID()));
                    w.name("Size").value(Integer.toString(store.getSize()));
                    w.name("AddressCity").value(store.getAddressCity());
                    w.name("AddressStreet").value(store.getAddressStreet());
                    w.name("AddressNumber").value(Integer.toString(store.getAddressNumber()));
                    w.name("AddressPostalCode").value(store.getAddressPostalCode());
                    w.name("OpeningHour").value(String.valueOf(store.getOpeningHour()));
                    w.name("ClosingHour").value(String.valueOf(store.getClosingHour()));
                    w.endObject(); // }
                    w.flush();
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationUsers(List<User> result) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                   w.beginArray(); // [
                    for(User rec: result) {
                        w.beginObject(); // {
                        w.name("CardNumber").value(Long.toString(rec.getCardNumber()));
                        w.name("FirstName").value(rec.getFirstName());
                        w.name("LastName").value(rec.getLastName());
                        w.name("Email").value(rec.getEmail());                
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }


        public Representation generateRepresentationProducts(List<Product> result) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                   w.beginArray(); // [
                    for(Product rec: result) {
                        w.beginObject(); // {
                        w.name("Barcode").value(Long.toString(rec.getBarcode()));
                        w.name("ProductName").value(rec.getName());
                        w.name("ProductBrandName").value(rec.getBrandName());
                        w.name("Price").value(Float.toString(rec.getPrice()));                
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationProduct(Product product){
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginObject(); // {
                    w.name("Barcode").value(Long.toString(product.getBarcode()));
                    w.name("ProductName").value(product.getName());
                    w.name("ProductBrandName").value(product.getBrandName());
                    w.name("Price").value(Float.toString(product.getPrice()));
                    w.name("CategoryId").value(Long.toString(product.getCategoryId()));
                    w.name("CategoryName").value(product.getCategoryName());                    
                    w.endObject(); // }
                    w.flush();
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationPriceHistory(List<PriceHistory> result) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginArray(); // [
                    for(PriceHistory rec: result) {
                        w.beginObject(); // {
                        w.name("Barcode").value(Long.toString(rec.getBarcode()));
                        w.name("StartingDate").value(String.valueOf(rec.getStartingDate()));
                        w.name("EndingDate").value(String.valueOf(rec.getEndingDate()));
                        w.name("Price").value(Float.toString(rec.getOldPrice()));                
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }


        public Representation generateRepresentationUserInfo(UserInfo userInfo) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginObject(); // {
                    w.name("MeanTransactionsPW").value(Float.toString(userInfo.getMeanTransactionsPerWeek()));
                    w.name("MeanTransactionsPM").value(Float.toString(userInfo.getMeanTransactionsPerMonth()));
                    w.name("CommonStores");
                    w.beginArray(); // [
                    for(CommonStore uinf: userInfo.getCommonStores()) {
                        w.beginObject(); // {
                        w.name("StoreId").value(Long.toString(uinf.getStoreID()));
                        w.name("StoreName").value(uinf.getStoreName());
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                    w.name("CommonProducts");
                    w.beginArray(); // [
                    for(CommonProduct uinf: userInfo.getCommonProducts()) {
                        w.beginObject(); // {
                        w.name("Barcode").value(Long.toString(uinf.getBarcode()));
                        w.name("ProductName").value(uinf.getProductName());
                        w.name("BrandName").value(uinf.getBrandName());
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                    w.endObject(); // }
                    w.flush();
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationUserInfoHappyHour(List<HappyHour> result) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginObject(); // {
                    w.name("HappyHour");
                    w.beginArray(); // [
                        for(HappyHour rec: result) {
                            w.beginObject(); // {
                            w.name("Hour").value(Integer.toString(rec.getHour()));
                            w.name("Count").value(Float.toString(rec.getCount()));
                            w.endObject(); // }
                            w.flush();
                        }
                    w.endArray(); // ]
                    w.endObject(); // }
                    w.flush();
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationTransactions(List<Transaction> result) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginArray(); // [
                    for(Transaction rec: result) {
                        w.beginObject(); // {
                        w.name("Datetime").value(String.valueOf(rec.getDatetime()));
                        w.name("CardNumber").value(Long.toString(rec.getCardNumber()));
                        w.name("TotalCost").value(Float.toString(rec.getTotalCost()));
                        w.name("PaymentMethod").value(String.valueOf(rec.getPaymentMethod()));
                        w.name("PurchasedFrom").value(rec.getPurchasedFrom());
                        w.name("NumberOfProducts").value(Integer.toString(rec.getNumberOfProducts()));
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationTransactionProducts(List<TransactionProduct> result) {
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginArray(); // [
                    for(TransactionProduct rec: result) {
                        w.beginObject(); // {
                        w.name("Barcode").value(Long.toString(rec.getBarcode()));
                        w.name("ProductName").value(rec.getProductName());
                        w.name("BrandName").value(rec.getBrandName());
                        w.name("Pieces").value(Integer.toString(rec.getPieces()));
                        w.endObject(); // }
                        w.flush();
                    }
                    w.endArray(); // ]
                } catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationProductsStatistics(ProductsStatistics result){
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginObject(); // {
                    w.name("TopProductsPairs");
                    w.beginArray();
                    for (ProductsPair pair: result.getTopProductsPairs()) {
                        w.beginObject();
                        w.name("FirstBarcode").value(Long.toString(pair.getBarcode1()));
                        w.name("FirstProductName").value(pair.getProductName1());
                        w.name("FirstBrandName").value(pair.getBrandName1());
                        w.name("SecondBarcode").value(Long.toString(pair.getBarcode2()));
                        w.name("SecondProductName").value(pair.getProductName2());
                        w.name("SecondBrandName").value(pair.getBrandName2());
                        w.endObject();
                        w.flush();
                    }
                    w.endArray();
                    w.flush();
                    w.name("TopProductsPlacements");
                    w.beginArray();
                    for (ProductPlacement placement: result.getTopProductsPlacements()) {
                        w.beginObject();
                        w.name("AlleyNumber").value(placement.getAlleyNumber());
                        w.name("SelfNumber").value(placement.getSelfNumber());
                        w.endObject();
                        w.flush();
                    }
                    w.endArray();
                    w.flush();
                    w.name("DatastoreBrandSuccess");
                    w.beginArray();
                    for (PercentageOfSuccess percentage: result.getPercentageOfSuccessInEachCategory()) {
                        w.beginObject();
                        w.name("CategoryId").value(Long.toString(percentage.getCategoryId()));
                        w.name("CategoryName").value(percentage.getCategoryName());
                        w.name("Percentage").value(Float.toString(percentage.getPercentage()));
                        w.endObject();
                        w.flush();
                    }
                    w.endArray();
                    w.endObject(); // }
                    w.flush();
                }
                catch (IOException e) {
                    throw new ResourceException(Status.SERVER_ERROR_INTERNAL);
                }
            });
        }

        public Representation generateRepresentationUsersStatistics(UsersStatistics result){
            return new CustomJsonRepresentation((JsonWriter w) -> {
                try {
                    w.beginObject(); // {
                    w.name("HourZonewithmaximumsales").value(Integer.toString(result.getMaximumSalesHourZone()));
                    w.flush();
                    w.name("PercentagesperAgeandHourZone");
                    w.beginArray();
                    for(PercentagesPerHour pph: result.getPercentagesPerHour()){
                        w.beginObject();
                        w.name("HourZone").value(Integer.toString(pph.getHourZone()));
                        w.name("YoungPercentages").value(Float.toString(pph.getPercentageOfYoung()));
                        w.name("MiddlePercentages").value(Float.toString(pph.getPercentageOfMiddle()));
                        w.name("ElderPercentages").value(Float.toString(pph.getPercentageOfElder()));
                        w.endObject();
                        w.flush();
                    }
                    w.endArray();
                    w.flush();
                    w.name("ParentalTransactions");
                    w.beginObject(); // {
                        w.name("ParentPercentage").value(Float.toString(result.getParentalTransactions().getPercentageOfParents()));
                        w.name("NonParentPercentage").value(Float.toString(result.getParentalTransactions().getPercentageOfNonParents()));
                    w.endObject(); // }
                    w.flush();
                    w.name("MaritalTransactions");
                    w.beginArray();
                    for(UsersMaritalTransactions mp: result.getMaritalTransactions()){
                        w.beginObject();
                        w.name("MaritalStatus").value(mp.getMaritalStatus());
                        w.name("Percentage").value(Float.toString(mp.getPercentage()));
                        w.endObject();
                        w.flush();
                    }
                    w.endArray();
                    w.endObject();
                    w.flush();
                }
                catch (IOException e) {
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
