package com.hlsfile.component;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

	
	/**   
	 * @Title: goMainHtml   
	 * @Description: TODO(跳转首页)   
	 * @param: @param map
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@GetMapping(value="/")
	public String goMainHtml(String cid,String jobid,String source,ModelMap map) {
		/*List<District> list = districtService.selectList(new EntityWrapper<District>().eq("levelType", "1"));
		map.put("level1",list);*/
		if ("".equals(cid)||cid==null) {
			cid = "";
		}
		if ("".equals(jobid)||jobid==null) {
			jobid = "";
		}
		if ("".equals(source)||source==null) {
			source = "";
		}
		return "redirect:/jobInfo/joblist?cid="+cid+"&jobid="+jobid+"&source="+source;
	}
	
	/**   
	 * @Title: goAboutHtml   
	 * @Description: TODO(跳转公司介绍页)   
	 * @param: @param cid
	 * @param: @param jobid
	 * @param: @param map
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@RequestMapping(value = "/goabout")
	public String goAboutHtml(String cid,String jobid,String source,ModelMap map) {
		//System.err.println(cid+":"+jobid+":"+source);
		map.put("cid", cid);
		map.put("jobid",jobid);
		map.put("source",source);
		return "about";
	}
	
}
