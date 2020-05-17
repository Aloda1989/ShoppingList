//package shoppingList.validation;
//
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//
//@Component
//public class DiscountValidation {
//    public static void validate(BigDecimal productDiscount) throws ProductValidationException {
//
//        if (productDiscount.intValue() < 0 || productDiscount.intValue() > 100) {
//            throw new ProductValidationException("Discount cannot be more than 100 percent!");
//        }
//
//    }
//}
