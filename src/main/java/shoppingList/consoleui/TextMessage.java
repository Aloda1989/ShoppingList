package shoppingList.consoleui;

import org.springframework.stereotype.Component;

@Component
public class TextMessage {
    public static void endOfProgram() {
        System.out.println("Thank you for your cooperation");
    }

    public static void startOfProgram() {
        System.out.println("Welcome to Shopping App.");
    }

    public static void userMenu() {

        System.out.println("Select one of the option bellow to start!");
        System.out.println("Enter 1 to create a Product");
        System.out.println("Enter 2 to get Product by ID or Name");
        System.out.println("Enter 3 to retrieve Product List");
        System.out.println("Enter 4 to delete Product by ID or Name ");
        System.out.println("Enter 5 to end using Application");


    }

    public static void descriptionTextQuestion() {
        System.out.println("Description of Product!");
        System.out.println("Enter 1 to create description for Product");
        System.out.println("Enter 0 for creating without description");
    }

    public static void descriptionTextSetting() {
        System.out.println("Enter Description Below!");
    }


    public static void gettingProductTextQuestion() {
        System.out.println("Product search!");
        System.out.println("Enter 1 to search Product by ID");
        System.out.println("Enter 2 to search Product by Name");

    }

    public static void settingCategoryTextQuestion() {
        System.out.println("Set category for Product");
        System.out.println("Enter 1 if you want to set Product category");
        System.out.println("Enter 0 for decline setting category");
    }

    public static void checkingCategoryText() {
        System.out.println("Check Category!");
    }

    public static void productSelectingToDeleteText() {
        System.out.println("Select Product for deleting!");
    }
}
