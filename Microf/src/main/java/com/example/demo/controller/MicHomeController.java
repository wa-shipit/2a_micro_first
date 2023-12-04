package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.ToDo;
import com.example.demo.service.MichomeService;

@Controller
public class MicHomeController {

	@Autowired
	private MichomeService michomeService;

	// ページ表示用メソッド
	@RequestMapping(path = "/michome", method = RequestMethod.GET)
	public String displayToDoList(Model model) {
		List<ToDo> todoList = michomeService.getAllTodos();
		model.addAttribute("toDoList", todoList);
		return "michome";
	}

	// 新規登録リンクをクリックした時の遷移先
	@RequestMapping(path = "/tomicadd", method = RequestMethod.GET)
	public String redirectToMicAdd() {
		return "redirect:/micadd";
	}

	// 編集リンクをクリックした時の遷移先
	@RequestMapping(path = "/tomicedit", method = RequestMethod.GET)
	public String redirectToMicEdit() {
		return "redirect:/micedit";
	}

	// 削除リンクをクリックした時の遷移先
	@RequestMapping(path = "/tomicdel", method = RequestMethod.GET)
	public String redirectToMicDel() {
		return "redirect:/micdel";
	}
}
