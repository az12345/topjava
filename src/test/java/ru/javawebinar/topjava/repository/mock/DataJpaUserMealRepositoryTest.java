package ru.javawebinar.topjava.repository.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.BaseTestClass;
import ru.javawebinar.topjava.service.UserMealService;

import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

/**
 * Created by admin_DKRS on 05.04.16.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles(Profiles.POSTGRES)
public class DataJpaUserMealRepositoryTest extends BaseTestClass{

    @Autowired
    protected UserMealService service;

    @Override
    public void testDelete() throws Exception {
        super.testDelete();
    }

    @Override
    public void testDeleteNotFound() throws Exception {

    }

    @Override
    public void testSave() throws Exception {

    }

    @Test
    @Override
    public void testGet() throws Exception {
        UserMeal actual = service.get(ADMIN_MEAL_ID, ADMIN_ID);
        MATCHER.assertEquals(ADMIN_MEAL, actual);
    }

    @Test
    public void testGetIncorrectUserId() throws Exception {
        UserMeal actual = service.get(ADMIN_MEAL_ID, USER_ID);
    }

    @Test
    @Override
    public void testGetNotFound() throws Exception {

    }

    @Override
    public void testUpdate() throws Exception {

    }

    @Override
    public void testNotFoundUpdate() throws Exception {

    }

    @Test
    @Override
    public void testGetAll() throws Exception {
        Collection<UserMeal> list = service.getAll(USER_ID);
        MATCHER.assertCollectionEquals(USER_MEALS, service.getAll(USER_ID));
    }
}
