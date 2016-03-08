package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * Created by Brother on 06.03.2016.
 */
public interface MealDao {
    public List<UserMeal> findAll();
    public void update(UserMeal userMeal);
    public void create(UserMeal user);
    public void delete(Integer id);
}
