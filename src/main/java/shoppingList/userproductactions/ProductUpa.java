package shoppingList.userproductactions;

import shoppingList.entity.Product;
import shoppingList.model.PaginationResult;
import shoppingList.model.ProductInfo;

public interface ProductUpa {
    public Product findProduct(String code);

    public ProductInfo findProductInfo(String code);

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

    public void save(ProductInfo productInfo);
}
