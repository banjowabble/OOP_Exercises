public class Person {
    public String name;
    public int age;
    public String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * compare two people.
     * @param other other person
     * @return an integer < 0 if less, > 0 if more, 0 if equals
     */
    public int compareTo(Person other) {
        if (this.name.compareTo(other.name) != 0) {
            return this.name.compareTo(other.name);
        } else {
            return Integer.compare(this.age, other.age);
        }
    }
}
