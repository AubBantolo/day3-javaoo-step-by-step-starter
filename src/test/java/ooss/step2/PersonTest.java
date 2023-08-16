package ooss.step2;

import ooss.Person;
import ooss.Student;
import ooss.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void should_return_message_with_name_and_age_when_introduce_given_student() {
        Person tom = new Student(1, "Tom", 18);
        String introduce = tom.introduce();
        Person jerry = new Teacher(1, "Jerry", 21);
        String jerryIntroduce = jerry.introduce();


        assertEquals("My name is Tom. I am 18 years old. I am a student.", introduce);
        assertEquals("My name is Jerry. I am 21 years old. I am a teacher.", jerryIntroduce);
    }
}
