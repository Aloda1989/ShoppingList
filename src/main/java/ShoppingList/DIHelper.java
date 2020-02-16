package ShoppingList;

import ShoppingList.consoleui.ConsoleUi;
import ShoppingList.consoleui.ScannerInput;
import ShoppingList.domain.ProductService;
import ShoppingList.repository.ProductInMemory;

public class DIHelper {
    public static ConsoleUi createApplication() {

        ProductInMemory productInMemory = new ProductInMemory();
        ProductService productService = new ProductService(productInMemory);
        ScannerInput scannerInput = new ScannerInput();
        return new ConsoleUi(productService, scannerInput);

    }
}
