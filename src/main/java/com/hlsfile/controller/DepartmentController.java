package com.hlsfile.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hlsfile.bean.Department;
import com.hlsfile.service.DepartmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hucheng
 * @since 2019-12-09
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/regionalcompany")
	@ResponseBody
	public List<Department> getDepartments(){
		List<Department> lists = departmentService.selectList(new EntityWrapper<Department>().eq("department_parentid", "1"));
		return lists;
	}

}

