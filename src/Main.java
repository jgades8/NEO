import java.net.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

    public static void main(String[] args) {
        try {

            // Get date input
            String date = getDateInput();

            // Connect to NASA NEO API and get basic data
            URL url = new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=" + date + "&end_date=" +
                    date + "&api_key=zyfNxc8RLnE7oHuzTiA5xPCJ35J4koH3rNTlio85");
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

                // Print total element count
                Long count = (Long) data_obj.get("element_count");
                System.out.println("There are " + count + " total near Earth objects for " + date);

                // Narrow data down into one date of near Earth objects
                JSONObject nearEarthObjects = (JSONObject) data_obj.get("near_earth_objects");
                JSONArray specificDate = (JSONArray) nearEarthObjects.get(date);

                // Create iterator and index i
                Iterator itr = specificDate.iterator();
                int i = 0;

                // Create array to store NEOs
                ArrayList<NearEarthObject> nearEarthObjectArrayList = new ArrayList<NearEarthObject>();

                // Print new line
                System.out.print("\n");

                while (itr.hasNext()) {

                    // Get data for specific asteroid based on index i
                    JSONObject specificAsteroid = (JSONObject) specificDate.get(i);

                    // Get general data
                    String neoReferenceId = (String) specificAsteroid.get("neo_reference_id");
                    String nasaJplUrl = (String) specificAsteroid.get("nasa_jpl_url");
                    Boolean isPotentiallyHazardous = (boolean) specificAsteroid.get("is_potentially_hazardous_asteroid");
                    Boolean isSentry = (boolean) specificAsteroid.get("is_sentry_object");
                    String name = (String) specificAsteroid.get("name");
                    Double absoluteMagnitudeH = (Double) specificAsteroid.get("absolute_magnitude_h");
                    String id = (String) specificAsteroid.get("id");

                    // Get data within close approach data
                    JSONArray closeApproachData = (JSONArray) specificAsteroid.get("close_approach_data");
                    // Use get(0) since each asteroid only has one close approach date
                    JSONObject approachData = (JSONObject) closeApproachData.get(0);
                    String orbitingBody = (String) approachData.get("orbiting_body");
                    String closeApproachDate = (String) approachData.get("close_approach_date");

                    // Relative velocity data
                    JSONObject relVelocity = (JSONObject) approachData.get("relative_velocity");
                    Double relVelKmPHr = Double.parseDouble((String) relVelocity.get("kilometers_per_hour"));
                    Double relVelKmPSec = Double.parseDouble((String) relVelocity.get("kilometers_per_second"));
                    Double relVelMPH = Double.parseDouble((String) relVelocity.get("miles_per_hour"));

                    // Miss distance data
                    JSONObject missDistance = (JSONObject) approachData.get("miss_distance");
                    Double missDistAstronom = Double.parseDouble((String) missDistance.get("astronomical"));
                    Double missDistKm = Double.parseDouble((String) missDistance.get("kilometers"));
                    Double missDistLunar = Double.parseDouble((String) missDistance.get("lunar"));
                    Double missDistMi = Double.parseDouble((String) missDistance.get("miles"));

                    // Get estimated diameter data
                    JSONObject estDiam = (JSONObject) specificAsteroid.get("estimated_diameter");
                    JSONObject estDiamFt = (JSONObject) estDiam.get("feet");
                    Double estDiamMaxFt = (Double) estDiamFt.get("estimated_diameter_max");
                    Double estDiamMinFt = (Double) estDiamFt.get("estimated_diameter_min");
                    JSONObject estDiamKm = (JSONObject) estDiam.get("kilometers");
                    Double estDiamMaxKm = (Double) estDiamKm.get("estimated_diameter_max");
                    Double estDiamMinKm = (Double) estDiamKm.get("estimated_diameter_min");
                    JSONObject estDiamM = (JSONObject) estDiam.get("meters");
                    Double estDiamMaxM = (Double) estDiamM.get("estimated_diameter_max");
                    Double estDiamMinM = (Double) estDiamM.get("estimated_diameter_min");
                    JSONObject estDiamMi = (JSONObject) estDiam.get("miles");
                    Double estDiamMaxMi = (Double) estDiamMi.get("estimated_diameter_max");
                    Double estDiamMinMi = (Double) estDiamMi.get("estimated_diameter_min");

                    // Get links data
                    JSONObject linksObj = (JSONObject) specificAsteroid.get("links");
                    String links = (String) linksObj.get("self");

                    // Create new NEO object and add to array
                    NearEarthObject neo = new NearEarthObject(neoReferenceId, nasaJplUrl, isSentry, name, isPotentiallyHazardous,
                            absoluteMagnitudeH, links, id, estDiamMaxFt, estDiamMinFt, estDiamMaxKm, estDiamMinKm,
                            estDiamMaxM, estDiamMinM, estDiamMaxMi, estDiamMinMi, relVelKmPHr, relVelKmPSec,
                            relVelMPH, orbitingBody, closeApproachDate, missDistAstronom, missDistKm,
                            missDistLunar, missDistMi);
                    nearEarthObjectArrayList.add(neo);

//                        // Print data
//                        nearEarthObjectArrayList.get(i).printGeneralInfo();
//                        nearEarthObjectArrayList.get(i).printMissData();
//                        nearEarthObjectArrayList.get(i).printEstDiamInfo();
//                        nearEarthObjectArrayList.get(i).printVelData();

                    // Increment iterator values
                    itr.next();
                    ++i;
                }

                // Allow user to choose if they want only potentially hazardous, not hazardous, or all data
                String wantOnlyHazardous = getHazardousInput();
                NearEarthObject.printOnlyHazardous(wantOnlyHazardous, nearEarthObjectArrayList);

            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Other methods
    // Get date input from user
    public static String getDateInput() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a date with the following format (YYYY-MM-DD): ");

        String date = myScanner.nextLine();

        // Verify input
        if (verifyDateFormat(date)) {
            return date;
        } else {
            System.out.println("Invalid date format.\n");
            // Call function recursively until date format is valid
            return getDateInput();
        }
    }

    // Verify date input
    public static boolean verifyDateFormat(String date) {
        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if ( i == 4 | i == 7 ) {
                if (c == '-') {continue;}
                else {return false;}
            } else {
                if (Character.isDigit(c)) {continue;}
                else {return false;}
            }
        }
        return true;
    }

    public static String getHazardousInput() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Do you want only potentially hazardous data? Enter 1 for yes, 2 for only not hazardous," +
                "or 3 for all data: ");

        String response = myScanner.nextLine();

        // Verify input
        switch(response) {
            case "1":
            case "2":
            case "3":
                return response;
            default:
                System.out.println("Invalid response.");
                return getHazardousInput();
        }
    }

    // Ideas: set time range, maybe within week, within day, etc.
    // count, min/max diameter, is potentially hazardous, velocity, close approach date
    // Add some sort of filter option

}