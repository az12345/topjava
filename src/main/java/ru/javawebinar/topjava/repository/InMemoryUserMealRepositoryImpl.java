package ru.javawebinar.topjava.repository;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.09.2015.
 */

@Repository
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.MEAL_LIST.forEach(this::create);
    }

    @Override
    public UserMeal create(UserMeal userMeal) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        }
        repository.put(userMeal.getId(), userMeal);
        return userMeal;
    }

    @Override
    public UserMeal update(UserMeal userMeal, int userId) {
        try{
            return userMeal.getUserId() == userId ? repository.put(userId, userMeal) : null;
        } catch (NullPointerException e){
            return null;
        }
    }

    @Override
    public boolean delete(int id, int userId) {
        try {
            UserMeal userMeal = repository.get(id);
            return userMeal.getUserId() == userId ? repository.remove(id, userMeal) : false;
        } catch (NullPointerException ex){
            return false;
        }
    }

    @Override
    public UserMeal get(int id, int userId) {
        UserMeal userMeal = repository.get(id);
        return userMeal.getUserId() == userId ? userMeal : null;
    }

    @Override
    public List<UserMealWithExceed> getAll(LoggedUser loggedUser) {
        List<UserMeal> meals = UserMealsUtil.getFilteredUserMeal(new ArrayList<>(repository.values()), loggedUser.id());
        return UserMealsUtil.getWithExceeded(meals, loggedUser.getCaloriesPerDay());
    }

    @Override
    public List<UserMealWithExceed> getAllFilterDateAndTime(LoggedUser loggedUser,
                                 LocalDate startDate,
                                 LocalTime startTime,
                                 LocalDate endDate,
                                 LocalTime endTime) {
        List<UserMeal> meals = UserMealsUtil.getFilteredUserMeal(new ArrayList<>(repository.values()), loggedUser.id());
        return UserMealsUtil.getFilteredWithExceededDateAndTime(
                meals, loggedUser, startDate, startTime, endDate, endTime);
    }
}

