public class Test {
    public static void main(String[] args) {
        Student sinhVien = new Student();
        Student sinhVien1 = new Student("Nguyen Van A", "111", "VanA@gmail.com");
        Student sinhVien2 = new Student("Nguyen Van B", "222", "VanB@gmail.com");
        StudentManagement quanLySinhVien = new StudentManagement();
        //System.out.println(sinhVien.getName() + sinhVien.getEmail() + sinhVien.getGroup());
        //System.out.println(StudentManagement.sameGroup(sinhVien1, sinhVien2));
        quanLySinhVien.addStudent(sinhVien);
        quanLySinhVien.addStudent(sinhVien1);
        quanLySinhVien.addStudent(sinhVien2);
        System.out.println(quanLySinhVien.students[0].getName());
        System.out.println(quanLySinhVien.students[1].getName());
        System.out.println(quanLySinhVien.students[2].getName());
        //quanLySinhVien.removeStudent("111");
        /*System.out.println(quanLySinhVien.students[0].getName());
        System.out.println(quanLySinhVien.students[1].getName());*/
        //System.out.println(quanLySinhVien.students[2].getName());
        System.out.println(quanLySinhVien.students.length);
        //System.out.println(quanLySinhVien.studentsByGroup());
    }
}
