package com.ioc.rotw.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mission_type database table.
 * 
 */
@Entity
@Table(name="mission_type")
@NamedQuery(name="MissionType.findAll", query="SELECT m FROM MissionType m")
public class MissionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idmission_type")
	private int idmissionType;

	@Column(name="mission_typecol")
	private String missionTypecol;

	public MissionType() {
	}

	public int getIdmissionType() {
		return this.idmissionType;
	}

	public void setIdmissionType(int idmissionType) {
		this.idmissionType = idmissionType;
	}

	public String getMissionTypecol() {
		return this.missionTypecol;
	}

	public void setMissionTypecol(String missionTypecol) {
		this.missionTypecol = missionTypecol;
	}

}