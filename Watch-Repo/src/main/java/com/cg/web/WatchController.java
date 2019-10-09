package com.cg.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entity.Watch;
import com.cg.service.InvalidWatchException;
import com.cg.service.WatchService;



@RestController
@RequestMapping("/watch")
public class WatchController {
	
	@Autowired
	private WatchService service;
	@GetMapping(value="/{id}", produces="application/json")
	public Watch getWatch(@PathVariable int id) throws  InvalidWatchException {
		return service.fetch(id);
	}
	
	@GetMapping(produces="application/json")
	public List<Watch> getAllWatches(){
		return service.getAll();
	}
	
	@PostMapping(value="/add", consumes="application/json", produces="application/json")
	public Watch saveWatch(@RequestBody Watch watch) {
		return service.save(watch);
	}
	
	@PutMapping(value="/update",produces="application/json", consumes="application/json")
	public Watch updateWatch(@RequestBody Watch watch) {
		return service.update(watch);
	}
	
	@DeleteMapping(value="/remove")
    public boolean deleteTrainer(@RequestParam("id") int id) throws InvalidWatchException	{
		return service.delete(id);
	}
	
	@GetMapping(value="/getbyBrand/{bra}", produces="application/json")    
	public List<Watch> getWatchByBrand(@PathVariable String bra) throws InvalidWatchException{
	      
		return service.getByBrand(bra);
	    }
}
