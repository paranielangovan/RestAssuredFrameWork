package com.TestData;

import io.restassured.specification.RequestSpecification;
import org.Pojos.com.AddLocation;
import org.Pojos.com.LocationPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddLocations {

    public AddLocation add_Location(String Accuracy,String Address,String Name,String PhoneNumber,String Shoe,String Shop,double Latitud,double Langitud){
        AddLocation addLocation = new AddLocation();
        addLocation.setAccuracy(Accuracy);
        addLocation.setAddress(Address);
        addLocation.setName(Name);
        addLocation.setPhone_number(PhoneNumber);
        List<String> mylist= new ArrayList<>();
        mylist.add(Shoe);
        mylist.add(Shop);
        addLocation.setTypes(mylist);
        LocationPojo lc = new LocationPojo();
        lc.setLat(Latitud);
        lc.setLng(Langitud);
        addLocation.setLocation(lc);

        return addLocation;
    }


}
