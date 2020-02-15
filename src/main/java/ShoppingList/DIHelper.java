package ShoppingList;

import ShoppingList.consoleui.ConsoleUi;
import ShoppingList.consoleui.ScannerInput;
import ShoppingList.domain.Product;
import ShoppingList.domain.ProductService;

public class DIHelper {
    public static ConsoleUi createApplication() {

        Product product = new Product();
        ProductService productService = new ProductService(product);
        ScannerInput scannerInput = new ScannerInput();
        return new ConsoleUi(productService, scannerInput);

    }
}
