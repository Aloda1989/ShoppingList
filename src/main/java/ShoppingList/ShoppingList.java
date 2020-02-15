package ShoppingList;

import ShoppingList.consoleui.ConsoleUi;
import ShoppingList.consoleui.TextMessage;

public class ShoppingList {
    public static void main(String[] args) {

        TextMessage.userWelcome();
        ConsoleUi consoleUi = DIHelper.createApplication();
        consoleUi.mainUserMenu();
        TextMessage.goodbyeToTheUser();

    }
}
