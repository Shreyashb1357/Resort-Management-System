package com.resort.solution.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.solution.entity.City;
import com.resort.solution.entity.Location;
import com.resort.solution.repository.LocationRepository;
import com.resort.solution.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepo;

	@Override
	public Location addLocation(Location location) {
		if(location == null || location.getLocationName() == null) {
			return null;
		}
		return locationRepo.save(location);
	}

	@Override
	public Location updateLocation(Integer locationId, Location location) {
		Location loc = locationRepo.findById(locationId).orElse(null);
		if(loc == null || location.getCity() == null) {
			return null;
		}
		if(!loc.getCity().equals(location.getCity())) {
			loc.setCity(location.getCity());
		}
		if(!loc.getLocationName().equals(location.getLocationName())) {
			loc.setLocationName(location.getLocationName());
		}
		return locationRepo.save(loc);
	}

	@Override
	public boolean deleteLocation(Integer locationId) {
		Optional<Location> loc = locationRepo.findById(locationId);
		if(loc.isEmpty()) {
			return false;
		}
		locationRepo.deleteById(locationId);
		return true;
	}

	@Override
	public List<Location> getLocationsByCity(Integer cityId) {
		List<Location> locs = locationRepo.findByCity_CityId(cityId);
		return locs;
	}

	@Override
	public Location getLocationById(Integer locationId) {
		Location locs = locationRepo.findById(locationId).orElse(null);
		if(locs == null) {
			return null;
		}
		return locs;
	}

}
