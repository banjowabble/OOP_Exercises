import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Bank {
    private List<Customer> customerList;

    /**
     * read customer list.
     */
    public void readCustomerList(InputStream inputStream) {
        customerList = new ArrayList<>();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String line = bufferedReader.readLine();
            while (line != null) {

                if (Character.isLetter(line.charAt(0))) {
                    int nameIndex = 0;
                    int idIndex = 0;
                    for (int i = 0; i < line.length(); i++) {
                        if (Character.isDigit(line.charAt(i))) {
                            idIndex = i;
                            nameIndex = i - 1;
                            break;
                        }
                    }

                    Customer customer = new Customer(Long.parseLong(line.substring(idIndex)),
                            line.substring(0, nameIndex));
                    String subLine = bufferedReader.readLine();
                    if (subLine == null) {
                        customerList.add(customer);
                        return;
                    }

                    while (Character.isDigit(subLine.charAt(0))) {
                        String[] strings = subLine.split(" ");
                        long accountNumber = Long.parseLong(strings[0]);
                        String type = strings[1];
                        double balance = Double.parseDouble(strings[2]);

                        Account account;
                        if (Objects.equals(type, Account.CHECKING)) {
                            account = new CheckingAccount(accountNumber, balance);
                        } else {
                            account = new SavingsAccount(accountNumber, balance);
                        }

                        customer.addAccount(account);
                        subLine = bufferedReader.readLine();
                        if (subLine == null) {
                            break;
                        }
                    }
                    customerList.add(customer);
                    line = subLine;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get customers' info sorted by their id number.
     */
    public String getCustomersInfoByIdOrder() {
        StringBuilder result = new StringBuilder();
        Comparator<Customer> comparator = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return Long.compare(o1.getIdNumber(), o2.getIdNumber());
            }
        };

        customerList.sort(comparator);
        for (Customer customer : customerList) {
            result.append(customer.getCustomerInfo()).append('\n');
        }
        int index = result.lastIndexOf("\n");

        return result.substring(0, index);
    }

    /**
     * get customers' info sorted by their name.
     */
    public String getCustomersInfoByNameOrder() {
        StringBuilder result = new StringBuilder();
        Comparator<Customer> comparator = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        };

        customerList.sort(comparator);
        for (Customer customer : customerList) {
            result.append(customer.getCustomerInfo()).append('\n');
        }
        int index = result.lastIndexOf("\n");

        return result.substring(0, index);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
