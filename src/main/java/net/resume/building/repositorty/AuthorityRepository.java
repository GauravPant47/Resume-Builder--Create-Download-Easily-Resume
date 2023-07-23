package net.resume.building.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import net.resume.building.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
