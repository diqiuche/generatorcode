package com.codegen;

import java.io.IOException;

import com.codegen.generator.DaoGenerator;
import com.codegen.generator.impl.DaoGeneratorImpl;

public class GenMain {  
    /** *//**
     * 测试，根据Model类生成相应的Dao、Service
     */
    public static void main(String[] args) throws IOException {
    	DaoGenerator daoGenerator=new DaoGeneratorImpl();
    	daoGenerator.genAll("Brand");
    	daoGenerator.genAll("WareWare");
    	System.out.println("代码已生成");
    }

}
