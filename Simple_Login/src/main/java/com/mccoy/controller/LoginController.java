package com.mccoy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.apache.commons.fileupload.FileUpload;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mccoy.dto.LoginDto;
import com.mccoy.model.service.LoginService;

import ch.qos.logback.core.net.SyslogOutputStream;


@Controller
@RequestMapping("/")
public class LoginController {
	
	



	public LoginController() {
		System.out.println(this.getClass().getSimpleName());
	}

	@Autowired
	private LoginService service;

	/*@RequestMapping(value = "create.do", method = RequestMethod.POST)
	public ModelAndView createController(LoginDto dto) {
		System.out.println("create Controller is running....");
		service.createService(dto);
		ModelAndView modelAndView = new ModelAndView("/login.jsp");
		modelAndView.addObject("msg", dto.getName());
		System.out.println("createController is ended....");
		return modelAndView;

	}*/
	
	@RequestMapping(value = "create.do", method = RequestMethod.POST)
	public ModelAndView createController( LoginDto dto) {
		System.out.println("create Controller is running....");
		System.out.println("login id"+dto.getId());
		service.createService(dto);
		System.out.println("login name:"+dto.getName());
		String name=dto.getName();
		//model.put("name",dto.getName());
		ModelAndView mav= new ModelAndView("login.jsp");
		mav.addObject("msg", dto.getName());
		System.out.println("createController is ended.......");
					 return mav;
		
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView saveController(LoginDto dto) {
		System.out.println("saveController is running....");
		LoginDto FromDb = service.saveService(dto);

		if (FromDb != null) {
			System.out.println("new name:"+ FromDb.getName());
			return new ModelAndView("home.jsp", "msg1", FromDb.getName());
		} else {
			return new ModelAndView("login.jsp", "error", "invalid credentials");
		}
	}
	
	@RequestMapping(value="edit.do", method=RequestMethod.POST)
	public ModelAndView editController(LoginDto dto) {
	
		System.out.println("edit id"+ dto.getId());
		
			  ModelAndView mav=new ModelAndView("edit.jsp");
				mav.addObject("id", dto.getId());
		
				return mav;
			
		
		
	}
	@RequestMapping(value="edit2.do", method=RequestMethod.POST)
	public ModelAndView updateController(LoginDto dto) {
		
		System.out.println("update id="+dto.getId());
		System.out.println("Update name="+dto.getName());
		service.updateService(dto);
		
		ModelAndView mav=new ModelAndView("login.jsp");
		mav.addObject("msg", dto.getName());
		return mav;
	}
	
	@RequestMapping(value = "upload.do", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFileHandler(@RequestParam("name") String name,@RequestParam("file") MultipartFile file)
	{
		
		//final Logger logger = LoggerFactory.getLogger(FileUpload.class);

		
		System.out.println("file upload started");
		
	
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				//String rootPath = System.getProperty("catalina.home");
				File dir = new File("G:" + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				if(serverFile.exists())
					return "file with same name already exist "+ name;
			
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				System.out.println("server file location="+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			}
			catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
			
			
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	
	
		
	}
}

	
	
	
	
	
