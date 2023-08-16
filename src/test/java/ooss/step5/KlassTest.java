package ooss.step5;

import ooss.Klass;
import ooss.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KlassTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_return_result_when_isLeader_given_student() {
        Student tom = new Student(1, "Tom", 21);
        Klass klass = new Klass(1);
        Student jim = new Student(2, "Jim", 21);
        jim.join(klass);
        Student king = new Student(3, "King", 21);
        king.join(klass);
        klass.assignLeader(king);

        boolean tomIsLeader = klass.isLeader(tom);
        boolean jimIsLeader = klass.isLeader(jim);
        boolean kingIsLeader = klass.isLeader(king);

        assertFalse(jimIsLeader);
        assertFalse(tomIsLeader);
        assertTrue(kingIsLeader);
    }
    @Test
    public void should_print_prompt_message_when_assign_leader_given_student_is_not_in_class() throws Exception {
        Student tom = new Student(1, "Tom", 21);
        Klass klass = new Klass(1);

        klass.assignLeader(tom);

        assertThat(systemOut(), containsString("It is not one of us."));
    }

    private String systemOut() {
        return outContent.toString();
    }
}
