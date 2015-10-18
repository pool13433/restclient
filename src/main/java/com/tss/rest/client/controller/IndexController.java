package com.tss.rest.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
		@RequestMapping(method=RequestMethod.GET)
		public @ResponseBody String index(){
			return "{\"page\":\"index\"}";			
		}
}
