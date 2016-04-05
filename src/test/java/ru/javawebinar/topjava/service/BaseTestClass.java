package ru.javawebinar.topjava.service;

import org.junit.Test;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.MealTestData.MEAL1;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

/**
 * Created by admin_DKRS on 05.04.16.
 */
public abstract class BaseTestClass {
    public void testDelete() throws Exception {}

    public abstract void testDeleteNotFound() throws Exception;

    public abstract void testSave() throws Exception;

    public abstract void testGet() throws Exception;

    public abstract void testGetNotFound() throws Exception;

    public abstract void testUpdate() throws Exception;

    public abstract void testNotFoundUpdate() throws Exception;

    public abstract void testGetAll() throws Exception;

}
