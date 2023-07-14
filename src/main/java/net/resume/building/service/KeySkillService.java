package net.resume.building.service;

import java.util.List;
import java.util.Optional;

import net.resume.building.model.KeySkillsModel;

public interface KeySkillService {
	KeySkillsModel saveAllFile(KeySkillsModel keySkills);
	
	List<KeySkillsModel> getAllFiles();
	
	Optional<KeySkillsModel> getFileById(Long id);
}
