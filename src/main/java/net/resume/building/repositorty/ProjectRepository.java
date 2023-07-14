package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.ProjectModel;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Long>{

}
