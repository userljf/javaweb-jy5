package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolUtil {
    public  static final ComboPooledDataSource cs =new ComboPooledDataSource();
    public  static ComboPooledDataSource getCom(){

        return cs;
    }

}
