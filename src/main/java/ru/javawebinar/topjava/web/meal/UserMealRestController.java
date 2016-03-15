package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController extends AbstractUserMealController{

    public List<UserMealWithExceed> getAllWithExceeded(){
        return UserMealsUtil.getWithExceeded(super.getAll(), LoggedUser.getCaloriesPerDay());
    }

    public List<UserMealWithExceed> getAllFilteredDateAndTimeWithExceeded(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime){
        return UserMealsUtil.getFilteredDateAndTimeWithExceeded(
                super.getAll(), startDate, startTime, endDate, endTime, LoggedUser.getCaloriesPerDay());
    }

    @Override
    public UserMeal get(int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public UserMeal create(UserMeal userMeal) {
        return super.create(userMeal);
    }

    @Override
    public void update(UserMeal userMeal, int id) {
        super.update(userMeal, id);
    }
}
