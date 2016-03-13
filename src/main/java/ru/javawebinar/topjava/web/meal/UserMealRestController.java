package ru.javawebinar.topjava.web.meal;

import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserMealService;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public class UserMealRestController extends AbstractUserMealController{
    private UserMealService service;

    public List<UserMealWithExceed> getAll(int userId){
        return null;
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
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
