public class ClientTest {
    public static void main(String[] args) {
        Person p = new Person("Carl", "123abc");
        Student s1 = new Student("John", "456cde", "CS", 2021, 420);
        Staff s2 = new Staff("Nathan", "789fgh", "UET", 520);
        System.out.println(p);
        System.out.println(s1);
        System.out.println(s2);
    }
}
