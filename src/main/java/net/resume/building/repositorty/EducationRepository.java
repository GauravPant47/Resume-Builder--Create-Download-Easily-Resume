package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.EducationModel;

@Repository
public interface EducationRepository extends JpaRepository<EducationModel, Long>{

}
