package com.cg.service;

import java.util.List;
                                                                           																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Watch;
import com.cg.repo.WatchRepo;

@Service
@Transactional(rollbackFor = InvalidWatchException.class)

public class WatchServiceImpl implements WatchService {
	@Autowired
	private WatchRepo repo;

	@Override
	public Watch save(Watch watch) {
		return repo.save(watch);
	}

	@Override
	public Watch fetch(int id) throws InvalidWatchException {
			Watch w = new Watch();
			if(w.getId() == id)
			{ w = repo.findById(id).get();
				} 
			else {
				throw new InvalidWatchException("cannot fetch the wathc with id" + id);
			}
					return w;
			
	}

	
	@Override
	public Watch update(Watch watch) {
		return repo.save(watch); // save is predefined in JPA Rep
	}

	@Override
	public boolean delete(int id) throws InvalidWatchException {
		Watch w = new Watch();
		if (id == w.getId())
			repo.deleteById(id); // deleteById predefined in JPA Repo
		else
			throw new InvalidWatchException("Can't delete since no such Watch Exists");
		return true;
	}

	@Override
	public List<Watch> getByBrand(String bra) throws InvalidWatchException {
		List<Watch> w = repo.getByBrand(bra);
		if (w.size() == 0)
			throw new InvalidWatchException("No such Brand Exists");
		return repo.getByBrand(bra);
	}

	@Override
	public List<Watch> getAll() {
		return repo.getAllWatches();
	}

}
