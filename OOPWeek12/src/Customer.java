import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList;

    Customer() {
        idNumber = 0;
        fullName = "";
        accountList = new ArrayList<>();
    }

    Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        accountList = new ArrayList<>();
    }

    public String getCustomerInfo() {
        return "Số CMND: " + idNumber
                + ". Họ tên: " + fullName + '.';
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
