package XCardManagement.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Account {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private double accountNumber;


    @PrePersist
    public void generateId() {
        long randomId = generateRandom9DigitId();
        this.accountNumber = randomId;
    }

    private long generateRandom9DigitId() {
        long customId = 100000000L;

        return customId++;
    }



    private String accountType;
    private double accountWlLimit;

    private int minimumMaintainBal;

    private String accountStatus;

    private Date AccountOpeningDate;

    @ManyToOne
    @JoinColumn(name = "bankCode")
    private Bank bank ;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountWlLimit() {
        return accountWlLimit;
    }

    public void setAccountWlLimit(double accountWlLimit) {
        this.accountWlLimit = accountWlLimit;
    }

    public int getMinimumMaintainBal() {
        return minimumMaintainBal;
    }

    public void setMinimumMaintainBal(int minimumMaintainBal) {
        this.minimumMaintainBal = minimumMaintainBal;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getAccountOpeningDate() {
        return AccountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        AccountOpeningDate = accountOpeningDate;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
