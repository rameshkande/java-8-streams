/* 
 * Company copyright (C) 2021;
 */
package edu.code.demo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import edu.code.demo.business.CustomerService;
import edu.code.demo.constants.IDataConstants;
import edu.code.demo.exceptions.InvalidDataException;
import edu.code.demo.exceptions.NoDataFoundException;
import edu.code.vo.CustomerData;

/**
 *
 * <p>
 * The Objective as follows:
 * <ol>
 * Input
 * <li>"Given a string with the following data (it includes multiple lines):
 * 2343225,2345,us_east,RedTeam,ProjectApple,3445s
 * 1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
 * 3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
 * 1233456,2345,us_west,BlueTeam,ProjectDate,2221s
 * 3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
 * <li>
 * </ol>
 *
 * <p>
 * Outcome : It produces a report containing the following: 
 * The number of unique customerId for each contractId. 
 * The number of unique customerId for each geozone.
 * The average build duration for each geozone.
 * The list of unique customerId for each geozone.
 */
public class MainApp {
	
	public static void main(String... args) {

		CustomerService customerService = new CustomerService();
		try {
			
			Collection<CustomerData>  dataList=customerService.init();
			
			printCustomerIdsForContractIds(customerService.getCustomerIdsForcontractIds(dataList));
			printCustomerIdsForGeozone(customerService.getCustomerIdsForGeozone(dataList));
			printBuildDuration(customerService.getBuildDuration(dataList));

		} catch (NoDataFoundException | InvalidDataException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the customer ids for geozone.
	 *
	 * @param customerIdsForGeozone the customer ids for geozone
	 */
	private static void printCustomerIdsForGeozone(Map<String, Set<CustomerData>> customerIdsForGeozone) {
		
		System.out.println(IDataConstants.DOTTED_LINE);
		System.out.println("The number of unique customerId for each geozone.");
		System.out.println(IDataConstants.DOTTED_LINE);
		
		customerIdsForGeozone.forEach((k, v) -> {
			System.out.println("Zone -> " + k + "-:-> Number of unique customerIds -> " + v.size());

		});
		System.out.println(IDataConstants.DOTTED_LINE);
		System.out.println("The list of unique customerIds for each geozone.");
		System.out.println(IDataConstants.DOTTED_LINE);
		customerIdsForGeozone.forEach((k, v) -> {
			System.out.println("Geozone->" + k);
			v.forEach(val -> { System.out.println("CustomerId -> " + val.getCustomerId());
			});
		});
		
	}

	/**
	 * Prints the build duration.
	 *
	 * @param buildDuration the build duration
	 */
	private static void printBuildDuration(Map<String, Double> buildDuration) {
		System.out.println(IDataConstants.DOTTED_LINE);
		System.out.println("The average buildduration for each geozone.");
		System.out.println(IDataConstants.DOTTED_LINE);
		buildDuration.forEach((k, v) -> {	System.out.println("The average build duration -> " + v + "s for each geozone -> " + k);});
	}

	/**
	 * Prints the customer ids for contract ids.
	 *
	 * @param multipleFieldsMap the multiple fields map
	 */
	public static void printCustomerIdsForContractIds(Map<Integer, Long> multipleFieldsMap) {
	   	System.out.println(IDataConstants.DOTTED_LINE);
		System.out.println("The number of unique customerId for each contractId.");
		System.out.println(IDataConstants.DOTTED_LINE);
	
		multipleFieldsMap.forEach((k, v) -> {
			System.out.println("contractorId-> " + k + " CustomerIds Number---> " + v);
		});
	}
	
}
