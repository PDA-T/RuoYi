package com.ruoyi.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/user")
public class UserController {

	/**
	 * 跳转返回页面
	 * @return
	 */
	@GetMapping("index")
	public String unit()
	{
		// 返回html页面
		return  "test2/user";
	}
}
