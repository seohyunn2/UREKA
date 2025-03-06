package com.uplus.ureka;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;
/**
* @ControllerAdvice
* Project에서 발생하는 모든 오류를 처리하는 기능
*/

@ControllerAdvice
public class ExceptionControllerAdvice {
    private Logger logger = LoggerFactory.getLogger(getClass());
   @ExceptionHandler
   public ResponseEntity<String> handler(Exception e){
       logger.error("msg: {}", e.getMessage());

       HttpHeaders resheader = new HttpHeaders();
       // 에러 메시지가 한글인 경우 깨지므로 한글 처리를 위한 응답 헤더 설정
       resheader.add("Content-Type", "application/json;charset-UTF-8");

       String msg = "처리 중 오류 발생";
       if(e instanceof UrekaException) {
           msg = e.getMessage();
       }

       return new ResponseEntity<String>(msg, resheader, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
