package com.example.springbootshoppingmallproject.common;

public class CommonFunction {
    public static String getClassName(){
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }
}
