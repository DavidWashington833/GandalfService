/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
}
