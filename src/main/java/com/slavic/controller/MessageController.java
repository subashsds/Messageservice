package com.slavic.controller;


import java.net.ConnectException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.slavic.dto.Response;
import com.slavic.service.MessageService;


@RequestMapping("/message")
@RestController
public class MessageController {
	
	@Autowired
	MessageService Message;
	
	@Autowired
	RestTemplate restTemplate;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	
	@PostMapping("/send-otp-message")
	public @ResponseBody String sendMessage(@RequestBody HashMap<String, String> username) throws ConnectException{
		return Message.sendMessage(username);
	}
}
