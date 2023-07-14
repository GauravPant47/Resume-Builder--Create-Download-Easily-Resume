package net.resume.building.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.resume.building.model.ResumeHeadlineModel;
import net.resume.building.repositorty.ResumeHeadlineRepository;
import net.resume.building.service.ResumeHedlineService;

@Service
public class ResumeHedlineServiceImpl implements ResumeHedlineService {

	@Autowired
	private ResumeHeadlineRepository resumeHeadlineRepository;

	@Override
	public ResumeHeadlineModel saveAllFiles(ResumeHeadlineModel resumeHeadline) {
		return resumeHeadlineRepository.save(resumeHeadline);
	}

	@Override
	public List<ResumeHeadlineModel> getAllFile() {
		return resumeHeadlineRepository.findAll();
	}

	@Override
	public Optional<ResumeHeadlineModel> getFilesById(Long id) {
		return resumeHeadlineRepository.findById(id);
	}

}
