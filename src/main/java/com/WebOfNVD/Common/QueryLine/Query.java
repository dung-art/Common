package com.WebOfNVD.Common.QueryLine;

public class Query {

	public static String GetQuerySelect(String tableName, String condition) {
		String a = condition;
		String query = "Select * from " + " " + tableName + " " + "n Where " + " " + a + " ";
		return query;
	}

	public static String GetQueryUpdate(String tableName, String condition) {
		String a = condition;
		String query = "" + a;
		return query;
	}

}
