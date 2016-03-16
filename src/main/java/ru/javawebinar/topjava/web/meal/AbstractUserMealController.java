package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.*;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Brother on 13.03.2016.
 */
public abstract class AbstractUserMealController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMealService service;

    public List<UserMealWithExceed> getAll() {
        LOG.info("getAll");
        return UserMealsUtil.getWithExceeded(service.getAll(LoggedUser.id()), LoggedUser.getCaloriesPerDay());
    }

    public List<UserMealWithExceed> getAll(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return UserMealsUtil.getWithExceeded(
                service.getAll(LoggedUser.id(), startDate, startTime, endDate, endTime), LoggedUser.getCaloriesPerDay());
    }

    public UserMeal get(int id) {
        LOG.info("get " + id);
        return service.get(id, LoggedUser.id());
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id, LoggedUser.id());
    }

    public UserMeal create(UserMeal userMeal) {
        userMeal.setId(null);
        LOG.info("create " + userMeal);
        return service.create(userMeal);
    }

    public void update(UserMeal userMeal, int id) {
        userMeal.setId(id);
        LOG.info("update " + userMeal);
        service.update(userMeal, LoggedUser.id());
    }
}
