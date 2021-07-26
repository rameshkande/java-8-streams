/* 
 * Company copyright (C) 2021;
 */
package edu.code.vo;


import lombok.Data;
 
/**
 * The Class CustomerData.
 *
 * @author ramesh
 */
@Data
public class CustomerData {
	
	/** The customer id. */
	private  int customerId;
	
	/** The contract id. */
	private int contractId;
	
	/** The geo zone. */
	private  String geoZone ;
	
	/** The team code. */
	private  String teamCode ;
	
	/** The project code. */
	private  String projectCode ;
	
	/** The build duration. */
	private String buildDuration ;
	
	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public int getCustomerId() {
		return customerId;
	}
	
	/**
	 * Sets the customer id.
	 *
	 * @param customerId the customer id
	 * @return the customer data
	 */
	public CustomerData setCustomerId(int customerId) {
		this.customerId = customerId;
		return this;
	}
	
	/**
	 * Gets the contract id.
	 *
	 * @return the contract id
	 */
	public int getContractId() {
		return contractId;
	}
	
	/**
	 * Sets the contract id.
	 *
	 * @param contractId the contract id
	 * @return the customer data
	 */
	public CustomerData setContractId(int contractId) {
		this.contractId = contractId;
		return this;
	}
	
	/**
	 * Gets the geo zone.
	 *
	 * @return the geo zone
	 */
	public String getGeoZone() {
		return geoZone;
	}
	
	/**
	 * Sets the geo zone.
	 *
	 * @param geoZone the geo zone
	 * @return the customer data
	 */
	public CustomerData setGeoZone(String geoZone) {
		this.geoZone = geoZone;
		return this;
	}
	
	/**
	 * Gets the team code.
	 *
	 * @return the team code
	 */
	public String getTeamCode() {
		return teamCode;
	}
	
	/**
	 * Sets the team code.
	 *
	 * @param teamCode the team code
	 * @return the customer data
	 */
	public CustomerData setTeamCode(String teamCode) {
		this.teamCode = teamCode;
		return this;
	}
	
	/**
	 * Gets the project code.
	 *
	 * @return the project code
	 */
	public String getProjectCode() {
		return projectCode;
	}
	
	/**
	 * Sets the project code.
	 *
	 * @param projectCode the project code
	 * @return the customer data
	 */
	public CustomerData setProjectCode(String projectCode) {
		this.projectCode = projectCode;
		return this;
	}
	
	/**
	 * Gets the builds the duration.
	 *
	 * @return the builds the duration
	 */
	public String getBuildDuration() {
		return buildDuration;
	}
	
	/**
	 * Sets the build duration.
	 *
	 * @param buildDuration the build duration
	 * @return the customer data
	 */
	public CustomerData setBuildDuration(String buildDuration) {
		this.buildDuration = buildDuration;
		return this;
	}
	
	/**
	 * Builds the.
	 *
	 * @return the customer data
	 */
	public CustomerData build() {
		return this;
	}
	
}
