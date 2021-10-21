import java.net.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

    public static void main(String[] args) {
            try {
                // Set date
                String startDate = "2021-09-07";
                String endDate = "2021-09-08";

                // Connect to NASA NEO API and get basic data
                URL url = new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=" + startDate + "&end_date=" +
                        endDate + "&api_key=zyfNxc8RLnE7oHuzTiA5xPCJ35J4koH3rNTlio85");
                System.out.println("Protocol: " + url.getProtocol());
                System.out.println("Host Name: " + url.getHost());
                System.out.println("File Name: " + url.getFile());

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Get response code
                int responseCode = connection.getResponseCode();

                // Verify response code
                if (responseCode != 200) {
                    throw new RuntimeException("HTTP Response Code: " + responseCode);
                } else {

                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext()) {
                        inline += scanner.nextLine();
                    }

                    // Close the scanner
                    scanner.close();

                    // Using the JSON simple library parse the string into a json object
                    JSONParser parser = new JSONParser();
                    JSONObject data_obj = (JSONObject) parser.parse(inline);
                    JSONArray array = new JSONArray();
                    array.add(data_obj);

                    // Narrow data down into one date of near Earth objects
                    JSONObject nearEarthObjects = (JSONObject) data_obj.get("near_earth_objects");
                    JSONArray specificDate = (JSONArray) nearEarthObjects.get(startDate);

                    // Create iterator and index i
                    Iterator itr = specificDate.iterator();
                    int i = 0;

                    while (itr.hasNext()) {

                        // Print new line
                        System.out.print("\n");

                        // Get data for specific asteroid based on index i
                        JSONObject specificAsteroid = (JSONObject) specificDate.get(i);
                        // Print data
                        System.out.println("Name: " + specificAsteroid.get("name"));
                        System.out.println("ID: " + specificAsteroid.get("id"));
                        // Get data within close approach data
                        JSONArray closeApproachData = (JSONArray) specificAsteroid.get("close_approach_data");
                        // Use get(0) since each asteroid only has one close approach date
                        JSONObject approachData = (JSONObject) closeApproachData.get(0);
                        JSONObject missDistance = (JSONObject) approachData.get("miss_distance");
                        // Prints entire distance object
                        // System.out.println("Distance: " + missDistance);
                        String milesMissDistance = (String) missDistance.get("miles");
                        System.out.println("Closest distance to Earth in miles: " + milesMissDistance);
                        System.out.println("Is potentially hazardous asteroid: " + specificAsteroid.get("is_potentially_hazardous_asteroid"));

                        // Increment iterator values
                        itr.next();
                        ++i;
                    }

                }
            } catch(Exception e) {
                System.out.println(e);
            }
        }

    // Ideas: set time range, maybe within week, within day, etc.
    // count, min/max diameter, is potentially hazardous, velocity, close approach date
    // Create class for NEOs that contain all data
    // Get input from user (start and end dates?)
    // Method to verify date format

}
