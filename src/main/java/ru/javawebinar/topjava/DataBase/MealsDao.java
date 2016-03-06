package ru.javawebinar.topjava.DataBase;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.util.List;

/**
 * Created by Brother on 06.03.2016.
 */
public interface MealsDao {
    public List<UserMealWithExceed> findAll();
}
