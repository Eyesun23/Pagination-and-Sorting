package com.aysun.ninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.ninjas.models.*;

@Repository
public interface DojoRepo extends CrudRepository<Dojos, Long> {
	
}