package com.bhavna.bean;

public class Department {
	private int depId;
	private String depName;
	private String depLocation;
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepLocation() {
		return depLocation;
	}
	public void setDepLocation(String depLocation) {
		this.depLocation = depLocation;
	}
	public Department(int depId, String depName, String depLocation) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depLocation = depLocation;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", depLocation=" + depLocation + "]";
	}

}
