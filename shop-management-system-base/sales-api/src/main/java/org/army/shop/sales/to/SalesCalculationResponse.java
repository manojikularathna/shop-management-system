package org.army.shop.sales.to;

import org.army.base.common.to.BaseResponse;

import java.math.BigDecimal;
import java.util.List;

public class SalesCalculationResponse extends BaseResponse {

    private BigDecimal subTotal;

    private List<AmendmentTO> amendments;

    private BigDecimal finalTotal;

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public List<AmendmentTO> getAmendments() {
        return amendments;
    }

    public void setAmendments(List<AmendmentTO> amendments) {
        this.amendments = amendments;
    }

    public BigDecimal getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(BigDecimal finalTotal) {
        this.finalTotal = finalTotal;
    }
}
