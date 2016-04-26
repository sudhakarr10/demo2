package com.emp;




import static org.junit.Assert.*; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.emp.EmpUnitDao;
import com.emp.EmployeeUnit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;


/**
 * @author sudhakar_r10
 *
 */
public class EmployeeUnitTest {

	
	private static HashMap<String,String> map1;
	private static EmpUnitDao mockedEmpDao;
	/**
	 * @throws java.lang.Exception 
	 */
	@Before
	public void setUp() throws Exception {
		
		mockedEmpDao = mock(EmpUnitDao.class);
		map1 = new HashMap <String,String> ();
		map1.put("sudhakar_r10","eng");
		map1.put ("nepolean","fin");
		
		when(mockedEmpDao.getAllEmployeeAndUnits()).thenReturn(map1);
		when(mockedEmpDao.getUnit("sudhakar_r10")).thenReturn("eng");
		when(mockedEmpDao.createEmpUnit("chethan","eng")).thenReturn(1);
		when(mockedEmpDao.updateEmpUnit("nepolean","eng")).thenReturn(1);
		when(mockedEmpDao.deleteEmpUnit("chethan")).thenReturn(1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		
	}

	/**
	 * Test method for {@link com.dem.Demo.EmployeeUnit#getAllEmpAndUnits()}.
	 */
	@Test
	public void testGetAllEmpAndUnits() {
		EmployeeUnit empUnit = new EmployeeUnit(mockedEmpDao);
	//	assertTrue(empUnit.getAllEmpAndUnits().size() == 2);
		assertTrue(empUnit.getAllEmpAndUnits().contains(EmployeeUnit.SUCCESS_RESULT));
		assertTrue(empUnit.getAllEmpAndUnits().contains("SUDHAKAR_R10"));
		assertTrue(empUnit.getAllEmpAndUnits().contains("NEPOLEAN"));
		assertTrue(empUnit.getAllEmpAndUnits().contains("ENG"));
		assertTrue(empUnit.getAllEmpAndUnits().contains("FIN")); 
		
	}

	/**
	 * Test method for {@link com.dem.Demo.EmployeeUnit#getUnit(java.lang.String)}.
	 */
	@Test
	public void testGetUnit() {
		EmployeeUnit empUnit = new EmployeeUnit(mockedEmpDao); 
		assertTrue(empUnit.getAllEmpAndUnits().contains(EmployeeUnit.SUCCESS_RESULT));
		assertTrue(empUnit.getUnit("sudhakar_r10").contains("ENG"));
	}

	/**
	 * Test method for {@link com.dem.Demo.EmployeeUnit#createEmpUnit(java.lang.String, java.lang.String, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testCreateEmpUnit() {
		EmployeeUnit empUnit = new EmployeeUnit(mockedEmpDao); 
		assertEquals(EmployeeUnit.SUCCESS_RESULT,empUnit.createEmpUnit("chethan","eng"));
	}

	/**
	 * Test method for {@link com.dem.Demo.EmployeeUnit#updateEmpUnit(java.lang.String, java.lang.String, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testUpdateEmpUnit() {
		EmployeeUnit empUnit = new EmployeeUnit(mockedEmpDao); 
		assertEquals(EmployeeUnit.SUCCESS_RESULT,empUnit.updateEmpUnit("nepolean","eng"));
	}

	/**
	 * Test method for {@link com.dem.Demo.EmployeeUnit#deleteEmpUnit(java.lang.String)}.
	 */
	@Test
	public void testDeleteEmpUnit() {
		EmployeeUnit empUnit = new EmployeeUnit(mockedEmpDao); 
		assertEquals(EmployeeUnit.SUCCESS_RESULT,empUnit.deleteEmpUnit("chethan"));     
	}

}
