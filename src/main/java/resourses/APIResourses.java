package resourses;
//enum is special class in java which has collection of constants or methods

public enum APIResourses {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
private String Api;
	APIResourses(String Api) {
		// TODO Auto-generated constructor stub
		this.Api=Api;
	}
	
	public String getResource() {
		
		return Api;
	}

}
