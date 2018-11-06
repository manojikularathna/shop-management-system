package org.army.shop.common.conf;

import java.util.Map;

public class AccountingConfiguration {

    private String organization;
    private Map<String, String> transactions;
    private Map<String, String> cashbooks;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Map<String, String> getTransactions() {
        return transactions;
    }

    public void setTransactions(Map<String, String> transactions) {
        this.transactions = transactions;
    }

    public Map<String, String> getCashbooks() {

        return cashbooks;
    }

    public void setCashbooks(Map<String, String> cashbooks) {
        this.cashbooks = cashbooks;
    }

}
