package com.example.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    void create() {
        Study study = new Study();

        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus());
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