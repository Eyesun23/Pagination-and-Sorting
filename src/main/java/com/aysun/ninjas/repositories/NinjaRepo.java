package com.aysun.ninjas.repositories;

import java.util.List;
import com.aysun.ninjas.models.*;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NinjaRepo extends CrudRepository<Ninjas, Long>, PagingAndSortingRepository<Ninjas, Long> {
	List<Ninjas> findByDojo(Dojos dojo);
}