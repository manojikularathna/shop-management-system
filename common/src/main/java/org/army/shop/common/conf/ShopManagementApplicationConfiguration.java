package org.army.shop.common.conf;

import org.army.shop.common.to.AmendmentDefinition;
import org.army.shop.common.to.ValueDefinition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "shop")
public class ShopManagementApplicationConfiguration {

    private ValueDefinition profit;
    private Map<AmendmentDefinition.Type, List<AmendmentDefinition>> amendments;
    private AccountingConfiguration accounting;

    public ValueDefinition getProfit() {
        return profit;
    }

    public void setProfit(ValueDefinition profit) {
        this.profit = profit;
    }

    public Map<AmendmentDefinition.Type, List<AmendmentDefinition>> getAmendments() {
        return amendments;
    }

    public void setAmendments(Map<AmendmentDefinition.Type, List<AmendmentDefinition>> amendments) {
        this.amendments = amendments;
    }

    public AccountingConfiguration getAccounting() {
        return accounting;
    }

    public void setAccounting(AccountingConfiguration accounting) {
        this.accounting = accounting;
    }

}
