package gr.ntua.ece.databases.api.representation;

import org.restlet.representation.Representation;
import gr.ntua.ece.databases.data.model.*;

import java.util.List;

public interface RepresentationGenerator {
    Representation generateRepresentationUserProfile(User result);
    Representation generateRepresentationStores(List<Store> result);
    Representation generateRepresentationStorePage(Store result);
    Representation generateRepresentationUsers(List<User> result);
    Representation generateRepresentationProducts(List<Product> resut);
    Representation generateRepresentationProduct(Product result);
    Representation generateRepresentationPriceHistory(List<PriceHistory> result);
    Representation generateRepresentationUserInfo(UserInfo result);
    Representation generateRepresentationTransactions(List<Transaction> result);
    Representation generateRepresentationTransactionProducts(List<TransactionProduct> result);
    Representation generateRepresentationProductsStatistics(ProductsStatistics result);
    Representation generateRepresentationUsersStatistics(UsersStatistics result);
}
