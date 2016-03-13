package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * GKislin
 * 15.06.2015.
 */
public interface UserMealService {
    public List<UserMeal> getAll();
    public void update(UserMeal userMeal);
    public UserMeal save(UserMeal userMeal);
    public void create(UserMeal userMeal);
    public void delete(Integer id);
}
