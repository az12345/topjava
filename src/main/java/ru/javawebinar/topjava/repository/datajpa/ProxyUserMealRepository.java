package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by admin_DKRS on 05.04.16.
 */
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {


    @Transactional(readOnly = true)
    @Query("SELECT um FROM UserMeal um WHERE um.id=:id AND um.user.id=:userId")
    UserMeal findOne(@Param("id") int id, @Param("userId") int userId);

    @Transactional(readOnly = true)
    @Query("SELECT um FROM UserMeal um WHERE um.user.id=:userId ORDER BY um.dateTime DESC")
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

    @Transactional(readOnly = true)
    @Query("SELECT m FROM UserMeal m WHERE m.user.id=:userId AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC")
    List<UserMeal> getBetween(@Param("startDate") LocalDateTime startDate,
                              @Param("endDate") LocalDateTime endDate,
                              @Param("userId") int userId);
}
