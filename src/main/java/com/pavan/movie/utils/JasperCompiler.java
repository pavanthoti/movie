package com.pavan.movie.utils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class JasperCompiler {
	
	public static void main(String[] args){
		try {
			JasperCompileManager.compileReportToFile("src/main/resources/reports/catalog.jrxml",
					"src/main/resources/reports/catalog.jasper");
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
