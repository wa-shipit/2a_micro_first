package com.example.demo.Controller;

import java.io.IOException;
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

	@RequestMapping(path = "/miclogin", method = RequestMethod.GET)
	public String mylogin() {
		return "miclogin";
	}

	@RequestMapping(path = "/miclogin", method = RequestMethod.POST)
	public String miclogin(String lenError, String micloginid, String micpw, Model model) throws IOException {

		//SELECT文発行(ログインテーブルに)
		List<Map<String, Object>> resultList = jdbcTemplate
				.queryForList("SELECT * FROM miclogin WHERE loginid = ? AND password = ?", micloginid, micpw);

		//検索結果の件数を取得
		int count = resultList.size();

		//modelに「文字数多いよ」を入れてログイン画面を表示
		model.addAttribute("文字数多いよ", lenError);

		//文字数チェック
		//問題あり
		if (micloginid.length() >= 16 || micpw.length() >= 16) {
			return "miclogin";
		}

		//検索結果が1件以上ならホーム画面
		if (count >= 1) {
			return "redirect:/michome";
		} else {
			//そうじゃないならログイン画面に遷移
			return "redirect:/miclogin";
		}

	}

	@RequestMapping(path = "/michome", method = RequestMethod.GET)
	public String michome() {
		return "michome";
	}

}
