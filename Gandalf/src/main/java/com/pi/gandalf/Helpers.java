/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Silva
 */
public class Helpers {
    public static Gson excludeFieldsWithoutExposeAnnotation() {
        GsonBuilder builder = new GsonBuilder();  
        builder.excludeFieldsWithoutExposeAnnotation();  
        return builder.create();  
    }   
    
    public static String sha1(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] sourceBytes = input.getBytes("UTF-8");
        input = new String(sourceBytes, "Windows-1252");
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
}
