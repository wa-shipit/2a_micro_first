package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicLoginController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // ログイン画面表示
    @RequestMapping(path = "/miclogin", method = RequestMethod.GET)
    public String viewPage() {
        return "miclogin";
    }

    // ログイン検証
    @RequestMapping(path = "/miclogin", method = RequestMethod.POST)
    public String loginPost(String micloginid, String micpw,String message, Model model) {
        
    	// 入力文字数のチェック
        if (micloginid.length() > 16 || micpw.length() > 16) {
        	model.addAttribute("message","文字数が多すぎます");
        	return "/miclogin";
        }
    	

        // ログイン認証
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList("SELECT * FROM miclogin WHERE loginid = ? AND password = ?",micloginid,micpw);

         if (!resultList.isEmpty()) {
            // 認証成功時
            return "redirect:/michome";
        } else {
            // 認証失敗時
            model.addAttribute("message", "ログインに失敗しました");
            return "miclogin";
        }
    }
}
