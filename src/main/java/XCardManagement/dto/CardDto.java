package XCardManagement.dto;

import XCardManagement.entity.Customer;

import java.util.Date;

public class CardDto {

    private double cardNumber;

    private Date issuingDate ;

    private Date expriryDate ;

    private Long cardLimit;

    private String cardType;

    private Long cardBal;

    private Long dueAmount;

    private int customrId;

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

    public int getCustomrId() {
        return customrId;
    }

    public void setCustomrId(int customrId) {
        this.customrId = customrId;
    }
}
