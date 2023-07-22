package resources;

public enum API_enum {
	
	AddProgram("/saveprogram");
	
	public String resource;
	API_enum(String resource)
	{
		this.resource=resource;
	}
	
	public String getresource()
	{
		return resource;
	}

}
