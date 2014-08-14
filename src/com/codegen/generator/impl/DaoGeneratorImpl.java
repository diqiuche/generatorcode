package com.codegen.generator.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.codegen.constant.Constant;
import com.codegen.generator.DaoGenerator;
import com.codegen.model.GeneratorModel;

public class DaoGeneratorImpl extends AbstractGenerator implements DaoGenerator {

	public void genDaoInterface(String fileName) {
		GeneratorModel daoModel = new GeneratorModel();
		daoModel.setPackageName(Constant.DAO_PACKAGE);
		String className = StringUtils.substringBefore(fileName, ".");
		String changeClass = StringUtils.substringBefore(fileName, "Dao");
		daoModel.setClassName(className);
		daoModel.setChangeClass(changeClass);
		daoModel.setSysDate(DateFormat.getDateInstance().format(new Date()));
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("model", daoModel);
		String filePath = new String("src/"
				+ package2path(Constant.DAO_PACKAGE) + "/I" + fileName);
		super.generate(Constant.DAO_INTERFACE_TEMPLATE, data, filePath);
	}

	public void genDaoImpl(String fileName) {
		GeneratorModel daoModel = new GeneratorModel();
		daoModel.setPackageName(Constant.DAO_IMPL_PACKAGE);
		String className = StringUtils.substringBefore(fileName, ".");
		daoModel.setClassName(className);
		String impInterface = StringUtils.substringBefore(fileName, "Impl");
		String changeClass = StringUtils.substringBefore(impInterface, "Dao");
		daoModel.setImplementsName(impInterface);
		daoModel.setChangeClass(changeClass);
		daoModel.setSysDate(DateFormat.getDateInstance().format(new Date()));
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("model", daoModel);
		String filePath = new String("src/"
				+ package2path(Constant.DAO_IMPL_PACKAGE) + "/" + fileName);
		super.generate(Constant.DAO_IMPL_TEMPLATE, data, filePath);
	}

	public void genServiceInterface(String fileName) {
		GeneratorModel daoModel = new GeneratorModel();
		daoModel.setPackageName(Constant.SERVICE_PACKAGE);
		String className = StringUtils.substringBefore(fileName, ".");
		String changeClass = StringUtils.substringBefore(fileName, "Service");
		daoModel.setClassName(className);
		daoModel.setChangeClass(changeClass);
		daoModel.setSysDate(DateFormat.getDateInstance().format(new Date()));
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("model", daoModel);
		String filePath = new String("src/"
				+ package2path(Constant.SERVICE_PACKAGE) + "/I" + fileName);
		super.generate(Constant.SERVICE_INTERFACE_TEMPLATE, data, filePath);
	}

	public void genServiceImpl(String fileName) {
		GeneratorModel daoModel = new GeneratorModel();
		daoModel.setPackageName(Constant.SERVICE_IMPL_PACKAGE);
		String className = StringUtils.substringBefore(fileName, ".");
		daoModel.setClassName(className);
		String impInterface = StringUtils.substringBefore(fileName, "Impl");
		String changeClass = StringUtils.substringBefore(impInterface,
				"Service");
		daoModel.setImplementsName(impInterface);
		daoModel.setChangeClass(changeClass);
		daoModel.setLowChangeClass(changeClass.toLowerCase());
		daoModel.setSysDate(DateFormat.getDateInstance().format(new Date()));
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("model", daoModel);
		String filePath = new String("src/"
				+ package2path(Constant.SERVICE_IMPL_PACKAGE) + "/" + fileName);
		super.generate(Constant.SERVICE_IMPL_TEMPLATE, data, filePath);
	}

	public void genAll(String objectName) {
		genDaoInterface(objectName + "Dao.java");
		genDaoImpl(objectName + "DaoImpl.java");
		genServiceInterface(objectName + "Service.java");
		genServiceImpl(objectName + "ServiceImpl.java");
	}
}
