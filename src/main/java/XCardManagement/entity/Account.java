package XCardManagement.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Account {

    @Id
    private double accountNumber;
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
    private AccountHolder accountHolder;

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

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }
}
