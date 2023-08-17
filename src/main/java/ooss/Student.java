package ooss;

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class Student extends Person implements EventListener {
    private Klass klass;

    private String name;
    //TODO: unused variable

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        String classIn = Optional.ofNullable(this.klass)
                .filter(studentKlass -> isIn(studentKlass))
                .map(studentKlass -> String.format(" I am in class %d.", studentKlass.getId()))
                .orElse("");
        //TODO: Can be changed lambda to method reference
        return String.format("%s I am a student.%s", super.introduce(), classIn);
    }

    public void join(Klass klass) {
        this.klass = klass;
        klass.subscribe(this);
    }

    public boolean isIn(Klass klass) {
        return Optional.ofNullable(this.klass)
                .filter(studentKlass -> studentKlass.equals(klass))
                .isPresent();
    }

    @Override
    public void updateLeader(Klass klass, Student student) {
        System.out.printf("I am %s, student of Class %d. I know %s become Leader."
                , this.getName()
                , klass.getId()
                , student.getName()
        );
    }
}
