package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.ITSkillsModel;

@Repository
public interface ITSkillsRepository extends JpaRepository<ITSkillsModel, Long>{

}
