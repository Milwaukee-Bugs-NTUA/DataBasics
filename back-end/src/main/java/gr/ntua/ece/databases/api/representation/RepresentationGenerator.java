package gr.ntua.ece.databases.api.representation;

import org.restlet.representation.Representation;
import gr.ntua.ece.databases.data.model.*;

import java.util.List;

public interface RepresentationGenerator {
    Representation generateRepresentationUserProfile(User result);
    Representation generateRepresentationStores(List<Store> result);
    Representation generateRepresentationStoreHomepage(Store result);
    Representation generateRepresentationUsersIndex(List<User> result);
    Representation generateRepresentationProductsIndex(List<Product> resut);
    Representation generateRepresentationProductResource(Product result);
    Representation generateRepresentationPriceHistoryResource(List<PriceHistory> result);
    Representation generateRepresentationUserInfo(UserInfo result);
}
