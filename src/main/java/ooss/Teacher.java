package ooss;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements EventListener {
    private List<Klass> klassList = new ArrayList<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce(){
        String classIn = klassList.stream()
                .filter(klass -> belongsTo(klass))
                .map(klass -> String.valueOf(klass.getId()))
                .reduce((klassResultId, klassId) -> klassResultId + ", " + klassId)
                .map(klassResult -> String.format(" I teach Class %s.", klassResult))
                .orElse("");

        return String.format("%s I am a teacher.%s", super.introduce(), classIn);

    }

    @Override
    public void updateLeader(Klass klass, Student student) {
        System.out.printf("I am %s, teacher of Class %d. I know %s become Leader."
                , this.getName()
                , klass.getId()
                , student.getName()
        );
    }

    public void assignTo(Klass klass) {
        this.klassList.add(klass);
        klassList.stream().forEach(teacherKlass -> teacherKlass.subscribe(this));
    }

    public boolean belongsTo(Klass klass) {
        return this.klassList.contains(klass);
        
    }

    public boolean isTeaching(Student tom) {
        return this.klassList.contains(tom.getKlass());
    }
}
