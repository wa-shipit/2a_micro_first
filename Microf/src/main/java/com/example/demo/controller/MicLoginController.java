package com.example.demo.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/miclogin")
public class MicLoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public String showLogin() {
        return "miclogin";
    }

    @PostMapping
    public String processLogin(
            @RequestParam("micloginid") String loginId,
            @RequestParam("micpw") String password,
            Model model,
            RedirectAttributes redirectAttributes) {

        
        if (loginId.length() > 16 || password.length() > 16) {
            model.addAttribute("errorMessage", "文字数が多すぎます");
            return "miclogin";
        }

        String query = "SELECT * FROM miclogin WHERE loginid = ? AND password = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query, loginId, password);

        
        if (!result.isEmpty()) {
            redirectAttributes.addFlashAttribute("loginSuccessMessage", "ログインに成功しました");
            return "redirect:/michome";
        } else {
            model.addAttribute("errorMessage", "ログインに失敗しました");
            return "miclogin";
        }
    }
}
