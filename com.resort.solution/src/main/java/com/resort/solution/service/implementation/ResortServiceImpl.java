package com.resort.solution.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.solution.entity.Location;
import com.resort.solution.entity.Resort;
import com.resort.solution.enums.ResortStatus;
import com.resort.solution.repository.ResortRepository;
import com.resort.solution.service.ResortService;

@Service
public class ResortServiceImpl implements ResortService {
	
	@Autowired
	private ResortRepository resortRepo;

	@Override
	public Resort addResort(Resort resort) {
		if(resort == null) {
			return null;
		}
		return resortRepo.save(resort);
	}

	@Override
	public Resort updateResort(Integer resortId, Resort resort) {
		Resort res = resortRepo.findById(resortId).orElse(null);
		if(res == null) {
			return null;
		}
		if(!res.getName().equals(resort.getName())) {
			res.setName(resort.getName());
		}
		
		if(!res.getEcoScore().equals(resort.getEcoScore())) {
			res.setEcoScore(resort.getEcoScore());
		}
		
		if(!res.getDescription().equals(resort.getDescription())) {
			res.setDescription(resort.getDescription());
		}
		
		if(!res.getIsActive().equals(resort.getIsActive())) {
			res.setIsActive(resort.getIsActive());
		}
		
		if(res.getRating() != resort.getRating()) {
			res.setRating(resort.getRating());
		}
		
		if(!res.getLocation().equals(resort.getLocation())) {
			res.setLocation(resort.getLocation());
		}
		return resortRepo.save(res);
	}

	@Override
	public boolean activeResort(Integer resortId) {
		Resort res = resortRepo.findById(resortId).orElse(null);
		if(res == null) {
			return false;
		}
		res.setIsActive(ResortStatus.ACTIVE);
		resortRepo.save(res);
		return true;
	}

	@Override
	public boolean deactivateResort(Integer resortId) {
		Resort res = resortRepo.findById(resortId).orElse(null);
		if(res == null) {
			return false;
		}
		res.setIsActive(ResortStatus.CLOSED);
		resortRepo.save(res);
		return true;
	}

	@Override
	public Resort getResortById(Integer resortId) {
		Resort res = resortRepo.findById(resortId).orElse(null);
		if(res == null) {
			return null;
		}
		return res;
	}

	@Override
	public List<Resort> getResortsByLocation(Integer locationId) {
		List<Resort> resorts = resortRepo.findByLocation_LocationId(locationId);
		return resorts;
	}

	@Override
	public List<Resort> searchResorts(Integer locationId) {
		List<Resort> resorts = resortRepo.findByLocation_LocationId(locationId);
		return resorts;
	}

	@Override
	public List<Resort> getTopRatedResorts(double rating) {
		List<Resort> resorts = resortRepo.findByIsActiveAndRatingGreaterThan(ResortStatus.ACTIVE , rating);
		return resorts;
	}

}
