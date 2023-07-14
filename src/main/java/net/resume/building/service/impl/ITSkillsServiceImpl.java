package net.resume.building.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.model.ITSkillsModel;
import net.resume.building.repositorty.ITSkillsRepository;
import net.resume.building.service.ITSkillsService;

@Service
public class ITSkillsServiceImpl implements ITSkillsService{

	@Autowired
	private ITSkillsRepository itSkillsRepository;
	@Override
	public ITSkillsModel saveFile(ITSkillsModel itSkillsModel) {
		return itSkillsRepository.save(itSkillsModel);
	}

	@Override
	public List<ITSkillsModel> getFiles() {
		return itSkillsRepository.findAll();
	}

	@Override
	public Optional<ITSkillsModel> getFilesById(Long id) {
		return itSkillsRepository.findById(id);
	}

}
