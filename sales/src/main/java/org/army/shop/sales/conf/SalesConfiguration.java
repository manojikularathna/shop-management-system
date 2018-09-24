package org.army.shop.sales.conf;

import org.army.shop.sales.to.AmendmentDefinition;
import org.army.shop.sales.to.ValueDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Configuration
@PropertySource(value = "sales.yaml")
public class SalesConfiguration {

    private ValueDefinition profit;
    private Map<AmendmentDefinition.Type, List<AmendmentDefinition>> amendments;

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
}
