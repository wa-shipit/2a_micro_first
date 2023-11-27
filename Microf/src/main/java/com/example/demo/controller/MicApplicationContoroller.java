package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MicApplicationContoroller {

	@RequestMapping(path = "/micAppli", method = RequestMethod.GET)
	public String micAppli() {
		return "micAppli";
	}

}
