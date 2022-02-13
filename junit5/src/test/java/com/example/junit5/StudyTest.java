package com.example.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @Tag("LOCAL")
//    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "local")
    void create() {
        String test_env = System.getenv("TEST_ENV");
        assumeFalse(test_env != null && test_env.equalsIgnoreCase("PROD"));

        Study study = new Study();

        assumingThat(
                test_env != null && test_env.equalsIgnoreCase("PROD")
                , () -> assertNotNull(study)

        );

        assertAll(
            () -> assertNotNull(study)
            , () -> assertEquals(StudyStatus.DRAFT, study.getStatus())
        );
    }

    @Disabled
    @Test
    void disable() {
        Study study = new Study();
        assertNotNull(study);
    }

    @BeforeAll
    static void before_all() {
        System.out.println("before all");
    }

    @AfterAll
    @DisplayName("모든 테스트 종료 후")
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}