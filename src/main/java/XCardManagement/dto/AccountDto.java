package XCardManagement.dto;

import java.util.Date;

public class AccountDto {

    private int bankCode;

    private int customerId;

    private String accountType;
    private double accountWlLimit;

    private int minimumMaintainBal;

    private String accountStatus;

    private Date AccountOpeningDate;

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
}
