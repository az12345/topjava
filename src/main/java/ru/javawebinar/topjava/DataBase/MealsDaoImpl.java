package ru.javawebinar.topjava.DataBase;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Brother on 06.03.2016.
 */
public class MealsDaoImpl implements MealsDao {
    private Map<Integer, UserMeal> hashMap;

    public MealsDaoImpl() {
        this.hashMap = new Hashtable<>();
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
    public List<UserMeal> findAll() {
        return this.hashMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(UserMeal userMeal) {
        if(!hashMap.isEmpty())
            hashMap.replace(userMeal.getId(), userMeal);
    }

    @Override
    public void create(UserMeal userMeal) {
        UserMeal newEl = new UserMeal(
                getNewId(hashMap.keySet()),
                userMeal.getDateTime(),
                userMeal.getDescription(),
                userMeal.getCalories());
        hashMap.put(newEl.getId(), newEl);
    }

    @Override
    public void delete(Integer id) {
        hashMap.remove(id);
    }

    public static Integer getNewId(Set<Integer> keySet){
        return keySet.parallelStream().max(Comparator.naturalOrder()).get() + 1;
    }
}
