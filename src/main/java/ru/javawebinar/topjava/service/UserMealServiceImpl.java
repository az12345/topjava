package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {
    @Autowired
    private UserMealRepository repository;

    @Override
    public List<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public UserMeal get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public UserMeal get(int id, int userId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id, userId), id);
    }

    @Override
    public UserMeal update(UserMeal userMeal) {
        return repository.save(userMeal);
    }

    @Override
    public UserMeal update(UserMeal userMeal, int userId)  throws NotFoundException {
        return ExceptionUtil.check(repository.save(userMeal, userId), userMeal.getId());
    }

    @Override
    public UserMeal save(UserMeal userMeal) {
        return repository.save(userMeal);
    }

    @Override
    public boolean delete(int id) throws NotFoundException{
        ExceptionUtil.check(repository.delete(id), id);
        return true;
    }

    @Override
    public boolean delete(int id, int userId) throws NotFoundException{
        ExceptionUtil.check(repository.delete(id, userId), id);
        return true;
    }
}
