package net.resume.building.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.model.KeySkillsModel;
import net.resume.building.repositorty.KeySkillsRepository;
import net.resume.building.service.KeySkillService;

@Service
public class KeySkillServiceImpl implements KeySkillService{

	@Autowired
	private KeySkillsRepository keySkillsRepository;
	@Override
	public KeySkillsModel saveAllFile(KeySkillsModel keySkills) {
		return keySkillsRepository.save(keySkills);
	}

	@Override
	public List<KeySkillsModel> getAllFiles() {
		return keySkillsRepository.findAll();
	}

	@Override
	public Optional<KeySkillsModel> getFileById(Long id) {
		return keySkillsRepository.findById(id);
	}

}
