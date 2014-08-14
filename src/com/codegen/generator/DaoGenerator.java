package com.codegen.generator;

public interface DaoGenerator extends Generator {
	public void genAll(String objectName);

	public void genDaoInterface(String fileName);

	public void genDaoImpl(String fileName);

	public void genServiceInterface(String fileName);

	public void genServiceImpl(String fileName);
}
