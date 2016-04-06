package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;

/**
 * Created by admin_DKRS on 06.04.16.
 */
@ActiveProfiles(Profiles.JDBC)
public class JdbcUserMealRepositoryImplTest extends UserMealServiceTest {
}
