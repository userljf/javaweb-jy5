package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolUTil {
    public static final ComboPooledDataSource co = new ComboPooledDataSource();
    public static ComboPooledDataSource getCom(){
        return co;
    }
}
