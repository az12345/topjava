package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        ArrayList<UserMealWithExceed> mealWithExceedList = new ArrayList<>();
        int index = 0;
        int totalCaloriesPerDay = 0;
        UserMeal userMealFirst = null;

        Collections.sort(mealList, (o1, o2) -> o1.getDateTime().compareTo(o2.getDateTime()));

        if(mealList.size() > 0) {
            userMealFirst = mealList.get(0);
            totalCaloriesPerDay = userMealFirst.getCalories();

            for(int i = 1; i < mealList.size(); i++) {
                UserMeal userMeal = mealList.get(i);
                if (!userMealFirst.getDateTime().toLocalDate().isEqual(userMeal.getDateTime().toLocalDate())) {
                    setExceeded(mealList.subList(index, i),
                            mealWithExceedList,
                            caloriesPerDay,
                            totalCaloriesPerDay,
                            startTime,
                            endTime);
                    index = i;
                    userMealFirst = mealList.get(i);
                } else {
                    totalCaloriesPerDay += userMeal.getCalories();
                }
            }

            setExceeded(mealList.subList(index, mealList.size()),
                    mealWithExceedList,
                    caloriesPerDay,
                    totalCaloriesPerDay,
                    startTime,
                    endTime);
        }


        // TODO return filtered list with correctly exceeded field
        return mealWithExceedList;
    }

    public static void setExceeded(List<UserMeal> userMeals,
                                   List<UserMealWithExceed> userMealWithExceeds,
                                   int caloriesPerDay,
                                   int totalCaloriesPerDay,
                                   LocalTime startTime,
                                   LocalTime endTime) {
        if (totalCaloriesPerDay > caloriesPerDay) {
            for (UserMeal el : userMeals) {
                if(TimeUtil.isBetween(el.getDateTime().toLocalTime(), startTime, endTime)) {
                    userMealWithExceeds.add(new UserMealWithExceed(
                            el.getDateTime(),
                            el.getDescription(),
                            el.getCalories(),
                            true));
                }
            }
        } else {
            for (UserMeal el : userMeals) {
                if (TimeUtil.isBetween(el.getDateTime().toLocalTime(), startTime, endTime)) {
                    userMealWithExceeds.add(new UserMealWithExceed(
                            el.getDateTime(),
                            el.getDescription(),
                            el.getCalories(),
                            false));
                }
            }
        }
    }
}
