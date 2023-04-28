package com.slavic.service;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.slavic.dto.ErrorMsg;
import com.slavic.dto.Response;
import com.slavic.dto.req.Login;



@Service
public class MessageService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
//	public Response<String> emailSend(){
//		Response<String> res = new Response<String>();
//		res.setMessage("Message sent successfully !!");
//		res.setError(error(0,"success"));
//		return res;
//	}

	public  String sendMessage(HashMap<String, String> username) throws ConnectException {
		
		String response = null;
		try {
			Thread.sleep(50);
		} catch (Exception ex) {

		}
		
		if("employee1".equals(username.get("username"))) {
			LOG.info("Message Sent Successfully !");
			response ="success";
			
		}else if("participant1".equals(username.get("username"))) {
			LOG.info("Message Sent Successfully !");
			response ="success";
		}else {
			LOG.info("Message Sent Failed !");
			response ="failed";
			LOG.info("Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely");
			throw new ConnectException("Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely");	
		}
		return response;
	}

	public ErrorMsg error(Integer code,String message) {
		ErrorMsg error = new ErrorMsg();
		error.setErrorCode(0);
		error.setMessage(message);
		return error;
	}

}
