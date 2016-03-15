package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by admin_DKRS on 15.03.16.
 */

public class MockUserMealsRepositoryImpl implements UserMealRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MockUserRepositoryImpl.class);
    @Override
    public UserMeal save(UserMeal userMeal) {
        LOG.info("save " + userMeal);
        return userMeal;
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        LOG.info("save " + userMeal + " userId " + userId);
        return userMeal;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return true;
    }

    @Override
    public boolean delete(int id, int userId) {
        LOG.info("delete " + id + " userId " + userId);
        return true;
    }

    @Override
    public UserMeal get(int id) {
        LOG.info("get " + id);
        return null;
    }

    @Override
    public UserMeal get(int id, int userId) {
        LOG.info("get " + id + " userId " + userId);
        return null;
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        LOG.info("getAll");
        return Collections.emptyList();
    }

}
