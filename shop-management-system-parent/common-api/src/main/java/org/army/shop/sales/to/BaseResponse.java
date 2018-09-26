package org.army.shop.sales.to;

public class BaseResponse {

    private boolean success;

    public BaseResponse() {
        success = false;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
