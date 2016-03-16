package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public List<UserMealWithExceed> getAll(LoggedUser loggedUser) {
        return repository.getAll(loggedUser);
    }

    @Override
    public List<UserMealWithExceed> getAll(LoggedUser loggedUser, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return repository.getAllFilterDateAndTime(loggedUser, startDate, startTime, endDate, endTime);
    }

    @Override
    public UserMeal get(int id, int userId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id, userId), id);
    }

    @Override
    public UserMeal update(UserMeal userMeal, int userId)  throws NotFoundException {
        return ExceptionUtil.check(repository.update(userMeal, userId), userMeal.getId());
    }

    @Override
    public UserMeal create(UserMeal userMeal) {
        return repository.create(userMeal);
    }

    @Override
    public boolean delete(int id, int userId) throws NotFoundException{
        ExceptionUtil.check(repository.delete(id, userId), id);
        return true;
    }
}
