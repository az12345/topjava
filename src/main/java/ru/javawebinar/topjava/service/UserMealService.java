package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * GKislin
 * 15.06.2015.
 */
public interface UserMealService {
    public List<UserMeal> getAll(int userId);
    public UserMeal get(int id);
    public UserMeal get(int id, int userId) throws NotFoundException;
    public UserMeal update(UserMeal userMeal);
    public UserMeal update(UserMeal userMeal, int userId) throws NotFoundException;
    public UserMeal save(UserMeal userMeal);
    public boolean delete(int id);
    public boolean delete(int id, int userId) throws NotFoundException;

}
