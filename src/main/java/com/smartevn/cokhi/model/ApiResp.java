package com.smartevn.cokhi.model;

import java.util.List;

public class ApiResp {
    
    private Object data;
    private List<RestError> errors;
    
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public List<RestError> getErrors() {
        return errors;
    }
    public void setErrors(List<RestError> errors) {
        this.errors = errors;
    }

}
