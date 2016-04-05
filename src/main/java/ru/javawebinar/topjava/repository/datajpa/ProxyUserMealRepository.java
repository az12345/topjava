package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * Created by admin_DKRS on 05.04.16.
 */
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {
//    @Transactional
//    @Modifying
//    @Query("UPDATE UserMeal um SET um=:userMeal WHERE um.user.id=:userId AND um.id=:userMeal")
//    UserMeal save(@Param("userMeal")UserMeal userMeal, @Param("userId") int userId);
//

    @Transactional
    @Query("SELECT um FROM UserMeal um WHERE um.id=:id AND um.user.id=:userId")
    UserMeal findOne(@Param("id") int id, @Param("userId") int userId);

    @Transactional
    @Query("SELECT um FROM UserMeal um WHERE um.user.id=:userId ORDER BY um.dateTime DESC")
    @ReadOnlyProperty
    List<UserMeal> findAll(@Param("userId") int userId);


}
