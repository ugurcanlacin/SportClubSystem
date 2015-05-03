package com.ugurcanlacin.sportclubsystem.model;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
/**
 * Workout generated by hbm2java
 */
@Entity
@Table(name = "workout", catalog = "sportclubsystem")
public class Workout implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	private Date timestamp;
	private String workoutProgram;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_workout",
	joinColumns={@JoinColumn(name="workout_id", referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
	private List<User> userList;
	
	public Workout() {
	}

	public Workout(String workoutProgram) {
		this.workoutProgram = workoutProgram;
	}


	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Version
	@Temporal(TemporalType.DATE)
	@Column(name = "timestamp", nullable = false, length = 10)
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "workout_program", length = 1000)
	public String getWorkoutProgram() {
		return this.workoutProgram;
	}

	public void setWorkoutProgram(String workoutProgram) {
		this.workoutProgram = workoutProgram;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}



}
