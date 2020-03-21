package shoppingList.domain;
import java.util.ArrayList;
import java.util.List;

public enum Category {
    Laptops,
    PC,
    Accessories,
    TV,
    Audio,
    Games,
    Phones,
    Video;

    public static List<Category> getCategoryList() {

        List<Category> categories = new ArrayList<>();
        categories.add(Laptops);
        categories.add(PC);
        categories.add(Accessories);
        categories.add(TV);
        categories.add(Audio);
        categories.add(Games);
        categories.add(Phones);
        categories.add(Video);
        return categories;

    }

    public static void printCategoryList() {

        List<Category> categories = getCategoryList();

        System.out.println("" + categories.indexOf(Laptops) + " = " + Laptops);
        System.out.println("" + categories.indexOf(PC) + " = " + PC);
        System.out.println("" + categories.indexOf(Accessories) + " = " + Accessories);
        System.out.println("" + categories.indexOf(TV) + " = " + TV);
        System.out.println("" + categories.indexOf(Audio) + " = " + Audio);
        System.out.println("" + categories.indexOf(Games) + " = " + Games);
        System.out.println("" + categories.indexOf(Phones) + " = " + Phones);
        System.out.println("" + categories.indexOf(Video) + " = " + Video);

    }
}
