package org.army.shop.common.to;

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
