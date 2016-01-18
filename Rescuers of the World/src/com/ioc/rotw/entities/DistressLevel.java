package com.ioc.rotw.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the distress_level database table.
 * 
 */
@Entity
@Table(name="distress_level")
@NamedQuery(name="DistressLevel.findAll", query="SELECT d FROM DistressLevel d")
public class DistressLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String color;

	private String description;

	//bi-directional many-to-one association to Mission
	@OneToMany(mappedBy="distressLevel")
	private List<Mission> missions;

	public DistressLevel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Mission> getMissions() {
		return this.missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public Mission addMission(Mission mission) {
		getMissions().add(mission);
		mission.setDistressLevel(this);

		return mission;
	}

	public Mission removeMission(Mission mission) {
		getMissions().remove(mission);
		mission.setDistressLevel(null);

		return mission;
	}

}