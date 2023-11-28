package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class MicUserController {
	@Autowired
	private UserRepository UserRepository;

	@RequestMapping(path = "/micuser", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "micuser";
	}

	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String register(String loginid, String password, String confirm_password, Model model) {
		if (!password.equals(confirm_password)) {
			model.addAttribute("error", "Passwords do not match");
			return "micuser";
		}
		User newUser = new User();
		newUser.setId(loginid);
		newUser.setPassword(password);
		UserRepository.save(newUser);

		return "micuser";
	}
}
