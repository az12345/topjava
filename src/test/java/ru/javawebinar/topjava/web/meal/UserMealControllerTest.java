package ru.javawebinar.topjava.web.meal;

import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;
import ru.javawebinar.topjava.util.UserMealsUtil;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static ru.javawebinar.topjava.UserTestData.USER;
import static ru.javawebinar.topjava.MealTestData.USER_MEALS;
import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

/**
 * Created by admin_DKRS on 20.04.16.
 */
public class UserMealControllerTest extends AbstractUserMealControllerTest{
    @Test
    public void testUserMealsList() throws Exception {
        mockMvc.perform(get("/meals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("mealList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"))
                .andExpect(model().attribute("mealList", hasSize(6)))
                .andExpect(model().attribute("mealList",
                        hasItems(
                                allOf(
                                        hasProperty("id", is(100007)),
                                        hasProperty("description", is("Ужин")),
                                        hasProperty("calories", is(510))),
                                allOf(
                                        hasProperty("id", is(100006)),
                                        hasProperty("description", is("Обед")),
                                        hasProperty("calories", is(1000)))
                                )
                        ));
    }
}
