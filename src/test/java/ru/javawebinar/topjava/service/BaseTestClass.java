package ru.javawebinar.topjava.service;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.Profiles;

import java.util.concurrent.TimeUnit;

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
public abstract class BaseTestClass {
    private static final Logger LOG = LoggerFactory.getLogger(UserMealServiceTest.class);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    // http://stackoverflow.com/questions/14892125/what-is-the-best-practice-to-determine-the-execution-time-of-the-bussiness-relev
    public Stopwatch stopwatch = new Stopwatch() {
        private void logInfo(Description description, long nanos) {
            LOG.info(String.format("+++ Test %s spent %d ms",
                    description.getMethodName(), TimeUnit.NANOSECONDS.toMillis(nanos)));
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description, nanos);
        }
    };

    public void testDelete() throws Exception {}

    public abstract void testDeleteNotFound() throws Exception;

    public abstract void testSave() throws Exception;

    public abstract void testGet() throws Exception;

    public abstract void testGetNotFound() throws Exception;

    public abstract void testUpdate() throws Exception;

    public abstract void testNotFoundUpdate() throws Exception;

    public abstract void testGetAll() throws Exception;

}
