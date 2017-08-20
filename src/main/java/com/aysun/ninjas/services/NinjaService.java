package com.aysun.ninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aysun.ninjas.models.Dojos;
import com.aysun.ninjas.models.Ninjas;
import com.aysun.ninjas.repositories.NinjaRepo;


@Service
@Transactional
public class NinjaService {

	@Autowired
	private NinjaRepo ninjaRepo;
	
	private static final int PAGE_SIZE = 5;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Page<Ninjas> ninjasPerPage(int pageNumber) {
//		ninjasPerPage method takes a pageNumber argument and returns a Page iterable filled with ninjas objects
		PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "dojo.name");
		return ninjaRepo.findAll(pageRequest);
//		Page<T> findAll(Pageable pageable):Returns a Page of entities 
//		meeting the paging restriction provided in the Pageable object.
	}
	
	public void addNinja(Ninjas ninja) {
		ninjaRepo.save(ninja);
	}
	
	public List<Ninjas> getNinjasAtDojo(Dojos dojo) {
		return ninjaRepo.findByDojo(dojo);
	}
}