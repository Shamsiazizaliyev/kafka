package az.ingress.unittest.service;

import az.ingress.unittest.dto.Transfer;
import az.ingress.unittest.repository.TranferRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class TransferServiceTest {

    @Autowired
    TranferRepository  repository;
//    @BeforeAll
//    static void setup() {
//        postgres.start();
//    }
////        @AfterAll
////    static void end() {
////        postgres.stop();
////    }
//
//
//
//    @Container
//    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres")
//            .withDatabaseName("unittest")
//            .withPassword("password")
//            .withUsername("postgres");
//
//    @DynamicPropertySource
//    static void properties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.username", postgres::getUsername);
//        registry.add("spring.datasource.password", postgres::getPassword);
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.databasename", postgres::getDatabaseName);
//    }

    @Test
    void getTranfer() {

        Transfer transfer= Transfer.builder()
                .balance(14900.00)
                .name("ismet")
                .build();

        Transfer saveTransfer=repository.save(transfer);
        assertEquals(1L,saveTransfer.getId());

    }

    @Test
    void postTranfer() {
    }
}