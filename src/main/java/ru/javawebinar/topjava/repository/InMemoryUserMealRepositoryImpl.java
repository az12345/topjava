package ru.javawebinar.topjava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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
        return userMeal.getUserId() == userId ? repository.put(userId, userMeal) : null;
    }

    @Override
    public boolean delete(int id, int userId) {
        UserMeal userMeal = repository.get(id);
        return userMeal.getUserId() == userId ? repository.remove(id, userMeal) : false;
    }

    @Override
    public UserMeal get(int id, int userId) {
        UserMeal userMeal = repository.get(id);
        return userMeal.getUserId() == userId ? userMeal : null;
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        List<UserMeal> list = new ArrayList<>(repository.values());

        return list.stream().filter(um -> um.getUserId() == userId).sorted(new Comparator<UserMeal>() {
            @Override
            public int compare(UserMeal o1, UserMeal o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        }).collect(Collectors.toList());
    }
}

