package net.resume.building.service;

import java.util.List;
import java.util.Optional;

import net.resume.building.model.ResumeHeadlineModel;

public interface ResumeHedlineService {

	ResumeHeadlineModel saveAllFiles(ResumeHeadlineModel resumeHeadline);

	List<ResumeHeadlineModel> getAllFile();

	Optional<ResumeHeadlineModel> getFilesById(Long id);

}
