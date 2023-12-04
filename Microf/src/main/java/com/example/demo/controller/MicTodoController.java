package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Todo;
import com.example.demo.service.MicAddService;
import com.example.demo.service.MicDelService;
import com.example.demo.service.MicEditService;
import com.example.demo.service.UtilityService;

@Controller
public class MicTodoController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//予定新規登録画面GET,POST
	@RequestMapping(path = "/micadd", method = RequestMethod.GET)
	public String addGet() {
		return "mictodoadd";
	}

	@RequestMapping(path = "/micadd", method = RequestMethod.POST)
	public String addPost(String userid, String tododate, String todotext) {
		MicAddService micAddService = new MicAddService();
		micAddService.addTodo(userid, tododate, todotext, jdbcTemplate);
		return "redirect:/michome";
	}

	//予定編集画面GET,POST
	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String editGet(Model model) {
		/*全件取得して表示する。*/
		UtilityService utilityService = new UtilityService();
		List<Todo> TodoList = utilityService.getAllTodoList(jdbcTemplate);
		model.addAttribute("list", TodoList);
		return "mictodoedit";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.POST)
	public String editPost(String id, String month, String day, String todo) {
		MicEditService micEditService = new MicEditService();
		micEditService.updateTodo(id, month, day, todo, jdbcTemplate);
		return "redirect:/micedit";
	}

	@RequestMapping(path = "/miceditdetail", method = RequestMethod.GET)
	public String editDetail(String id, Model model) {
		UtilityService utilityService = new UtilityService();
		Todo todo = utilityService.getOneTodo(id, jdbcTemplate);
		model.addAttribute("todo", todo);
		return "miceditdetail";
	}

	//予定削除画面GET,POST
	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String delGet(Model model) {
		/*全件取得して表示する。*/
		UtilityService utilityService = new UtilityService();
		List<Todo> TodoList = utilityService.getAllTodoList(jdbcTemplate);
		model.addAttribute("list", TodoList);
		return "mictododel";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.POST)
	public String delPost(String id) {
		MicDelService micDelService = new MicDelService();
		micDelService.deltodo(id, jdbcTemplate);
		return "redirect:/micdel";
	}
}