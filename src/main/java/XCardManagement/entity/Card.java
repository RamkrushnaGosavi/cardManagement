package XCardManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class    Card {


    @Id
    private double cardNumber;

    private Date issuingDate ;

    private Date expriryDate ;

    private Long cardLimit;

    private String cardType;

    private Long cardBal;

    private Long dueAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "account_number")
    Account account;

    @ManyToOne
    @JoinColumn(name = "bank_code")
    Bank bank;


    public double getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(double cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        this.issuingDate = issuingDate;
    }

    public Date getExpriryDate() {
        return expriryDate;
    }

    public void setExpriryDate(Date expriryDate) {
        this.expriryDate = expriryDate;
    }

    public Long getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Long cardLimit) {
        this.cardLimit = cardLimit;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Long getCardBal() {
        return cardBal;
    }

    public void setCardBal(Long cardBal) {
        this.cardBal = cardBal;
    }

    public Long getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Long dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Customer getAccountHolder() {
        return customer;
    }

    public void setAccountHolder(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
