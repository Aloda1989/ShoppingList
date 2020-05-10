package shoppingList.consoleui.user;

import org.springframework.stereotype.Component;
import shoppingList.domain.User;
import shoppingList.service.UserService;

import java.util.Scanner;

@Component
public class CreateUserAction {

    private static final String ACTION_NAME = "Create user";

    private UserService userService;

    public CreateUserAction(UserService userService) {
        this.userService = userService;
    }

    public CreateUserAction() {

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user login:");
        String name = scanner.nextLine();
        System.out.println("Enter user password: ");
        String description = scanner.nextLine();

        User user = new User();
        user.setLogin(name);
        user.setPassword(description);

        Long response = userService.createUser(user);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}