package io.kodloma.hrms.core;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(boolean success, T data) {
        super(true, data);
    }

    public SuccessDataResult(String message){
        super(message);
    }

    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }

}
