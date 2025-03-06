package com.uplus.ureka;

public class UrekaException extends RuntimeException {
    public UrekaException(String msg) {
        super(msg); // 부모 생성자 호출
    }
}
