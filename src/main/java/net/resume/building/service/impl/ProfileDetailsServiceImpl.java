package net.resume.building.service.impl;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.model.ProfileDetails;
import net.resume.building.repositorty.ProfileDetailsRepository;
import net.resume.building.service.ProfileDetailsService;

@Service
public class ProfileDetailsServiceImpl implements ProfileDetailsService {

	@Autowired
	private ProfileDetailsRepository detailsRepository;

	LinkedList<ProfileDetails> profiledetails = new LinkedList<>();

	@Override
	public ProfileDetails saveListItem(ProfileDetails details) {
		profiledetails.addFirst(details);
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

}
