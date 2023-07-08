package net.resume.building.service;

import java.util.List;
import java.util.Optional;

import net.resume.building.model.EmploymentModel;

public interface EmploymentService {
	EmploymentModel saveAllFile(EmploymentModel employment);
	
	List<EmploymentModel> getAllfile();
	
	Optional<EmploymentModel> getAllById(Long id);
}
