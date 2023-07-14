package net.resume.building.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class ProjectModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String proejectTitle;
	private String workedTime;
	private String workedFrom;
	private String detailsOfroject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProejectTitle() {
		return proejectTitle;
	}

	public void setProejectTitle(String proejectTitle) {
		this.proejectTitle = proejectTitle;
	}

	public String getWorkedTime() {
		return workedTime;
	}

	public void setWorkedTime(String workedTime) {
		this.workedTime = workedTime;
	}

	public String getWorkedFrom() {
		return workedFrom;
	}

	public void setWorkedFrom(String workedFrom) {
		this.workedFrom = workedFrom;
	}

	public String getDetailsOfroject() {
		return detailsOfroject;
	}

	public void setDetailsOfroject(String detailsOfroject) {
		this.detailsOfroject = detailsOfroject;
	}

}
