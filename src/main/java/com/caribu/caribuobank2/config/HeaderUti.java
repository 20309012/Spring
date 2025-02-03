package com.caribu.caribuobank2.config;

import org.springframework.http.HttpHeaders;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HeaderUti {

//    public static HttpHeaders createEntity(String applicationName,boolean enabletraslasin,String EntityName){
//
//    }

    public static HttpHeaders createEntity(String applicationName, boolean b, String entityName, String param) {

        String massege=b?applicationName+"."+entityName+".created":"Anew"+entityName+"is created"+param;

        //HttpHeaders httpHeaders;
      org.springframework.http.HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.add("-x"+applicationName+"alert", massege);
      try {
          httpHeaders.add("-X"+applicationName+"params", URLEncoder.encode(param, StandardCharsets.UTF_8.toString()));
      }catch (UnknownError ver5){

      } catch (UnsupportedEncodingException e) {
          throw new RuntimeException(e);
      }
        return httpHeaders;

    }
}
