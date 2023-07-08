package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.resume.building.model.ProfileDetails;

@Repository
public interface ProfileDetailsRepository extends JpaRepository<ProfileDetails, Long>{

}
