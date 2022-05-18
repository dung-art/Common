package com.WebOfNVD.Common.QueryLine;

import java.util.List;

public class Query {

	public static String GetQuerySearchProductCommon(String entityName, List<String> condition) {
		String a = null;
		for (String string : condition) {
			if (string != null && !string.isEmpty()) {
				a = a + "n." + condition + " ";
			}
		}
		String query = "Select n from " + " " + entityName + " " + "n Where " + " ";
		return query;

	}
}
