import java.util.*;

class Category {
    String name;

    Category(String name) {
        this.name = name;
    }
}

class BookCategory extends Category {
    BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends Category {
    ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends Category {
    GadgetCategory() {
        super("Gadgets");
    }
}

// Generic Class
class Product<T extends Category> {

    String productName;
    double price;
    T category;

    Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    void display() {
        System.out.println(productName + " " + price + " " + category.name);
    }
}

public class DynamicMarketplace {

    // Generic Method
    static <T extends Product<?>> void applyDiscount(T product, double percentage) {

        product.price = product.price - (product.price * percentage / 100);
    }

    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Book", 500, new BookCategory());

        applyDiscount(book, 10);

        book.display();
    }
}