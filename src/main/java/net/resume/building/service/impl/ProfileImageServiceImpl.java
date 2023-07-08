package net.resume.building.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.model.ProfileImageModel;
import net.resume.building.repositorty.ProfileImageRepository;
import net.resume.building.service.ProfileImageService;

@Service
public class ProfileImageServiceImpl implements ProfileImageService{
	
	@Autowired
	private ProfileImageRepository imageRepository;

	@Override
	public ProfileImageModel saveDatabases(ProfileImageModel imageModel) {
		return imageRepository.save(imageModel);
	}

	@Override
	public List<ProfileImageModel> getAllFile() {
		return imageRepository.findAll();
	}

	@Override
	public Optional<ProfileImageModel> getAllById(Long id) {
		return imageRepository.findById(id);
	}
}
