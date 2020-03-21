package shoppingList;

import org.springframework.stereotype.Component;
import shoppingList.consoleui.ConsoleUi;
import shoppingList.consoleui.ProductService;
import shoppingList.consoleui.ScannerInput;
import shoppingList.repository.ProductInMemory;

@Component
public class DIHelper {
    public static ConsoleUi createApplication() {

        ProductInMemory productInMemory = new ProductInMemory();
        ProductService productService = new ProductService(productInMemory);
        ScannerInput scannerInput = new ScannerInput();
        return new ConsoleUi(productService, scannerInput);

    }
}
