package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cg.entity.Watch;
import com.cg.service.InvalidWatchException;

public interface WatchRepo extends JpaRepository<Watch, Integer> {
	@Query("Select w from Watch w")
	List<Watch> getAllWatches();

	@Query("Select w from Watch w where w.brand=:bra")
	List<Watch> getByBrand(String bra) throws InvalidWatchException;
}
