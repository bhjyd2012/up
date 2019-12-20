package com.hlsfile.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hlsfile.bean.District;
import com.hlsfile.bean.JobInfo;
import com.hlsfile.bean.LocalDepartment;
import com.hlsfile.bean.other.Pager;
import com.hlsfile.bean.other.QueryObject;
import com.hlsfile.service.DistrictService;
import com.hlsfile.service.JobInfoService;
import com.hlsfile.service.LocalDepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hucheng
 * @since 2019-11-06
 */
@Controller
@RequestMapping("/jobInfo")
public class JobInfoController {
	//@Autowired
	//private DepartmentService departmentService;
	@Autowired
	private LocalDepartmentService localDepartmentService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private JobInfoService jobInfoService;
	
	
	
	/**   
	 * @Title: getJobList   
	 * @Description: TODO(根据条件查询职位列表)   
	 * @param: @param query
	 * @param: @param map
	 * @param: @param pageIndex
	 * @param: @param pageSize
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@RequestMapping(value = "/joblist")
	public String getJobList(QueryObject query,ModelMap map,
			@RequestParam(value = "index" , defaultValue = "1")Integer pageIndex,
			@RequestParam(value = "size" , defaultValue = "10")Integer pageSize
			) {
	
		//System.err.println(query);
		/*System.out.println("1:"+query.getSource());
		System.out.println(!StringUtils.isEmpty(query.getSource()));*/
		//来源判断
		if (!StringUtils.isEmpty(query.getSource())) {
			map.put("source",query.getSource());
		}else {
			map.put("source",null);
		}
		map.put("cid",query.getCid());
		//查询条件封装
		LocalDepartment localDepartment = localDepartmentService.selectOne(new EntityWrapper<LocalDepartment>().eq("local_id", query.getCid()));
		if (localDepartment!=null) {
			map.put("localname",localDepartment.getLocalName());
		}
		map.put("query",query);
		//省,市区域封装
		List<District> list = districtService.selectList(new EntityWrapper<District>().eq("levelType", "1"));
		map.put("level1", list);
		map.put("level2", query.getLevel2());
		/*List<Department> list1 = departmentService.selectList(new EntityWrapper<Department>().eq("department_parentid", "1"));
		map.put("cids", list1);*/
		//区域公司封装
		List<LocalDepartment> list2 = localDepartmentService.selectList(new EntityWrapper<LocalDepartment>());
		map.put("cids", list2);
		//页面列表数据封装
		Page<JobInfo> page1 = new Page<JobInfo>(pageIndex,pageSize);
		//设置查询条件对象
		EntityWrapper<JobInfo> entityWrapper = new EntityWrapper<JobInfo>();
		entityWrapper.eq("status",1);
		if (query!=null&&query.getCid()!=null&&!query.getCid().equals("")&&!query.getCid().equals("null")) {
			entityWrapper.eq("cid", query.getCid().trim());
		}
		if (query!=null&&query.getTitle()!=null&&!query.getTitle().equals("")&&!query.getTitle().equals("null")) {
			entityWrapper.like("title", query.getTitle().trim());
		}
		if (query!=null&&query.getLevel1()!=null&&!query.getLevel1().equals("")&&!query.getLevel1().equals("null")&&!query.getLevel1().equals("省份")) {
			//if (PhoneAndEmailUtils.isNumeric(query.getLevel1())) {....}
			entityWrapper.eq("province_code", query.getLevel1().trim());
		}
		if (query!=null&&query.getLevel2()!=null&&!query.getLevel2().equals("")&&!query.getLevel2().equals("null")&&!query.getLevel2().equals("城市")) {
			//if (PhoneAndEmailUtils.isNumeric(query.getLevel2())) {....}
			entityWrapper.eq("city_code",query.getLevel2().trim());
		}
		if (query!=null&&query.getStartDate()!=null&&!query.getStartDate().equals("")&&!query.getStartDate().equals("null")&&!query.getStartDate().equals("undefined")) {
			entityWrapper.ge("publish_date", query.getStartDate().trim());
		}
		if (query!=null&&query.getEndDate()!=null&&!query.getEndDate().equals("")&&!query.getEndDate().equals("null")&&!query.getEndDate().equals("undefined")) {
			entityWrapper.le("publish_date", query.getEndDate().trim());
		}
		//每页数据结果集
		Page<JobInfo> results = jobInfoService.selectPage(page1,entityWrapper);
		Integer totalCount = ((Long)results.getTotal()).intValue();
		Integer pageCount = ((Long)results.getPages()).intValue();
		//每页中每条数据的结果处理
		List<JobInfo> jobs = results.getRecords();
		for (JobInfo jobInfo : jobs) {
			String provinceCode = jobInfo.getProvinceCode();
			District district = districtService.selectOne(new EntityWrapper<District>().eq("id",provinceCode));
			jobInfo.setProvinceCode(district.getName());
			String cityCode = jobInfo.getCityCode();
			District district1 = districtService.selectOne(new EntityWrapper<District>().eq("id",cityCode));
			jobInfo.setCityCode(district1.getName());
		}
		 Pager<JobInfo> pager = new Pager<JobInfo>(pageIndex, pageSize, pageCount, totalCount, jobs);
		 map.put("pager",pager);
		 
		return "index";
	}
	
	
	/**   
	 * @Title: goInfoHtml   
	 * @Description: TODO(进入职位详情页)   
	 * @param: @param cid
	 * @param: @param jobid
	 * @param: @param cityCode
	 * @param: @param source
	 * @param: @param title
	 * @param: @param map
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@RequestMapping(value = "/goinfo")
	public String goInfoHtml(String cid,String jobid,String cityCode,String title,String source,String province,String city,ModelMap map) {
		//System.err.println(cid+":"+jobid+":"+cityCode+":"+title);
		//System.out.println(province+":"+city);
		if(!cid.trim().equals("")&&!cid.trim().equals("null")&&
		   !jobid.trim().equals("null")&&!jobid.trim().equals("")&&
		   !cityCode.trim().equals("")&&!title.trim().equals("")) 
		{
		   District one = districtService.selectOne(new EntityWrapper<District>().eq("name", cityCode));//查询城市编码
		   JobInfo jobInfo = jobInfoService.selectOne(new EntityWrapper<JobInfo>().eq("cid",cid).eq("city_code",one.getId()).eq("title",title));
		   District district = districtService.selectOne(new EntityWrapper<District>().eq("id",jobInfo.getCityCode()));
		   jobInfo.setCityCode(district.getName());
		   map.put("jobinfo", jobInfo);
		   map.put("cid", cid);
		   map.put("jobid",jobid);
		   map.put("source",source);
		   map.put("province",province);
		   map.put("city",city);
		}else {
		   System.out.println("携带条件有空值");
		}
		return "info";
	}
	
	
	

}

