package resources;

import java.util.HashMap;

public class TestData {

	public static HashMap<String, Object> programPayload()
	{
		HashMap<String,Object> programdata=new HashMap<>();
		programdata.put("programDescription", "Postman Hackathon-447");
		programdata.put("programName", "Jun23-API Tracker-SDET-446");
		programdata.put("programStatus", "active");
		
		return programdata;
	}

}
