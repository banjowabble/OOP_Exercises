import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            file = new FileInputStream("D:\\JavaProjects\\OOPWeek12\\src\\test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Bank bank = new Bank();
        bank.readCustomerList(file);

        System.out.println("ID Order");
        System.out.println(bank.getCustomersInfoByIdOrder());

        System.out.println("Name Order");
        System.out.println(bank.getCustomersInfoByNameOrder());

//        String string = "Damn\nGoddamn\nHo";
//        System.out.println(string);
//        int index = string.lastIndexOf('\n') - 1;
//        string = string.substring(0, index);
//        System.out.println(string);
    }
}
