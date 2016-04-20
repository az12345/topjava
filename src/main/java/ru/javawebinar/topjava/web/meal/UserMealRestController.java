package ru.javawebinar.topjava.web.meal;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.TimeUtil;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */

@RestController
@RequestMapping(UserMealRestController.REST_URL)
public class UserMealRestController extends AbstractUserMealController {
    static final String REST_URL = "/rest/admin/meals";

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMealWithExceed> getAll(){
        return super.getAll();
    }

//    @RequestMapping(value = "filter", method = RequestMethod.POST)
//    public String mealListFilter(Model model,
//                                 @ModelAttribute("startDate")String startDateModel,
//                                 @ModelAttribute("endDate")String endDateModel,
//                                 @ModelAttribute("startTime")String startTimeModel,
//                                 @ModelAttribute("endTime")String endTimeModel){
//        LocalDate startDate = TimeUtil.parseLocalDate(startDateModel);
//        LocalDate endDate = TimeUtil.parseLocalDate(endDateModel);
//        LocalTime startTime = TimeUtil.parseLocalTime(startTimeModel);
//        LocalTime endTime = TimeUtil.parseLocalTime(endTimeModel);
//        model.addAttribute("mealList", mealController.getBetween(startDate, startTime, endDate, endTime));
//        return "mealList";
//    }
//
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserMeal meal, @PathVariable("id") int id) {
        super.update(meal, id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserMeal> mealCreate(@RequestBody UserMeal meal) {
        UserMeal created = super.create(meal);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<>(created, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void mealDelete(@PathVariable("id")Integer id){
        super.delete(id);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMealWithExceed> getByMail(
            @RequestParam("startDate")String startDateModel,
            @RequestParam("endDate")String endDateModel,
            @RequestParam("startTime")String startTimeModel,
            @RequestParam("endTime")String endTimeModel) {

        LocalDate startDate = TimeUtil.parseLocalDate(startDateModel);
        LocalDate endDate = TimeUtil.parseLocalDate(endDateModel);
        LocalTime startTime = TimeUtil.parseLocalTime(startTimeModel);
        LocalTime endTime = TimeUtil.parseLocalTime(endTimeModel);
        return super.getBetween(startDate, startTime, endDate, endTime);
    }

}