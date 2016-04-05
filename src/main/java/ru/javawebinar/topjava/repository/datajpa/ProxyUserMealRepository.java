package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * Created by admin_DKRS on 05.04.16.
 */
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {


    @Transactional
    @Query("SELECT um FROM UserMeal um WHERE um.id=:id AND um.user.id=:userId")
    @ReadOnlyProperty
    UserMeal findOne(@Param("id") int id, @Param("userId") int userId);

    @Transactional
    @Query("SELECT um FROM UserMeal um WHERE um.user.id=:userId ORDER BY um.dateTime DESC")
    @ReadOnlyProperty
    List<UserMeal> findAll(@Param("userId") int userId);

    @Transactional
    @Query("DELETE FROM UserMeal um WHERE um.id =:id AND um.user.id =:userId")
    @Modifying
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    @Transactional
    UserMeal save(UserMeal userMeal);

    @Transactional
    @Query("select u FROM User u WHERE u.id=:userId")
    User findUser (@Param("userId") int userID);

    @Override
    boolean exists(Integer integer);

}
