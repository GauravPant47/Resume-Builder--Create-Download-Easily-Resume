package net.resume.building.service;

import java.util.List;
import java.util.Optional;

import net.resume.building.model.ProfileImageModel;

public interface ProfileImageService {
	ProfileImageModel saveDatabases(ProfileImageModel imageModel);
	
	List<ProfileImageModel> getAllFile();
	
	Optional<ProfileImageModel> getAllById(Long id);
}
