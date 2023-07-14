package net.resume.building.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.model.EducationModel;
import net.resume.building.repositorty.EducationRepository;
import net.resume.building.service.EducationService;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;

	@Override
	public EducationModel saveAllFile(EducationModel educationModel) {
		return educationRepository.save(educationModel);
	}

	@Override
	public List<EducationModel> getfiles() {
		return educationRepository.findAll();
	}

	@Override
	public Optional<EducationModel> getfilebyid(Long id) {
		return educationRepository.findById(id);
	}

}
