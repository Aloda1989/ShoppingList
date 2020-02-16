package ShoppingList.consoleui;

import ShoppingList.domain.Category;
import ShoppingList.domain.Product;
import ShoppingList.domain.ProductService;
import ShoppingList.validation.DiscountValidation;
import ShoppingList.validation.NameValidationRule;
import ShoppingList.validation.PriceValidation;
import ShoppingList.validation.ProductValidationException;

import java.math.BigDecimal;
import java.util.List;

public class ConsoleUi {
    private ProductService productService;
    private static ScannerInput ScannerInput;

    public ConsoleUi(ProductService productService, ScannerInput keyboardInput) {
        this.productService = productService;
        ScannerInput = keyboardInput;

    }

    private static Category getCategoryByMenu() {
        Category category = Category.Laptops;
        TextMessage.checkingCategoryText();
        Category.printCategoryList();

        int userChose = ScannerInput.getUserNumberInput();
        if (userChose < Category.getCategoryList().size()) {
            category = (Category) Category.getCategoryList().get(userChose);
        }
        return category;
    }

    private void createNewProduct() {

        String name = getProductName();
        BigDecimal priceBD = getProductPrice();
        BigDecimal discount = getProductDiscount();

        Product newProduct = productService.createProduct(name, priceBD, discount);
        productService.writeProductInDataBase(newProduct);

        if (!(newProduct == Product.emptyProduct)) {
            setCategory(productService, newProduct);
            setDescription(newProduct);
            System.out.println("Product have been created: ");
            System.out.println(newProduct.toString());
        }
    }

    private BigDecimal getProductDiscount() {
        BigDecimal discount = new BigDecimal("0");

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("Enter discount for product in 0.00 format!");
                discount = ScannerInput.getKeyboardInputBigDecimal();

                DiscountValidation.validate(discount);
                correctInput = true;
            } catch (ProductValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return discount;
    }

    private BigDecimal getProductPrice() {
        BigDecimal priceBD = new BigDecimal("0");

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("Enter product price in 0.00 format!");
                priceBD = ScannerInput.getKeyboardInputBigDecimal();
                PriceValidation.validate(priceBD);
                correctInput = true;
            } catch (ProductValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return priceBD;
    }

    private String getProductName() {
        String name = "";

        boolean correctInput = false;
        while (!correctInput) {
            try {
                System.out.println("Enter product name!");
                name = ScannerInput.getKeyboardInputLine();
                NameValidationRule.validate(name);
                correctInput = true;
            } catch (ProductValidationException f) {
                System.out.println(f.getMessage());
                correctInput = false;
            }
        }
        return name;
    }

    private void setDescription(Product product) {

        TextMessage.descriptionTextQuestion();

        int userChose = ScannerInput.getUserNumberInput();
        if (userChose > 0) {
            setProductDescription(product);
        }

    }

    private void setCategory(ProductService productService, Product product) {

        TextMessage.settingCategoryTextQuestion();


        int userChose = ScannerInput.getUserNumberInput();
        if (userChose > 0) {
            Category category = getCategoryByMenu();
            productService.setProductCategory(product, category);
        }

    }

    private void setProductDescription(Product product) {

        TextMessage.descriptionTextSetting();

        String description = ScannerInput.getKeyboardInputLine();
        productService.setProductDescription(product, description);

    }

    private void getProductInformation() {

        Product receivedProduct = getProductAcrossMenu();

        if (!(receivedProduct == Product.emptyProduct)) {
            System.out.println(receivedProduct.toString());
        } else {
            System.out.println("Empty Product, please input different number!");
        }

    }

    private Product getProductAcrossMenu() {

        Product receivedProduct;
        TextMessage.gettingProductTextQuestion();


        int userChose = ScannerInput.getUserNumberInput();
        if (userChose == 1) {
            System.out.println("Enter product ID to search");
            Long iD = (long) ScannerInput.getUserNumberInput();

            receivedProduct = productService.getProductFromDataBase(iD);
        } else {
            System.out.println("Enter product name to search");
            String productName = ScannerInput.getKeyboardInputLine();
            receivedProduct = productService.getProductFromDataBase(productName);
        }
        return receivedProduct;
    }

    private void deleteSelectedProduct() {
        TextMessage.productSelectingToDeleteText();
        Product productToDelete = getProductAcrossMenu();

        if (!(productToDelete == Product.emptyProduct)) {
            productService.deleteProductFromDataBase(productToDelete);
            System.out.println("Product " + productToDelete.toString() + " was deleted");
        } else {
            System.out.println("Empty Product, please input different number!");
        }

    }

    private void getProductListByCategory() {
        Category category = getCategoryByMenu();
        List<Product> productList = productService.getProductList(category);
        System.out.println(productList.toString());
    }

    public void mainUserMenu() {
        int userMenuChose = 1;
        while (userMenuChose >= 1 && userMenuChose <= 4) {
            TextMessage.userMenu();

            userMenuChose = ScannerInput.getUserNumberInput();

            if (userMenuChose == 1) {
                createNewProduct();
            } else if (userMenuChose == 2) {
                getProductInformation();
            } else if (userMenuChose == 3) {
                getProductListByCategory();
            } else if (userMenuChose == 4) {
                deleteSelectedProduct();
            }

        }
    }

}
