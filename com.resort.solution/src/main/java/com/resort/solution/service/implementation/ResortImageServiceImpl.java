package com.resort.solution.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.solution.entity.ResortImage;
import com.resort.solution.repository.ResortImageRepository;
import com.resort.solution.service.ResortImageService;

@Service
public class ResortImageServiceImpl implements ResortImageService {
	
	@Autowired
	private ResortImageRepository resimgrepo;

	@Override
	public ResortImage addResortImage(ResortImage resortImg) {
		if(resortImg == null) {
			return null;
		}
		return resimgrepo.save(resortImg);
	}

	@Override
	public boolean deleteResortImage(Integer resortId) {
		Optional<ResortImage> resImg = resimgrepo.findById(resortId);
		if(resImg.isEmpty()) {
			return false;
		}
		resimgrepo.deleteById(resortId);
		return true;
	} 

	@Override
	public List<ResortImage> getImagesByResort(Integer resortImgId) {
		List<ResortImage> resImg = resimgrepo.findByResort_ResortId(resortImgId);
		return resImg;
	}

}
