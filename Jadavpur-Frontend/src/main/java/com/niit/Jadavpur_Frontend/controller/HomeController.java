package com.niit.Jadavpur_Frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Jadavpur_Backend.DAO.CategoryDAO;

@Controller
public class HomeController 
{
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "Online Shopping - Home");
		mv.addObject("userclickhome" , true);
		mv.addObject("categoryList" , categoryDAO.categoryList());
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "Online Shopping - About Us");
		mv.addObject("userclickaboutus" , true);
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "Online Shopping - Contact Us");
		mv.addObject("userclickcontactus" , true);
		return mv;
	}
}