package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public class UserMealServiceImpl implements UserMealService {

    private UserMealRepository repository;

    @Override
    public List<UserMeal> getAll(int userId) {
        return null;
    }

    @Override
    public void update(UserMeal userMeal) {

    }

    @Override
    public void create(UserMeal user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public UserMeal save(UserMeal userMeal) {
        return null;
    }
}
