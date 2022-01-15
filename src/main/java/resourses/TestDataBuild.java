package resourses;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;


public class TestDataBuild {
	
	public AddPlace addPlacepayload(String name, String language, String address) {
		
		List<String> type=new ArrayList<String>();
		type.add("shop"); type.add("shoe park");
		
		Location loc=new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		AddPlace ap=new AddPlace();
		ap.setAccuracy(40);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setLocation(loc);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setTypes(type);
		ap.setWebsite("http://google.com");
		return ap;
		
		
	}
	
	public String deletePlacePayload(String placeid) {
	
	return "{ \r\n"
			+ "\r\n"
			+ "    \"place_id\":\""+placeid+"\" \r\n"
			+ "\r\n"
			+ "} ";

}
}
