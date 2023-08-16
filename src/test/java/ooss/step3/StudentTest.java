package ooss.step3;

import ooss.Klass;
import ooss.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void should_return_result_by_student_is_in_class_when_isIn_given_student() {
        Student jim = new Student(1, "Tom", 18);
        Klass klass = new Klass(1);
        jim.join(klass);

        Student tom = new Student(1, "Tom", 18);
        boolean tomIn = tom.isIn(klass);

        boolean jimIn = jim.isIn(klass);

        assertFalse(tomIn);
        assertTrue(jimIn);
    }

    @Test
    public void Should_only_in_the_recently_joined_class_when_isIn_given_student_join_two_classes_in_turn() {
        Student tom = new Student(1, "Tom", 18);
        Klass klass1 = new Klass(1);
        Klass klass2 = new Klass(2);
        tom.join(klass1);
        tom.join(klass2);

        boolean isInKlass1 = tom.isIn(klass1);
        boolean isInKlass2 = tom.isIn(klass2);

        assertFalse(isInKlass1);
        assertTrue(isInKlass2);
    }

    @Test
    public void should_return_message_with_name_age_and_class_when_introduce_given_student_is_in_a_class() {
        Student tom = new Student(1, "Tom", 18);
        Klass klass = new Klass(1);
        tom.join(klass);

        String introduce = tom.introduce();

        assertEquals("My name is Tom. I am 18 years old. I am a student. I am in class 1.", introduce);
    }
}
