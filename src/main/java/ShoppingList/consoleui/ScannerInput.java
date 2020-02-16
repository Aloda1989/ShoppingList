package ShoppingList.consoleui;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScannerInput {
    private static String deleteLettersAndSymbols(String userChoose) {

        String stringNumber = userChoose.replaceAll("[^-0-9]", "");
        if (stringNumber.isEmpty()) {
            return "0";
        }
        return stringNumber;
    }

    public int getUserNumberInput() {

        Scanner keyReader = new Scanner(System.in);
        String userChose = keyReader.nextLine();

        return Integer.parseInt(deleteLettersAndSymbols(userChose));
    }

    public String getKeyboardInputLine() {

        Scanner keyReader = new Scanner(System.in);

        return keyReader.nextLine();
    }

    public BigDecimal getKeyboardInputBigDecimal() {

        boolean correctInput = false;
        BigDecimal number = new BigDecimal(0);
        while (!correctInput) {
            try {
                Scanner keyReader = new Scanner(System.in);
                String stringNumber = keyReader.nextLine();
                number = new BigDecimal(stringNumber);
                correctInput = true;
            } catch (NumberFormatException f) {
                System.out.println("Bad format! Please enter number in format like 0.00!");
                correctInput = false;
            }
        }
        return number;
    }
}
