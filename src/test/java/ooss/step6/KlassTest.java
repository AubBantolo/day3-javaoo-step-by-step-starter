package ooss.step6;

import ooss.Klass;
import ooss.Student;
import ooss.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class KlassTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_message_when_assign_leader_given_teacher_is_teaching_the_class() {
        Klass klass = new Klass(2);
        Teacher jerry = new Teacher(1, "Jerry", 21);
        jerry.assignTo(klass);
        klass.attach(jerry);
        Student tom = new Student(1, "Tom", 18);
        tom.join(klass);

        klass.assignLeader(tom);

        assertThat(systemOut(), containsString("I am Jerry, teacher of Class 2. I know Tom become Leader."));
    }

    @Test
    public void should_print_message_when_assign_leader_given_another_student_is_in_the_class() {
        Klass klass = new Klass(2);
        Student bob = new Student(1, "Bob", 18);
        bob.join(klass);
        klass.attach(bob);
        Student tom = new Student(1, "Tom", 18);
        tom.join(klass);

        klass.assignLeader(tom);

        assertThat(systemOut(), containsString("I am Bob, student of Class 2. I know Tom become Leader."));
    }

    private String systemOut() {
        return outContent.toString();
    }
}
