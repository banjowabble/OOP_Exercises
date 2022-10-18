import java.util.*;

public class FamilyTree {
    private List<Person> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public void add(Person member) {
        familyMembers.add(member);
    }

    public String printNotMarried() {
        StringBuilder result = new StringBuilder();
        for (Person person : familyMembers) {
            if (person.getSpouse() == null) {
                result.append(person);
                result.append('\n');
            }
        }
        return result.toString();
    }

    public String printTwoChildrenCouples() {
        HashMap<String, Boolean> marked = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (Person person : familyMembers) {
            int index = familyMembers.indexOf(person);
            if (person.getSpouse() == null || marked.containsKey(person.getName())) continue;
            if (person.getOffsprings().size() == 2) {
                marked.put(person.getName(), true);
                marked.put(person.getSpouse().getName(), true);
                result.append(person.getName()).append("-").append(person.getSpouse().getName());
                result.append('\n');
            }
        }
        return result.toString();
    }

    public String printYoungestGen() {
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
            }
        };

        StringBuilder result = new StringBuilder();
        List<Person> temp = new ArrayList<>();
        for (Person person : familyMembers) {
            if (person.getSpouse() == null) {
                temp.add(person);
            }
        }

        temp.sort(comparator.reversed());
        Person youngest = temp.get(0);
        int prevAge = youngest.getBirthYear();
        for (Person person : temp) {
            if (Math.abs(person.getBirthYear() - prevAge) > 18) break;
            result.append(person.getName()).append(" ");
            prevAge = person.getBirthYear();
        }
        return result.toString();
    }
}
