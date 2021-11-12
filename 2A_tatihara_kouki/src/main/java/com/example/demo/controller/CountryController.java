package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
@Controller
public class CountryController {
	@Autowired
	CountryRepository repository;
	
	@RequestMapping(path = "/country", method = RequestMethod.GET)
	public String viewPage(Model model) {
		
		model.addAttribute("countries",repository.findByTairikuAndNameLike("Europe","%イタ%"));
		
		return "countryPage";
	}
	@RequestMapping(path = "country", method = RequestMethod.POST)
	public String addPage(Model model,String name ,String tairiku,int population) {
		
		
		Country kuni = new Country();
	}
}