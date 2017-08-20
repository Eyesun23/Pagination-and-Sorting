package com.aysun.ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aysun.ninjas.models.Dojos;
import com.aysun.ninjas.repositories.DojoRepo;


@Service
public class ApiService {
	
	private DojoRepo dojoRepo;
	
	public ApiService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojos> getAllDojos() {
		return (List<Dojos>) dojoRepo.findAll();
	}
	
	public void addDojo(Dojos dojo) {
		dojoRepo.save(dojo);
	}
	
	public Dojos findDojoById(Long id) {
		return dojoRepo.findOne(id);
	}
}