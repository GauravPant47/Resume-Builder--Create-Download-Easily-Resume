package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.KeySkillsModel;

@Repository
public interface KeySkillsRepository extends JpaRepository<KeySkillsModel, Long>{

}
