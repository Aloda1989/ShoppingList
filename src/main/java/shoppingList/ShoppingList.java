package shoppingList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shoppingList.consoleui.ConsoleUi;
import shoppingList.consoleui.TextMessage;

public class ShoppingList {
    public static void main(String[] args) {

        //BasicConfigurator.configure();
        TextMessage.startOfProgram();
        ApplicationContext context;
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUi consoleUi = context.getBean(ConsoleUi.class);
        consoleUi.mainUserMenu();
        TextMessage.endOfProgram();

    }
}

//        private final String driverName = "com.mysql.cj.jdbc.Driver";
//        private final String connectionString = "jdbc:mysql://localhost:3306";
//        private final String login = "Andrew";
//        private final String password = "Allodasan1989";
//        public void run () {
//            try {
//                Class.forName(driverName);
//            } catch (ClassNotFoundException e) {
//                System.out.println("Can't get class. No driver found");
//                e.printStackTrace();
//                return;
//            }
//            Connection connection = null;
//            try {
//                connection = DriverManager.getConnection(connectionString, login, password);
//            } catch (SQLException e) {
//                System.out.println("Can't get connection. Incorrect URL");
//                e.printStackTrace();
//                return;
//            }
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.out.println("Can't close connection");
//                e.printStackTrace();
//                return;
//            }
//            System.out.println("ok");
//        }
//        public static void main (String[]args){
//            ShoppingList sp = new ShoppingList();
//            sp.run();
//        }
//    }
//https://github.com/javagurualex/javaguru-java-2-todolist.git