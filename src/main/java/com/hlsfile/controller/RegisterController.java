package com.hlsfile.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hlsfile.bean.District;
import com.hlsfile.bean.Register;
import com.hlsfile.bean.other.Message;
import com.hlsfile.service.DistrictService;
import com.hlsfile.service.RegisterService;
import com.hlsfile.utils.PhoneAndEmailUtils;
import com.hlsfile.utils.SendMail;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hucheng
 * @since 2019-11-06
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	private DistrictService districtService;

	
	/**   
	 * @Title: goReg   
	 * @Description: TODO(跳转填写信息页面)   
	 * @param: @param cid
	 * @param: @param jobid
	 * @param: @param source
	 * @param: @param province
	 * @param: @param city
	 * @param: @param map
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */  
	@RequestMapping(value = "/goreg")
	public String goReg(@RequestParam("cid") Integer cid, 
			@RequestParam("jobid") Integer jobid,
			@RequestParam("source")String source,
			@RequestParam("province")String province,
			@RequestParam("city")String city,
			ModelMap map) {
		map.put("jobid", jobid);
		map.put("cid", cid);
		map.put("source",source);
		if (province!=null) {
			map.put("province",province);
		}else {
			map.put("province","1");
		}
		if (city!=null) {
			map.put("city",city);
		}else {
			map.put("city","1");
		}
		//查询所有省
		List<District> list = districtService.selectList(new EntityWrapper<District>().eq("levelType", "1"));
		map.put("level1", list);
		return "contact";
	}

	/**   
	 * @Title: addInfo   
	 * @Description: TODO(添加提交的信息)   
	 * @param: @param reg
	 * @param: @param upfile
	 * @param: @param cId
	 * @param: @return      
	 * @return: Message      
	 * @throws   
	 */  
	@RequestMapping(value = "/add")
	@ResponseBody
	public Message addInfo(Register reg, MultipartFile upfile,String cId) {
			Message meg = new Message();
			//System.out.println(reg);
			//验证是否重复提交
			   Register register = registerService.selectOne(
					 new EntityWrapper<Register>().eq("phone", reg.getPhone()).eq("name", reg.getName()).eq("job_id",reg.getJobId()));
			   if (StringUtils.isEmpty(register)) {
				// 保存文件--start--
				File realFilePath = new File("E://hls_job//resume//" + cId + "//");
				if (!realFilePath.exists()) {
					realFilePath.mkdirs();
				}
				String fileName = upfile.getOriginalFilename();
				String fileSuffix = fileName.split("\\.")[fileName.split("\\.").length - 1];
				//System.out.println(fileSuffix);
				try {
					String dt = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime());
					File realFile;
					if(fileSuffix.startsWith("wx_camera")) {//判断后缀
						realFile = new File(realFilePath.getAbsolutePath(),
								java.net.URLEncoder.encode(reg.getName() + dt, "UTF-8") + ".png");
					}else {
						realFile = new File(realFilePath.getAbsolutePath(),
								java.net.URLEncoder.encode(reg.getName() + dt, "UTF-8") + "." + fileSuffix);
					}
					if (!realFile.exists()) {
						realFile.createNewFile();
					}
					String path = realFile.getAbsolutePath();
					upfile.transferTo(realFile);//上传文件到服务器
					//设置注册信息
					reg.setFileurl(path);
					reg.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
					if (reg.getProvince().equals("省份")) {
						reg.setProvince(null);;
					}
					if (reg.getCity().equals("城市")) {
						reg.setCity(null);
					}
					if(reg.getCounty().equals("区县")){
						reg.setCounty(null);
					}
					boolean b = registerService.insert(reg);//注册信息存入db中
					if (b) {
						meg.setCode(100);
						meg.setMessage("提交成功!");
					} else {
						meg.setCode(200);
						meg.setMessage("提交失败!");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				// --保存文件-end-
			   }else{
					meg.setCode(200);
					meg.setMessage("你已经提交信息,请勿重复提交!!");
					return meg;
			}
		return meg;
	}
	
	
	/**   
	 * @Title: sendEmail   
	 * @Description: TODO(邮箱验证)   
	 * @param: @param email
	 * @param: @return      
	 * @return: Message      
	 * @throws   
	 */  
	@RequestMapping(value="/sendemail")
	@ResponseBody
	public Message sendEmail(String email) {
		System.err.println(email);
		Message meg = new Message();
		SendMail sendEmail=new SendMail();
		//设置要发送的邮箱
		sendEmail.setReceiveMailAccount(email);
		//验证码
		String str = sendEmail.yanzhengma();
		System.out.println(str);
		    if (PhoneAndEmailUtils.isEmail(email)) {
		    	sendEmail.setInfo(str);
				try {
					sendEmail.Send();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Map map = new HashMap<String,String>();
				meg.setCode(100);
				meg.setMessage("验证码发送成功!");
				//map.put("yzms",str);
				meg.setExtend(map);
				return meg;
			}else {
				meg.setCode(100);
				meg.setMessage("请输入正确的邮箱!");
				return meg;
			}

	}
	
	
	

}
