/* 
 * Company copyright (C) 2021;
 */
package edu.code.demo.business;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import edu.code.demo.constants.IDataConstants;
import edu.code.demo.exceptions.InvalidDataException;
import edu.code.demo.exceptions.NoDataFoundException;
import edu.code.vo.CustomerData;

/**
 *
 * <h1>CustomerService</h1>
 * <p>
 * The CustomerService responsible for Calculating unique customerId for each
 * contractId, unique customerId for each geozone,build duration for each
 * geozone.
 * 
 * 
 * @author ramesh
 *
 */
public class CustomerService {

	/**
	 * Initializes data
	 * 
	 * @return Collection
	 * @throws NoDataFoundException
	 * @throws InvalidDataException
	 */
	public Collection<CustomerData> init() throws NoDataFoundException, InvalidDataException {
		return convertStringToCustomerData(IDataConstants.CUSTOMER_DATA);
	}

	/**
	 * Initializes data from constant file.
	 * 
	 * @return
	 * @throws NoDataFoundException
	 * @throws InvalidDataException
	 */
	public static Collection<CustomerData> convertStringToCustomerData(String customerData)
			throws NoDataFoundException, InvalidDataException {
		if (customerData == null || customerData.isEmpty())
			throw new NoDataFoundException();
		List<String> arrayListCustomerData = Arrays.asList(customerData.split(IDataConstants.NEW_LINE));

		List<CustomerData> empList = arrayListCustomerData.stream().map(CustomerBuilder.buildCustomerData)
				.filter(dataObj -> dataObj != null).collect(Collectors.toList());
		if (empList == null || empList.isEmpty())
			throw new InvalidDataException();
		return empList;
	}

	/**
	 * Calculates build duration The average build duration for each geozone.
	 * 
	 * @param dataList
	 * @return Map
	 */
	public Map<String, Double> getBuildDuration(Collection<CustomerData> dataList) {
		if( dataList ==null || dataList.isEmpty())  throw new NoDataFoundException();
		Map<String, Double> zoneAvg = dataList.stream()
				.collect(Collectors.groupingBy(CustomerData::getGeoZone, Collectors.averagingDouble(
						customerData -> Float.valueOf(customerData.getBuildDuration().replace("s", "")))));
		return zoneAvg;
	}

	/**
	 * Calculates the number of unique customerId for each contractId.
	 * 
	 * @param dataList
	 * @return Map
	 */
	public Map<Integer, Long> getCustomerIdsForcontractIds(Collection<CustomerData> dataList) {
		if( dataList ==null || dataList.isEmpty())  throw new NoDataFoundException();
		Map<Integer, Long> multipleFieldsMap = dataList.stream()
				.collect(Collectors.groupingBy(CustomerData::getContractId, Collectors.counting()));
		return multipleFieldsMap;

	}

	/**
	 * Calculates the average build duration for each geozone. Calculates the
	 * list of unique customerId for each geozone.
	 * 
	 * @param dataList
	 * @return
	 */
	public Map<String, Set<CustomerData>> getCustomerIdsForGeozone(Collection<CustomerData> dataList) {
		if( dataList ==null || dataList.isEmpty())  throw new NoDataFoundException();
		Map<String, Set<CustomerData>> zone = dataList.stream()
				.collect(Collectors.groupingBy(CustomerData::getGeoZone, Collectors.toSet()));
		return zone;

	}
	
}
