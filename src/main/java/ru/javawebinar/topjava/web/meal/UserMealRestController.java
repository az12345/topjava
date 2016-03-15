package ru.javawebinar.topjava.web.meal;

import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public class UserMealRestController extends AbstractUserMealController{

    public List<UserMealWithExceed> getAllWithExceeded(){
        return UserMealsUtil.getWithExceeded(super.getAll(), LoggedUser.getCaloriesPerDay());
    }
    LocalTime startTime, LocalTime endTime, int caloriesPerDay)

    public List<UserMealWithExceed> getAllFilteredWithExceededTime(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime){
        return UserMealsUtil.getFilteredWithExceeded(super.getAll(), )
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public User create(User user) {
        return super.create(user);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void update(User user, int id) {
        super.update(user, id);
    }

    @Override
    public User getByMail(String email) {
        return super.getByMail(email);
    }
}
