package com.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.pojo.Test;
import com.ssm.service.TestService;

@Controller // 控制器注解
public class TestController {
	Logger logger = Logger.getLogger(getClass());// 日志记录对象
	@Resource // 该处只声明了一个接口对象，加上该注解后框架会为我们自动注入其代理的对象值，我们在这里可以直接调用其内部声明的方法
	private TestService testService;

	@RequestMapping("content") // 相应浏览器的content请求
	public String content(HttpServletRequest request) {
		request.setAttribute("content", "控制器传入的数据");// 使用request对象传递数据到content.jsp页面中
		return "content";// 该处只需要编写页面名称即可，框架会自动将其路径变为/WEB-INF/jsp/content.jsp
	}

	@RequestMapping("showAll")
	public String showAll(HttpServletRequest request) {
		request.setAttribute("all", testService.selectAll());// 调用service层的方法并将返回值传递到页面
		return "content";
	}

	@RequestMapping("show")
	public String show(HttpServletRequest request) {
		int id = 1;
		String idStr = request.getParameter("id");
		if (idStr != null) {
			id = Integer.parseInt(idStr);
		}
		request.setAttribute("test", testService.selectById(id));
		return "content";
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");// 设置请求的字符编码
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		String name = request.getParameter("name");
		if (name != null) {
			if (testService.deleteByName(name) > 0) {
				return "success";
			}
		}
		return "error";
	}

	@RequestMapping("update")
	public String update(Test test) {
		if (testService.updateById(test) > 0) {
			return "success";
		} else {
			return "error";
		}
	}

	@RequestMapping("insert")
	public String insert(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		Test test = new Test();
		test.setName(request.getParameter("name"));
		if (testService.insertNew(test) > 0) {
			return "redirect:success";// 重定向
		} else {
			return "error";
		}
	}

	@RequestMapping("success") // 因为涉及到重定向及其他一些问题，需要设置该方法
	public String success() {
		return "success";
	}

	@RequestMapping("upload")
	public String upload(HttpServletRequest request, MultipartFile portrait) {
		String path = request.getServletContext().getRealPath("images");// 获取images文件夹路径
		String suffix = portrait.getOriginalFilename().substring(portrait.getOriginalFilename().lastIndexOf('.'));// 获取文件后缀
		String fileName = UUID.randomUUID().toString() + suffix;// 随机定义文件名
		try {
			FileUtils.copyInputStreamToFile(portrait.getInputStream(), new File(path, fileName));// 写入图片到服务器
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		Test test = new Test();
		test.setName(request.getParameter("name"));
		test.setPortrait(fileName);// 保存文件名
		if (testService.insertNew(test) > 0) {
			request.getSession().setAttribute("user", test);// 使用session对象传递数据
			return "redirect:/success";
		}
		return "error";
	}

	@RequestMapping("login")
	public String login(HttpServletRequest request) {
		Test test = new Test();
		test.setName(request.getParameter("name"));
		if (!"".equals((test = testService.selectByName(test)).getPortrait())) {
			request.getSession().setAttribute("user", test);
			return "redirect:/success";
		}
		return "error";
	}
}
