import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int birthYear;
    private String gender;
    private Person spouse = null;

    private List<Person> offsprings;

    public Person(String name, int birthYear, String gender) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        offsprings = new ArrayList<>();
    }

    public void marry(Person spouse) {
        this.setSpouse(spouse);
        spouse.setSpouse(spouse);
    }

    public void addChildren(Person child) {
        offsprings.add(child);
    }

    public List<Person> getOffsprings() {
        return offsprings;
    }

    @Override
    public String toString() {
        return  "Name:'" + name + '\'' +
                ", Birth year: " + birthYear +
                ", Gender: '" + gender + '\'' +
                ", Spouse: " + ((spouse == null)? "none" : spouse);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
