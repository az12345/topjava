package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.TimeUtil;
import ru.javawebinar.topjava.web.meal.UserMealRestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by admin_DKRS on 13.04.16.
 */

@Controller
public class WebUserMealController {
    @Autowired
    private UserMealRestController mealController;

    @RequestMapping(value = "meals", method = RequestMethod.GET)
    public String mealList(Model model){
        model.addAttribute("mealList", mealController.getAll());
        return "mealList";
    }

    @RequestMapping(value = "meals/action=filter", method = RequestMethod.POST)
    public String mealListFilter(Model model,
                                 @ModelAttribute("startDate")String startDateModel,
                                 @ModelAttribute("endDate")String endDateModel,
                                 @ModelAttribute("startTime")String startTimeModel,
                                 @ModelAttribute("endTime")String endTimeModel){
        LocalDate startDate = TimeUtil.parseLocalDate(startDateModel);
        LocalDate endDate = TimeUtil.parseLocalDate(endDateModel);
        LocalTime startTime = TimeUtil.parseLocalTime(startTimeModel);
        LocalTime endTime = TimeUtil.parseLocalTime(endTimeModel);
        model.addAttribute("mealList", mealController.getBetween(startDate, startTime, endDate, endTime));
        return "mealList";
    }

    @RequestMapping(value = "meals/action=update&id={id}", method = RequestMethod.GET)
    public String mealCreate(Model model,
                             @PathVariable("id")Integer id){
        final UserMeal meal = mealController.get(id);
        model.addAttribute("meal", meal);
        return "mealEdit";
    }

    @RequestMapping(value = "meals", method = RequestMethod.POST)
    public String mealUpdate(@ModelAttribute("id")String id,
                             @ModelAttribute("dateTime")String dateTime,
                             @ModelAttribute("description")String description,
                             @ModelAttribute("calories")String calories){
        final UserMeal userMeal = new UserMeal(
                LocalDateTime.parse(dateTime),
                description,
                Integer.valueOf(calories));

        if (id.isEmpty()) {
            mealController.create(userMeal);
        } else {
            mealController.update(userMeal, Integer.parseInt(id));
        }
        return "redirect:/meals";
    }

    @RequestMapping(value = "meals/action=create", method = RequestMethod.GET)
    public String mealCreate(Model model){
        final UserMeal meal = new UserMeal(LocalDateTime.now(), "", 1000);  // create
        model.addAttribute("meal", meal);
        return "mealEdit";
    }

    @RequestMapping(value = "meals/action=delete&id={id}", method = RequestMethod.GET)
    public String mealDelete(@PathVariable("id")Integer id){
        mealController.delete(id);
        return "redirect:/meals";
    }

}
