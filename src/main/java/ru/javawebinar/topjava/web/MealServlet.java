package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.DataBase.MealsDao;
import ru.javawebinar.topjava.DataBase.MealsDaoImpl;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.UserMealsUtil.*;

/**
 * Created by Brother on 06.03.2016.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(UserServlet.class);
    private MealsDao mealsDao;

    public MealServlet() {
        this.mealsDao = new MealsDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to mealList");
        mealsDao.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 28, 10, 0), "Завтрак", 500));
        mealsDao.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 28, 13, 0), "Обед", 1000));
        mealsDao.create(new UserMeal(LocalDateTime.of(2015, Month.MAY, 28, 20, 0), "Ужин", 490));

        mealsDao.delete(1);
        mealsDao.delete(2);
        mealsDao.delete(3);

        mealsDao.update(new UserMeal(6, LocalDateTime.of(2015, Month.MAY, 28, 10, 0), "Завтрак", 500));

        List<UserMealWithExceed> list = convertUserMealToUserMealWithExceeded(mealsDao.findAll(), 2000);

        request.setAttribute("list", list);
        request.getRequestDispatcher("mealList.jsp").forward(request, response);
    }
}
