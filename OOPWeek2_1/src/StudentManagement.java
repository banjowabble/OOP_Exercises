public class StudentManagement {
    Student[] students = new Student[100];
    int actualLength = 0;

    /**
     * add a student to the list.
     *
     * @param newStudent student to add
     */
    public void addStudent(Student newStudent) {
        if (actualLength < students.length) {
            students[actualLength] = newStudent;
            actualLength++;
        }
    }

    /**
     * print students by group.
     *
     * @return String
     */
    public String studentsByGroup() {
        String result = "";
        boolean[] addedCheck = new boolean[students.length];

        for (int i = 0; i < actualLength; i++) {
            if (!addedCheck[i]) {
                result = result + students[i].getGroup() + "\n";
                for (int j = i; j < actualLength; j++) {
                    if (sameGroup(students[i], students[j])) {
                        result = result + students[j].getInfo() + "\n";
                        addedCheck[j] = true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * remove student with a chosen id.
     *
     * @param id id of a student needing removed
     */
    public void removeStudent(String id) {
        for (int i = 0; i < actualLength; i++) {
            if (students[i].getId().equals(id)) {
                int j = i;
                while (j < actualLength - 1) {
                    students[j] = students[j + 1];
                    j++;
                }
                students[j] = null;
                actualLength--;
            }
        }
    }

    /**
     * check if two students belong to the same group.
     *
     * @param s1 student1
     * @param s2 student2
     * @return boolean
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * client test.
     *
     * @param args system argument
     */
    public static void main(String[] args) {
        Student student = new Student();
        Student student1 = new Student("A", "111", "A@gmail.com");
        Student student2 = new Student("B", "222", "B@gmail.com");
        Student student3 = new Student("C", "333", "C@gmail.com");
        Student student4 = new Student("D", "444", "D@gmail.com");
        Student student5 = new Student("E", "555", "E@gmail.com");

        StudentManagement stdMng = new StudentManagement();

        // add students
        stdMng.addStudent(student);
        stdMng.addStudent(student1);
        stdMng.addStudent(student2);
        stdMng.addStudent(student3);
        stdMng.addStudent(student4);
        stdMng.addStudent(student5);



        //test print in groups
        stdMng.students[1].setGroup("K62CC");
        stdMng.students[5].setGroup("K62CC");
        stdMng.students[0].setGroup("K62CD");
        stdMng.students[3].setGroup("K62CD");

        System.out.println(stdMng.actualLength);
        System.out.println(stdMng.studentsByGroup());
        stdMng.removeStudent("444");
        System.out.println(stdMng.actualLength);
        System.out.println(stdMng.students[0].getInfo());
        System.out.println(stdMng.students[1].getInfo());
        System.out.println(stdMng.students[2].getInfo());
        System.out.println(stdMng.students[3].getInfo());
        System.out.println(stdMng.students[4].getInfo());
        //System.out.println(stdMng.students[5].getInfo());
        System.out.println(stdMng.studentsByGroup());
        //stdMng.studentsByGroup();
    }
}
