package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * GKislin
 * 15.06.2015.
 */
public interface UserMealService {
    public List<UserMeal> getAll(int userId);

    public List<UserMeal> getAll(
            int userId, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime);

    public UserMeal get(int id, int userId) throws NotFoundException;

    public UserMeal update(UserMeal userMeal, int userId) throws NotFoundException;

    public UserMeal create(UserMeal userMeal);

    public boolean delete(int id, int userId) throws NotFoundException;

}
