package com.codegen.generator.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.codegen.generator.Generator;
import com.codegen.util.ConfigurationHelper;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public abstract class AbstractGenerator implements Generator {

	public void generate(String templateFileName, Map data,
			String fileName) {
		try {
			String templateFileDir=templateFileName.substring(0, templateFileName.lastIndexOf("/"));
			String templateFile=templateFileName.substring(templateFileName.lastIndexOf("/"), templateFileName.length());
			  // Get the templat object
			String genFileDir=fileName.substring(0, fileName.lastIndexOf("/"));
	        Template template = ConfigurationHelper.getConfiguration(templateFileDir).getTemplate(templateFile);
	        
	        org.apache.commons.io.FileUtils.forceMkdir(new File(genFileDir));
	        File output = new File(fileName);
	        Writer writer = new FileWriter(output);
	        template.process(data, writer);
	        writer.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String package2path(String packageName) {
		return packageName.replace('.', '/');
	}
	
	protected String  getFileName(String filePath) {
		String fileName=StringUtils.substringAfterLast(filePath, "/");
		 if(fileName.equals("")||fileName==null){
			 fileName=StringUtils.substringAfterLast(filePath, "\\");
		 }
		 return fileName;
	}

	protected String capFirst(String string) {
		String s = String.valueOf(string.charAt(0)).toUpperCase();
		s = s + string.substring(1);
		return s;
	}

	protected String uncapFirst(String string) {
		String s = String.valueOf(string.charAt(0)).toLowerCase();
		s = s + string.substring(1);
		return s;
	}
}
