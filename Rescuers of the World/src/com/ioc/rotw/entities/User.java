package com.ioc.rotw.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iduser;

	private String username;

	//bi-directional many-to-one association to Mission
	@ManyToOne
	@JoinColumn(name="idmission")
	private Mission mission;

	public User() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}