package com.chtbot;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ChatBotUtility {

	public static Map<String,Object> getErrorResponse(String message,Object object){

		Map<String,Object> res = new HashMap<String,Object>();

		res.put("message", message);
		res.put("data",object );
		res.put("timestamp",new Date().getTime());
		res.put("error",true);
		res.put("status", HttpStatus.OK);

		return res;

	}

	public static Map<String,Object> getSuccessResponse(String message,Object object){

		Map<String,Object> res = new HashMap<String,Object>();

		res.put("message", message);
		res.put("data",object );
		res.put("timestamp",new Date().getTime());
		res.put("error",false);
		res.put("status", HttpStatus.INTERNAL_SERVER_ERROR);

		return res;

	}
}
