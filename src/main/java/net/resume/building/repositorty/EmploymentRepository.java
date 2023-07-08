package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.EmploymentModel;

@Repository
public interface EmploymentRepository extends JpaRepository<EmploymentModel, Long>{

}
