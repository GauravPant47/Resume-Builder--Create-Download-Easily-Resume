package net.resume.building.service;

import java.util.List;
import java.util.Optional;

import net.resume.building.model.ProfileDetails;

public interface ProfileDetailsService {
	
	ProfileDetails saveListItem(ProfileDetails details);
	
	List<ProfileDetails> getAllFiles();
	
	Optional<ProfileDetails> getAllFileByID(Long id);
	
	void deleteByID(Long id);
}
