package shoppingList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import shoppingList.consoleui.ConsoleUi;
import shoppingList.consoleui.TextMessage;

@Component
public class ShoppingList {
    public static void main(String[] args) {

        TextMessage.startOfProgram();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUi consoleUi = context.getBean(ConsoleUi.class);
        consoleUi.mainUserMenu();
        TextMessage.endOfProgram();

    }
}
