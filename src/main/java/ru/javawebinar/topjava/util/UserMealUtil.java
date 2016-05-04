package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealTo;
import ru.javawebinar.topjava.to.UserTo;

import java.time.LocalDateTime;

/**
 * Created by admin_DKRS on 29.04.16.
 */
public class UserMealUtil {
    public static UserMeal createFromTo(UserMealTo newUserMeal) {
        return new UserMeal(null, newUserMeal.getDateTime(), newUserMeal.getDescription(), newUserMeal.getCalories());
    }

    public static UserMeal updateFromTo(UserMeal meal, UserMealTo mealTo) {
        meal.setCalories(mealTo.getCalories());
        meal.setDateTime(mealTo.getDateTime());
        meal.setDescription(mealTo.getDescription());
        return meal;
    }
}