package ooss;

import java.util.*;

public class Klass extends EventManager {

    private int id;
    private Student studentLeader;
    private List<Person> personList = new ArrayList<>();

    public Klass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void assignLeader(Student king) {
        Optional.ofNullable(king)
                .filter(student -> student.isIn(this))
                .ifPresentOrElse(
                        student -> this.studentLeader = king, 
                        () -> System.out.println("It is not one of us.")
                );

        notifyLeaderUpdate(this, king);
    }

    public boolean isLeader(Student king) {
        return studentLeader.equals(king);
    }

    public void attach(Person person) {
        personList.add(person);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return id == klass.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public void notifyLeaderUpdate(Klass klass, Student student) {
        super.getListenerList().forEach(eventListener -> eventListener.updateLeader(klass, student));
    }
}
