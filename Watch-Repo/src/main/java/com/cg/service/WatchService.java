package com.cg.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.cg.entity.Watch;



public interface WatchService {
	Watch save(Watch watch);   //save functionality already present in JPA Repo
	Watch fetch(int id) throws  InvalidWatchException; //fetchbyId present in JPA Repo
	List<Watch> getAll(); //custom defined Query in Repo
	Watch update(Watch watch); //predefined query in JPA Repo
	boolean delete(int id) throws InvalidWatchException; //predefined query in JPA Repo
	List<Watch> getByBrand(String bra) throws InvalidWatchException; //user created query
}
