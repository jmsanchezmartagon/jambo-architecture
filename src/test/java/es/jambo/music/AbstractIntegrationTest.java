package es.jambo.music;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootTest
@ActiveProfiles("test")
public class AbstractIntegrationTest {

    static final String database = "JAMBO_MUSIC";
    static final String user = "TEST_JAMBO";
    static final String passwd = "TEST_JAMBO";

    @Container
    static final OracleContainer oracle = new OracleContainer("gvenzl/oracle-xe:21-slim-faststart")
            .withDatabaseName(database)
            .withUsername(user)
            .withPassword(passwd);


    @DynamicPropertySource
    static void oracleProperties(DynamicPropertyRegistry registry) {
        oracle.start();
        registry.add("spring.datasource.url", oracle::getJdbcUrl);
        registry.add("spring.datasource.username", oracle::getUsername);
        registry.add("spring.datasource.password", oracle::getPassword);
    }
}
