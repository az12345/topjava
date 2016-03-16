package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository {
    UserMeal create(UserMeal userMeal);

    UserMeal update(UserMeal userMeal, int userId);

    boolean delete(int id, int userId);

    UserMeal get(int id, int userId);

    List<UserMealWithExceed> getAllFilterDateAndTime(LoggedUser loggedUser,
                                                     LocalDate startDate,
                                                     LocalTime startTime,
                                                     LocalDate endDate,
                                                     LocalTime endTime);

    List<UserMealWithExceed> getAll(LoggedUser loggedUser);
}
