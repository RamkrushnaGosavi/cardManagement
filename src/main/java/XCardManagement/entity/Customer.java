package XCardManagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customrId;
    private String fName;
    private String lName;
    private String pR_Address;

    private String tP_Address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> account;


    @ManyToOne
    @JoinColumn(name = "bankCode")
    private Bank bank ;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
