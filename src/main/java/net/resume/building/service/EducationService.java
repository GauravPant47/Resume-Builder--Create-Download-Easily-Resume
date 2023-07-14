package net.resume.building.service;

import java.util.List;
import java.util.Optional;

import net.resume.building.model.EducationModel;

public interface EducationService {
	EducationModel saveAllFile(EducationModel educationModel);
	
	List<EducationModel> getfiles();
	
	Optional<EducationModel> getfilebyid(Long id);
}
