package com.example.demo;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicHomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // コピペ用サンプル(ページ表示用メソッド)
    @RequestMapping(path = "/michome", method = RequestMethod.GET)
    public String copGet(Model model) {
        List<Map<String, Object>> todoList = jdbcTemplate.queryForList("SELECT * FROM todo");
        model.addAttribute("todoList", todoList);
        return "michome";
    }

    // コピペ用サンプル（画面から何か入力をした時用）
    @RequestMapping(path = "/michome", method = RequestMethod.POST)
    public String copPost(String michome1, String michome2, String michome3, Model model) {
        String sql = "INSERT INTO todo (user_id, month, day) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, michome1, michome2, michome3);

        model.addAttribute("michome1", michome1);
        model.addAttribute("michome2", michome2);
        model.addAttribute("michome3", michome3);

        return "michome";
    }
}
