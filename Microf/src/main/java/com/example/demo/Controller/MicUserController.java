package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicUserController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// コピペ用サンプル(ページ表示用メソッド)
	@RequestMapping(path = "/micuser", method = RequestMethod.GET)
	public String copGet() {
		return "micuser";
	}

	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String copPost(String userName, String password) {

		//		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(
		//				"SELECT * FROM miclogin WHERE loginid = ? AND password = ?", userName, password);
		//
		//		if (resultList != null) {
		//			// ログイン成功
		//			return "miclogin";
		//		} else {
		// ログイン失敗なので、新しいユーザーを追加
		jdbcTemplate.update("INSERT INTO miclogin(loginid,password) VALUES(?, ?)", userName, password);

		return "micuser";
		//		}
	}
}
