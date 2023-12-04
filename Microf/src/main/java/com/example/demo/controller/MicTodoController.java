package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MicTodoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

        private static final String USER_ID = "999999";

    @GetMapping("/micadd")
    public String showMicAddPage() {
        return "micadd";
    }

    @PostMapping("/micadd")
    public String handleMicAddForm(String month,String day,String todo) {
        String insertQuery = "INSERT INTO todo (user_id, month, day, todo) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(insertQuery, USER_ID, month, day, todo);

        return "redirect:/micadd";
    }

    @GetMapping("/micedit")
    public String showMicEditPage() {
        return "micedit";
    }

    @PostMapping("/micedit")
    public String handleMicEditForm(String month,String day,String todo) {
        String updateQuery = "UPDATE todo SET todo = ? WHERE user_id = ? AND month = ? AND day = ?";
        jdbcTemplate.update(updateQuery, todo, USER_ID, month, day);

        return "redirect:/micedit";
    }

    @GetMapping("/micdel")
    public String showMicDelPage() {
        return "micdel";
    }

    @PostMapping("/micdel")
    public String handleMicDelForm(String month,String day) {
        String deleteQuery = "DELETE FROM todo WHERE user_id = ? AND month = ? AND day = ?";
        jdbcTemplate.update(deleteQuery, USER_ID, month, day);

        return "redirect:/micdel";
    }
}
