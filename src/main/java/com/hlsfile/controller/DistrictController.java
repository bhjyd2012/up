package com.hlsfile.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hlsfile.bean.District;
import com.hlsfile.service.DistrictService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hucheng
 * @since 2019-11-06
 */
@Controller
@RequestMapping("/district")
public class DistrictController {
	@Autowired
	private DistrictService districtService;
	
	
	/**   
	 * @Title: getLevel3   
	 * @Description: TODO(根据城市编号获取区县)   
	 * @param: @param levelid
	 * @param: @return      
	 * @return: List<District>      
	 * @throws   
	 */  
	@RequestMapping(value="/level3")
	@ResponseBody
	public List<District> getLevel3(String levelid){
		if (!levelid.trim().equals("null")&&!levelid.trim().equals("")&&!levelid.trim().equals("城市")) {
			District district = districtService.selectOne(new EntityWrapper<District>().eq("id",levelid));
			//查询所有城市
			List<District> list = districtService.selectList(new EntityWrapper<District>().eq("parentId", district.getId()));
			return list;
		}
			List<District> list1 = new ArrayList<District>();
			District d = new District();
			d.setName("");
			list1.add(d);
		    return list1;
	}
	
	
	/**   
	 * @Title: getLevel2   
	 * @Description: TODO(根据省编号获取城市)   
	 * @param: @param levelid
	 * @param: @return      
	 * @return: List<District>      
	 * @throws   
	 */  
	@RequestMapping(value="/level2")
	@ResponseBody
	public List<District> getLevel2(String levelid){
		if (!levelid.trim().equals("null")&&!levelid.trim().equals("")&&!levelid.trim().equals("省份")) {
			District district = districtService.selectOne(new EntityWrapper<District>().eq("id",levelid));
			//查询所有城市
			List<District> list = districtService.selectList(new EntityWrapper<District>().eq("parentId", district.getId()));
			return list;
		}
			List<District> list1 = new ArrayList<District>();
			District d = new District();
			d.setName("");
			list1.add(d);
		    return list1;
	}
	
	
	/**   
	 * @Title: getLevel1   
	 * @Description: TODO(获取所有省份)   
	 * @param: @return      
	 * @return: List<District>      
	 * @throws   
	 */  
	@RequestMapping(value="/level1")
	@ResponseBody
	public List<District> getLevel1(){
		//查询所有省份
		List<District> list = districtService.selectList(new EntityWrapper<District>().eq("levelType","1"));
		for (District district2 : list) {
			System.err.println(district2);
		}
		return list;
	}
	
	
	

}

