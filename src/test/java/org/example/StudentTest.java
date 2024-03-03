package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentTest {
    private static ArrayList<Student> listMhs;
    private Student mhs;
    @BeforeAll
   static void initClass(){
        listMhs = new ArrayList<>();
    }
    @AfterAll
    void cleanClass(){
        listMhs = null;
    }

    @BeforeEach
    void initMethod(){
        mhs = new Student("Budi",12);
        listMhs.add(mhs);
    }

    @Test
    void testDataCreation(){
        assertAll(
                ()->assertNotNull(mhs.getName()),
                ()->assertNotNull(mhs.getAge()),
                ()->assertNotEquals(0,listMhs.toArray().length)
        );
    }


    @Test
    void testStudentEnrollment(){
        mhs.enrollCourse("WEB");
        mhs.enrollCourse("Android");
        assertAll(
                ()->assertEquals(2,mhs.getEnrolledCourses().toArray().length)
        );
    }

    @Test
    void testSetGrade(){
        mhs.setGrade("WEB","A");
        Assertions.assertNotNull(mhs.getGrade("WEB"));
    }

}