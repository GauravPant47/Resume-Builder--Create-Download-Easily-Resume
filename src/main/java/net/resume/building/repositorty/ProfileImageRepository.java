package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.ProfileImageModel;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImageModel, Long>{

}
