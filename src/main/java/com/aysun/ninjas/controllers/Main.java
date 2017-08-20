package com.aysun.ninjas.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aysun.ninjas.models.Dojos;
import com.aysun.ninjas.models.Ninjas;
import com.aysun.ninjas.services.ApiService;
import com.aysun.ninjas.services.NinjaService;


@Controller
@RequestMapping("/")
public class Main {
	
	private ApiService apiService;
	private NinjaService ninjaService;
	
	public Main(ApiService apiService, NinjaService ninjaService) {
		this.apiService = apiService;
		this.ninjaService = ninjaService;
	}

	@GetMapping("dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojos dojo) {
		return "NewDojo.jsp";
	}
	
	@PostMapping("dojos/new")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojos dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "NewDojo.jsp";
		} else {
			apiService.addDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@GetMapping("ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninjas ninja, Model model) {
		model.addAttribute("dojos", apiService.getAllDojos());
		return "NewNinja.jsp";
	}
	
	@PostMapping("ninjas/new")
	public String createNinja(@RequestParam(value="dojo") Long id,@Valid @ModelAttribute("ninja") Ninjas ninja,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", apiService.getAllDojos());
			return "NewNinja.jsp";
		} else {
			ninjaService.addNinja(ninja);
			return "redirect:/dojos/" + id;
		}
	}
	
	@GetMapping("dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojos dojo = apiService.findDojoById(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjaService.getNinjasAtDojo(dojo));
		return "DojoNinja.jsp";
	}
	
	@GetMapping("pages/{pageNumber}")
	public String getDojosPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. 
//		This is for our links to be able to show from 1...pageMax, instead of 0...pageMax - 1.
		Page<Ninjas> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);
	    // total number of pages that we have
		int totalPages = ninjas.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("ninjas", ninjas);
		return "NewFile.jsp";
	}
}