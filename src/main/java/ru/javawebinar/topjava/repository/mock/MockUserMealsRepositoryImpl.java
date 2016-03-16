package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.to.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

/**
 * Created by admin_DKRS on 15.03.16.
 */

public class MockUserMealsRepositoryImpl implements UserMealRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MockUserRepositoryImpl.class);
    @Override
    public UserMeal create(UserMeal userMeal) {
        LOG.info("save " + userMeal);
        return userMeal;
    }

    @Override
    public List<UserMealWithExceed> getAllFilterDateAndTime(LoggedUser loggedUser, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        LOG.info("getAllFilterDateAndTime");
        return Collections.emptyList();
    }

    @Override
    public List<UserMealWithExceed> getAll(LoggedUser loggedUser) {
        LOG.info("getAll");
        return Collections.emptyList();
    }

    @Override
    public UserMeal update(UserMeal userMeal, int userId) {
        LOG.info("save " + userMeal + " userId " + userId);
        return userMeal;
    }

    @Override
    public boolean delete(int id, int userId) {
        LOG.info("delete " + id + " userId " + userId);
        return true;
    }

    @Override
    public UserMeal get(int id, int userId) {
        LOG.info("get " + id + " userId " + userId);
        return null;
    }
}
