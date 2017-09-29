
package com.od;




public class ODAminitiesService {
	
	public int aminitiesId;
	public String aminitiesName ;
	
	public String aminitiesPath;
	
	
	public ODAminitiesService(int aminitiesId, String aminitiesName, String aminitiesPath) {
		super();
		
		this.aminitiesId=aminitiesId;
		this.aminitiesName=aminitiesName;
		this.aminitiesPath=aminitiesPath;
		
		
		
	}
	
	public int getAminitiesId() {
		return aminitiesId;
	}

	public void setAminitiesId(int aminitiesId) {
		this.aminitiesId = aminitiesId;
	}

	public String getAminitiesName() {
		return aminitiesName;
	}

	public void setAminitiesName(String aminitiesName) {
		this.aminitiesName = aminitiesName;
	}

	public String getAminitiesPath() {
		return aminitiesPath;
	}

	public void setAminitiesPath(String aminitiesPath) {
		this.aminitiesPath = aminitiesPath;
	}

	public ODAminitiesService(){
		
	}

}
