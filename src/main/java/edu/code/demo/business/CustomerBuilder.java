/* 
 * Company copyright (C) 2021;
 */
package edu.code.demo.business;

import java.util.function.Function;

import edu.code.vo.CustomerData;

/**
 * Responsible for building CustomerData object
 * from given string
 * 
 * @author ramesh
 *
 */
public class CustomerBuilder {

	/**
	 * Creates CustomerData object.
	 */
	public static Function<String, CustomerData> buildCustomerData = (line) -> {

		if (null != line && !"".equals(line.trim())) {
			String[] record = line.split(",");// This can be delimiter which
			if (record.length != 6)
				return null;
			CustomerData customerData = new CustomerData();
			try {
				customerData.setCustomerId(Integer.valueOf(record[0].trim()))
							.setContractId(Integer.valueOf(record[1]))
							.setGeoZone(record[2])
							.setTeamCode(record[3])
							.setProjectCode(record[4])
							.setBuildDuration(record[5])
							.build();
				return customerData;
			} catch (Exception e) {
				//Do not create object for invalid data
				return null;
			}
		}
		return null;
	};
}
