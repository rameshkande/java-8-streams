/* 
 * Company copyright (C) 2021;
 */
package edu.code.demo.constants;
/**
 * The Interface IDataConstants.
 */
public interface IDataConstants {

	 /** The customer data. */
 	String CUSTOMER_DATA = "2343225,2345,us_east,RedTeam,ProjectApple,3445s \n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s \n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s \n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s \n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s \n";
	 
	 /** The dotted line. */
 	String DOTTED_LINE= "===========================================================" ;
	 
 	/** The duratioin header. */
 	String DURATIOIN_HEADER ="===The average build duration for each geozone.===";
	 
 	/** The contract header. */
 	String CONTRACT_HEADER="The number of unique customerId for each contractId.";
	 
 	/** The unique customer id by zone. */
 	String  UNIQUE_CUSTOMER_ID_BY_ZONE="The number of unique customerId for each geozone.";
	 
 	/** The customer id for each zone. */
 	String CUSTOMER_ID_FOR_EACH_ZONE ="The list of unique customerIds for each geozone.";
	 
 	/** The new line. */
 	String NEW_LINE="\n";
	
}
