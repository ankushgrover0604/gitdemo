package resources;

public enum EnumResource {
	
	// enum is a special class which has collection of constant methods and variables
	AddPlaceApi("/maps/api/place/add/json"),
	GetPlace("/maps/api/place/get/json"),
	DeletePlaceApi("/maps/api/place/delete/json");
	
	private String resource;

	EnumResource(String resource){
		
		this.resource = resource;
	}

	public String getResource() {
		
		return resource;
	} 
}
