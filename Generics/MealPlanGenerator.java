import java.util.*;

interface MealPlan {

    void mealName();
}

class VegetarianMeal implements MealPlan {

    public void mealName() {
        System.out.println("Vegetarian Meal");
    }
}

class VeganMeal implements MealPlan {

    public void mealName() {
        System.out.println("Vegan Meal");
    }
}

class KetoMeal implements MealPlan {

    public void mealName() {
        System.out.println("Keto Meal");
    }
}

// Generic Class
class Meal<T extends MealPlan> {

    T meal;

    Meal(T meal) {
        this.meal = meal;
    }

    void display() {
        meal.mealName();
    }
}

public class MealPlanGenerator {

    // Generic Method
    static <T extends MealPlan> void generateMeal(T meal) {

        meal.mealName();
        System.out.println("Meal Generated Successfully");
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> meal =
                new Meal<>(new VegetarianMeal());

        meal.display();

        generateMeal(new VegetarianMeal());
    }
}