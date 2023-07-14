package net.resume.building.service;

import java.util.List;
import java.util.Optional;

import net.resume.building.model.ITSkillsModel;

public interface ITSkillsService {
	ITSkillsModel saveFile(ITSkillsModel itSkillsModel);
	
	List<ITSkillsModel> getFiles();
	
	Optional<ITSkillsModel> getFilesById(Long id);
}
