package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.green.spring.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
}
