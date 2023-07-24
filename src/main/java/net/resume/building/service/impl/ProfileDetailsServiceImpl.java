package net.resume.building.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.exception.ResourceNotFoundException;
import net.resume.building.model.ProfileDetails;
import net.resume.building.repositorty.ProfileDetailsRepository;
import net.resume.building.service.ProfileDetailsService;

@Service
public class ProfileDetailsServiceImpl implements ProfileDetailsService {

	@Autowired
	private ProfileDetailsRepository detailsRepository;

	@Override
	public ProfileDetails saveListItem(ProfileDetails details) {
		return detailsRepository.save(details);
	}

	@Override
	public List<ProfileDetails> getAllFiles() {
		return detailsRepository.findAll();
	}

	@Override
	public Optional<ProfileDetails> getAllFileByID(Long id) {
		return detailsRepository.findById(id);
	}

	@Override
	public void deleteByID(Long id) {
		// TODO Auto-generated method stub
		Optional<ProfileDetails> optional = this.detailsRepository.findById(id);
		
		if (optional.isPresent()) {
			this.detailsRepository.delete(optional.get());
		}else {
			throw new ResourceNotFoundException("Id not found");
		}
		
	}

}
