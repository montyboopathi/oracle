package com.oracleTask;

import java.io.BufferedReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Controller {
	public static JSONObject RequestController(BufferedReader br) {
		JSONObject jo = new JSONObject();
		try {
			StringBuffer jb = new StringBuffer();
			String line = null;
			String str;
			while ((line = br.readLine()) != null) {
				jb.append(line);
			}
			str = jb.toString();
			JSONParser jp = new JSONParser();
			jo = (JSONObject) jp.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jo;
	}
}
