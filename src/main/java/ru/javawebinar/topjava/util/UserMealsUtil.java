package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

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
        ArrayList<UserMealWithExceed> mealWithExceedList = new ArrayList<UserMealWithExceed>();

        Collections.sort(mealList, new Comparator<UserMeal>() {
            @Override
            public int compare(UserMeal o1, UserMeal o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });

        int index = 0;
        UserMeal userMealFirst = mealList.get(0);

        for(int i = 1; i < mealList.size(); i++) {
            UserMeal userMeal = mealList.get(i);
            if (userMealFirst.getDateTime().getYear() != userMeal.getDateTime().getYear() &&
                    userMealFirst.getDateTime().getDayOfYear() != userMeal.getDateTime().getDayOfYear()) {
                setExceeded(mealList.subList(index, i), mealWithExceedList, caloriesPerDay);
                index = i;
                userMealFirst = mealList.get(i);
            }
        }

        setExceeded(mealList.subList(index, mealList.size()), mealWithExceedList, caloriesPerDay);

        LinkedList<UserMealWithExceed> resultUserMealWithExceed = new LinkedList<>();
        for (UserMealWithExceed el : mealWithExceedList){
            if(TimeUtil.isBetween(el.getDateTime().toLocalTime(), startTime, endTime)){
                resultUserMealWithExceed.add(el);
            }
        }
        // TODO return filtered list with correctly exceeded field
        return resultUserMealWithExceed;
    }

    public static void setExceeded(List<UserMeal> userMeals,
                                   List<UserMealWithExceed> userMealWithExceeds,
                                   int caloriesPerDay) {
        int totalCaloriesPerDay = 0;

        for (UserMeal el : userMeals)
            totalCaloriesPerDay += el.getCalories();

        if (totalCaloriesPerDay > caloriesPerDay) {
            for (UserMeal el : userMeals) {
                userMealWithExceeds.add(new UserMealWithExceed(
                        el.getDateTime(),
                        el.getDescription(),
                        el.getCalories(),
                        true));
            }
        } else {
            for (UserMeal el : userMeals) {
                userMealWithExceeds.add(new UserMealWithExceed(
                        el.getDateTime(),
                        el.getDescription(),
                        el.getCalories(),
                        false));
            }
        }


    }
}
