package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.location;
import pojo.locationdata;

public class TestDatabuild {

	public locationdata addPlacePayload(String name, String language, String adress) {
		
		locationdata ld = new locationdata();
		ld.setAccuracy(50);
		ld.setAddress(adress);
		ld.setLanguage(language);
		ld.setPhone_number(name);
		ld.setName(name);
		ld.setWebsite("rahulshetty academy");
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("112");
		ld.setTypes(list);
		location loc = new location();
		loc.setLat(12);
		loc.setLng(12);
		ld.setLocation(loc);
		
		return ld;
	}

public String Delete(String place_iddata) {
	
	
	return "{\r\nplace_id : \"" + place_iddata +"\"\r\n}";
	
}
}

