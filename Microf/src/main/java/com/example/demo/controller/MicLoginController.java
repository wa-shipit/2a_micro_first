package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Miclogin;
import com.example.demo.repository.MicloginRepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class MicLoginController {
	@Autowired
	MicloginRepository micloginRepository;
	
	@RequestMapping(path = "/miclogin", method = RequestMethod.GET)
	public String miclogin() {
		return "miclogin";
	}

	@RequestMapping(path = "/miclogin", method = RequestMethod.POST)
	public String homelogin(String micloginid, String micpw, String false1, Model model,HttpSession session) {
		
		if(micloginid.length() > 16){		
			model.addAttribute("micloginid", "文字数が多すぎます");			
			return "miclogin";
		}
		if(micpw.length() > 16){
			model.addAttribute("micpw", "文字数が多すぎます");
			return "miclogin";
		}
		List<Miclogin> micloginslist = micloginRepository.findAll();
		model.addAttribute("micloginslist", micloginslist);
		
		boolean userFound = false;
        for (Miclogin miclogin : micloginslist) {
            if (miclogin.getLoginid().equals(micloginid) && miclogin.getPassword().equals(micpw)) {
            	session.setAttribute("loginid", miclogin.getLoginid());
                userFound = true;
                break;
            }
        }

        // 4. 一致するユーザーが見つかった場合、ログインを許可
        if (userFound) {
            return "redirect:/michome";
        } else {
        	model.addAttribute("false1", "ログインに失敗しました");
            return "redirect:/miclogin";
        }
	}
}
