package ooss.step1;

import ooss.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void should_return_message_with_name_and_age_when_introduce_given_person() {
        Person tom = new Person(1, "Tom", 18);
        String tomIntroduce = tom.introduce();
        Person jim = new Person(2, "Jim", 19);
        String jimIntroduce = jim.introduce();

        assertEquals("My name is Tom. I am 18 years old.", tomIntroduce);
        assertEquals("My name is Jim. I am 19 years old.", jimIntroduce);
    }

    @Test
    public void should_return_is_equals_by_id_when_equals_given_two_person_with_id() {
        Person person1 = new Person(1, "Tom", 18);
        Person person2 = new Person(1, "Tommy", 18);
        Person person3 = new Person(1, "Tom", 18);
        Person person4 = new Person(2, "Tom", 18);

        assertEquals(person1, person2);
        assertNotEquals(person3, person4);
    }
}
