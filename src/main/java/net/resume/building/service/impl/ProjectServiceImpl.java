package net.resume.building.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.model.ProjectModel;
import net.resume.building.repositorty.ProjectRepository;
import net.resume.building.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public ProjectModel saveFile(ProjectModel projectModel) {
		return projectRepository.save(projectModel);
	}

	@Override
	public List<ProjectModel> getFilesAll() {
		return projectRepository.findAll();
	}

	@Override
	public Optional<ProjectModel> getAllFilesById(Long id) {
		return projectRepository.findById(id);
	}

}
