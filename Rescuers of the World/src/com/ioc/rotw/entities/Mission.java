package com.ioc.rotw.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mission database table.
 * 
 */
@Entity
@NamedQuery(name="Mission.findAll", query="SELECT m FROM Mission m")
public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmission;

	private String description;

	@Column(name="max_participants")
	private int maxParticipants;

	@Column(name="mission_name")
	private String missionName;

	@Column(name="mission_type")
	private String missionType;

	private int participants;

	@Column(name="pic_name")
	private String picName;

	//bi-directional many-to-one association to DistressLevel
	@ManyToOne
	@JoinColumn(name="distress_level_id")
	private DistressLevel distressLevel;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="mission")
	private List<User> users;

	//bi-directional one-to-one association to MapData
	@OneToOne
	@JoinColumn(name="map_data_id")
	private MapData mapData;

	public Mission() {
	}

	public int getIdmission() {
		return this.idmission;
	}

	public void setIdmission(int idmission) {
		this.idmission = idmission;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxParticipants() {
		return this.maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public String getMissionName() {
		return this.missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public String getMissionType() {
		return this.missionType;
	}

	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}

	public int getParticipants() {
		return this.participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public String getPicName() {
		return this.picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public DistressLevel getDistressLevel() {
		return this.distressLevel;
	}

	public void setDistressLevel(DistressLevel distressLevel) {
		this.distressLevel = distressLevel;
	}

	public MapData getMapData() {
		return this.mapData;
	}

	public void setMapData(MapData mapData1) {
		this.mapData = mapData1;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setMission(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setMission(null);

		return user;
	}
}