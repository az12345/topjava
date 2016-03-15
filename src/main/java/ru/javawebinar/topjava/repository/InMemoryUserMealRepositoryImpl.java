package ru.javawebinar.topjava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.09.2015.
 */

@Repository
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.MEAL_LIST.forEach(this::save);
    }

    @Override
    public UserMeal save(UserMeal userMeal) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        }
        repository.put(userMeal.getId(), userMeal);
        return userMeal;
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        if (userMeal.isNew()){
            userMeal.setId(counter.incrementAndGet());
            return repository.put(userMeal.getId(), userMeal);
        }
        return userMeal.getUserId() == userId ? repository.put(userId, userMeal) : null;
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id, repository.get(id));
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
    public UserMeal get(int id) {
        return repository.get(id);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        List<UserMeal> list = new ArrayList<>(repository.values());
        List<UserMeal> resultList = new ArrayList<>();

        for(UserMeal userMeal : list){
            if(userMeal.getUserId() == userId)
                resultList.add(userMeal);
        }
        return resultList;
    }
}

