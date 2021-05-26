package io.kodloma.hrms.core;

import javax.xml.crypto.Data;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(boolean success, T data) {
        super(false, data);
    }

    public ErrorDataResult(boolean success, String message, T data) {
        super(false, message, data);
    }
}
