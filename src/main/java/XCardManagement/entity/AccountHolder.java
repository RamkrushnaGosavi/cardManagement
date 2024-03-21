package XCardManagement.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class AccountHolder {
    @Id
    private int customrId;
    private String fName;
    private String lName;
    private String pR_Address;

    private String tP_Address;

    @OneToMany(mappedBy = "accountHolder", cascade = CascadeType.ALL)
    private List<Account> account;


    @OneToMany(mappedBy = "accountHolder", cascade = CascadeType.ALL)
    private List<Card> cards;


    public int getCustomrId() {
        return customrId;
    }

    public void setCustomrId(int customrId) {
        this.customrId = customrId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getpR_Address() {
        return pR_Address;
    }

    public void setpR_Address(String pR_Address) {
        this.pR_Address = pR_Address;
    }

    public String gettP_Address() {
        return tP_Address;
    }

    public void settP_Address(String tP_Address) {
        this.tP_Address = tP_Address;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
