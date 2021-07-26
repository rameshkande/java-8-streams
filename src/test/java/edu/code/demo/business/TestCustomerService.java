package edu.code.demo.business;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.code.demo.MainApp;
import edu.code.demo.business.CustomerService;
import edu.code.demo.exceptions.InvalidDataException;
import edu.code.demo.exceptions.NoDataFoundException;
import edu.code.vo.CustomerData;

public class TestCustomerService {

	String customerDataString="2343225,2345,us_east,RedTeam,ProjectApple,3445s \n" + 
			"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s \n"+
			"3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s \n"+
			"1233456,2345,us_west,BlueTeam,ProjectDate,2221s \n"+
			"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s \n"; 
	
	CustomerService cs = null;
	@Before
	public void init() {
		cs = new CustomerService();
		try {
			cs.init();
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test(expected = NoDataFoundException.class)
	public void convertStringToCustomerDataTestNull() throws NoDataFoundException,InvalidDataException {
		String customerDataString = null ;
	
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
	}
	
	@Test(expected = NoDataFoundException.class)
	public void convertStringToCustomerDataTestIsEmpty() throws NoDataFoundException,InvalidDataException {
		MainApp tm = new MainApp();
		String customerDataString = "" ;
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
	}
	
    @Test (expected=InvalidDataException.class)
	public void convertStringToCustomerDataTestInvalid() throws NoDataFoundException,InvalidDataException {
		MainApp tm = new MainApp();
		String customerDataString = "InvalidString,sdfas,asf,asdf" ;
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
	
	}
	@Test
	public void convertStringToCustomerDataTestSingleLine() throws NoDataFoundException,InvalidDataException {
		String customerDataString="2343225,2345,us_east,RedTeam,ProjectApple,3445s" ;
		MainApp tm = new MainApp();
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		assertEquals(1, testObject.size());
	}
	@Test
	public void convertStringToCustomerDataTest() throws NoDataFoundException,InvalidDataException {
		//String customerDataString="2343225,2345,us_east,RedTeam,ProjectApple,3445s" ;
		MainApp tm = new MainApp();
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		assertEquals(5, testObject.size());
		// we have to create 2-3 objects and test 
//		@Test
//		public void test() {
//		    Student bobFromApi = new Student("Bob", 18, "#123");
//		    Student bobFromDb = new Student("Bobby", 18, "#123");
//		    assertThat(bobFromApi, is(bobFromDb));
//		}
	}
	@Test
	public void convertStringToCustomerDataTestPartialInvalid() throws NoDataFoundException,InvalidDataException {

		String customerDataString="2343225,2345,us_east,RedTeam,ProjectApple,3445s \n" + 
				"1223456,2345,us_west,BlueTeam,ProjectBanana,2211s \n"+
				"3244332$%@,2346,eu_west,YellowTeam3,ProjectCarrot,4322s \n"+
				"1233456,2345,us_west,BlueTeam,ProjectDate,2221s \n"+
				"3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s \n"; 
				
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		System.out.println(testObject);
		assertEquals(4, testObject.size());
		// we have to create 2-3 objects and test 
	}

	@Test
	public void getBuildDurationTest() throws NoDataFoundException, InvalidDataException{
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		  Map<String, Double> map = cs.getBuildDuration(testObject);
		assertEquals(4222.0, map.get("eu_west").doubleValue(),0);
		assertEquals(2216.0, map.get("us_west").doubleValue(),0);
		assertEquals(3445.0, map.get("us_east").doubleValue(),0);
	}
	@Test
	public void getBuildDurationTestSingleLine() throws NoDataFoundException, InvalidDataException{
		String customerDataString="2343225,2345,us_east,RedTeam,ProjectApple,3445s" ;
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		  Map<String, Double> map = cs.getBuildDuration(testObject);
		assertEquals(3445.0, map.get("us_east").doubleValue(),0);
	}
    @Test(expected = NoDataFoundException.class)
	public void getBuildDurationTestNull() throws NoDataFoundException, InvalidDataException{
		  Map<String, Double> map = cs.getBuildDuration(null);

	} 
	@Test
	public void getCustomerIdsForcontractIdsTest() throws NoDataFoundException, InvalidDataException{
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		  Map<Integer, Long> map = cs.getCustomerIdsForcontractIds(testObject);
	
		assertEquals(3, map.get(2345).intValue());
		assertEquals(2, map.get(2346).intValue());
		
	}
	@Test
	public void getCustomerIdsForcontractIdsTestSingleLine() throws NoDataFoundException, InvalidDataException{
		String customerDataString="2343225,2345,us_east,RedTeam,ProjectApple,3445s" ;
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		  Map<Integer, Long> map = cs.getCustomerIdsForcontractIds(testObject);
	
		  assertEquals(1, map.get(2345).intValue());
	}
	
	@Test(expected = NoDataFoundException.class)
	public void getCustomerIdsForcontractIdsTestNull() throws NoDataFoundException, InvalidDataException{
		String customerDataString="2343225,2345,us_east,RedTeam,ProjectApple,3445s" ;
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		  Map<Integer, Long> map = cs.getCustomerIdsForcontractIds(null);
		 
		  assertEquals(1, map.get(2345).intValue());
	}
	
	
	@Test
	public void getCustomerIdsForGeozoneTest() throws NoDataFoundException, InvalidDataException{
		
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		  Map<String, Set<CustomerData>> map = cs.getCustomerIdsForGeozone(testObject);
		  Map <String , Set<Integer>>  expectdMap= new HashMap<>();
		  HashMap <String , Set<Integer>>  actualMap= new HashMap<>();
		  Set<Integer> eu_westSet=new HashSet<Integer>();  
		  eu_westSet.add(3244132);
		  eu_westSet.add(3244332);
		  
		  Set<Integer> us_westSetExpectd=new HashSet<Integer>();
		  us_westSetExpectd.add(1223456);
		  us_westSetExpectd.add(1233456);
		  
		  Set<Integer> us_eastSet=new HashSet<Integer>();
		  us_eastSet.add(2343225);
		 
		  
		  expectdMap.put("eu_west", eu_westSet);
		  expectdMap.put("us_west", us_westSetExpectd);
		  expectdMap.put("us_east",us_eastSet);
		  
		  map.forEach((k, v) -> {
			  Set<Integer> actualSet=new HashSet<Integer>();
			  actualMap.put(k, actualSet);			  
				v.forEach(val -> {  actualMap.get(k).add(val.getCustomerId());
				});
			});	
				
		  assertEquals(actualMap,expectdMap);
	} 
	
	@Test
	public void getCustomerIdsForGeozoneSingleLine() throws NoDataFoundException, InvalidDataException{
		String customerDataString="2343225,2345,us_east,RedTeam,ProjectApple,3445s" ;
		Collection <CustomerData> testObject =cs.convertStringToCustomerData(customerDataString);
		  Map<String, Set<CustomerData>> map = cs.getCustomerIdsForGeozone(testObject);
		  Set<Integer> usEastSet=new HashSet<Integer>();  
		  Set<Integer> usEastSetExpectd=new HashSet<Integer>();
		  usEastSetExpectd.add(2343225);
		  map.forEach((k, v) -> 			
				v.forEach(val ->  usEastSet.add( val.getCustomerId()))); 
		  assertEquals(usEastSetExpectd,usEastSet);
	}
	
	@Test(expected = NoDataFoundException.class)
	public void getCustomerIdsForGeozoneNull() throws NoDataFoundException, InvalidDataException{
		  Map<String, Set<CustomerData>> map = cs.getCustomerIdsForGeozone(null);
	}

	
}
