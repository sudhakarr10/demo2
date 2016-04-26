package com.emp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/v1/EmployeeUnit")
public class EmployeeUnit {

	private EmpUnitDao empUnitDao;
	public static final String SUCCESS_RESULT="<result>success</result>";
	public static final String FAILURE_RESULT="<result>failure</result>";

	public EmployeeUnit() 
	{
		this.empUnitDao = new EmpUnitDao();
	}

	public EmployeeUnit(EmpUnitDao mockedEmpDao) {
		// TODO Auto-generated constructor stub
		this.empUnitDao = mockedEmpDao;
	}







	@GET
	@Path("/allEmpUnits")
	@Produces(MediaType.APPLICATION_XML)
	public String getAllEmpAndUnits(){
		HashMap<String,String> map1 = (HashMap<String, String>) empUnitDao.getAllEmployeeAndUnits();		
		HashMap<String,String> map2 = new HashMap<String,String> (); 
		String value = null; 
		for(String key: map1.keySet()) 
		{
			value = map1.get(key);
			map2.put(key.toUpperCase(), value.toUpperCase()); 
		}


		StringBuffer result = new StringBuffer();		
		if (map2 != null) 
		{

			result.append(SUCCESS_RESULT);    
			for(String key:map2.keySet() )
			{
				result.append("<empid>"+key+"<empid>"); 
				result.append("<unit>"+map2.get(key)+"<unit>"); 
			}

		}
		else 
		{
			result.append(FAILURE_RESULT); 
		}
		return result.toString();
	}

	@GET
	@Path("/empUnit/{empid}")
	@Produces(MediaType.APPLICATION_XML)
	public String getUnit(@PathParam("empid") String empid){
		
		String unit = empUnitDao.getUnit(empid).toUpperCase();
		
		StringBuffer result = new StringBuffer();		
		if (unit != null ) 
		{
			result.append(SUCCESS_RESULT);    
			result.append("<unit>"+unit+"<unit>"); 
		}
		else
		{
			result.append(FAILURE_RESULT); 
		}
		
		return result.toString(); 
	}

	@PUT
	@Path("/createEmpUnit")
	@Produces(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createEmpUnit(@QueryParam("empid") String empid,
			@QueryParam("unit") String unit) {
		int result = empUnitDao.createEmpUnit(empid,unit);
		if(result == 1){
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@POST
	@Path("/updateEmpUnit")
	@Produces(MediaType.TEXT_XML)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateEmpUnit(@QueryParam("empid") String empid,
			@QueryParam("unit") String unit) {
		int result = empUnitDao.updateEmpUnit(empid,unit);
		if(result == 1){
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@DELETE
	@Path("/deleteEmpUnit/{empid}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteEmpUnit(@PathParam("empid") String empid){
		int result = empUnitDao.deleteEmpUnit(empid);
		if(result == 1){
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}	   


}


