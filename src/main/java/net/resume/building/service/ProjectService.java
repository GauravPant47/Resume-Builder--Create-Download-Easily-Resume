package net.resume.building.service;

import java.util.List;
import java.util.Optional;

import net.resume.building.model.ProjectModel;

public interface ProjectService {
	ProjectModel saveFile(ProjectModel projectModel);
	
	List<ProjectModel> getFilesAll();
	
	Optional<ProjectModel> getAllFilesById(Long id);
}
