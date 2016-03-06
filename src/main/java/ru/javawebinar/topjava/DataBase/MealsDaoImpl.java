package ru.javawebinar.topjava.DataBase;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.util.UserMealsUtil.createWithExceed;

/**
 * Created by Brother on 06.03.2016.
 */
public class MealsDaoImpl implements MealsDao {
    private HashMap<Integer, UserMeal> hashMap;

    public MealsDaoImpl() {
        this.hashMap = new HashMap<>();
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(2, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(3, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(4, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(5, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(6, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );

        for(UserMeal el : mealList)
            hashMap.put(el.getId(), el);
    }

    @Override
    public List<UserMealWithExceed> findAll() {
        Map<LocalDate, Integer> caloriesSumByDate = this.hashMap.values().stream()
                .collect(
                        Collectors.groupingBy(um -> um.getDateTime().toLocalDate(),
                                Collectors.summingInt(UserMeal::getCalories))
                );

        return this.hashMap.values().stream()
                .map(um -> createWithExceed(um, caloriesSumByDate.get(um.getDateTime().toLocalDate()) > 2000))
                .collect(Collectors.toList());
    }

    @Override
    public void update(UserMeal userMeal) {

    }

    @Override
    public void create(UserMeal user) {

    }

    @Override
    public void delete(Integer id) {

    }
}
