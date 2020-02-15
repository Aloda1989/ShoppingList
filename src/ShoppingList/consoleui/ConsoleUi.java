package consoleui;

import domain.Product;
import service.ProductService;

import java.util.Scanner;

public class ConsoleUi {
    private ProductService productService = new ProductService();

    public void output() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create task");
                System.out.println("2. Find task by id");
                System.out.println("3. Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProduct();
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task Id: ");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);

        Long id = productService.createProduct(product);
        System.out.println("Result: " + id);
    }

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task id: ");
        Long id = scanner.nextLong();
        Product product = productService.findProductById();
        System.out.println(product);
    }

}
