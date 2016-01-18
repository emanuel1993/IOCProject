package com.ioc.rotw.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the map_data database table.
 * 
 */
@Entity
@Table(name="map_data")
@NamedQuery(name="MapData.findAll", query="SELECT m FROM MapData m")
public class MapData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String center;

	@Column(name="visited_sectors")
	private String visitedSectors;

	private String zoom;

	//bi-directional one-to-one association to Mission
	@OneToOne(mappedBy="mapData")
	private Mission mission;

	public MapData() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCenter() {
		return this.center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getVisitedSectors() {
		return this.visitedSectors;
	}

	public void setVisitedSectors(String visitedSectors) {
		this.visitedSectors = visitedSectors;
	}

	public String getZoom() {
		return this.zoom;
	}

	public void setZoom(String zoom) {
		this.zoom = zoom;
	}

	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}