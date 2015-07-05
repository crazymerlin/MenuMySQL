package engine;

import java.util.ArrayList;

public class Meals {
    private static ArrayList<Meal> mealList = new ArrayList<Meal>();

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(ArrayList<Meal> mealList) {
        this.mealList = mealList;
    }

    public String toString() {
        String output = "";
        for (Meal currentMeal : mealList) {
            output += "[" + currentMeal.toString() + "]" + "\n";
        }
        return output;
    }

    public void addMeal (Meal meal)
    {
        this.mealList.add(meal);
    }
}
