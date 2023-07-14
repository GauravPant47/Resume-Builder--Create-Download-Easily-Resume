package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.ResumeHeadlineModel;

@Repository
public interface ResumeHeadlineRepository extends JpaRepository<ResumeHeadlineModel, Long>{

}
