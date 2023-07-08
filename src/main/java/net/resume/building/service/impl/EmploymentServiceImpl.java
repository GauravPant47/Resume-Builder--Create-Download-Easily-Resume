package net.resume.building.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.model.EmploymentModel;
import net.resume.building.repositorty.EmploymentRepository;
import net.resume.building.service.EmploymentService;

@Service
public class EmploymentServiceImpl implements EmploymentService{
	
	@Autowired
	private EmploymentRepository repository;

	@Override
	public EmploymentModel saveAllFile(EmploymentModel employment) {
		return repository.save(employment);
	}

	@Override
	public Optional<EmploymentModel> getAllById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<EmploymentModel> getAllfile() {
		return repository.findAll();
	}
	
	
}
