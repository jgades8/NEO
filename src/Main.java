import java.net.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
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

                    // Get data within close approach data
                    JSONArray closeApproachData = (JSONArray) specificAsteroid.get("close_approach_data");
                    // Use get(0) since each asteroid only has one close approach date
                    JSONObject approachData = (JSONObject) closeApproachData.get(0);

                    // Get relative velocity object
                    JSONObject relVelocity = (JSONObject) approachData.get("relative_velocity");

                    // Get miss distance object
                    JSONObject missDistance = (JSONObject) approachData.get("miss_distance");

                    // Get estimated diameter objects
                    JSONObject estDiam = (JSONObject) specificAsteroid.get("estimated_diameter");
                    JSONObject estDiamFt = (JSONObject) estDiam.get("feet");
                    JSONObject estDiamKm = (JSONObject) estDiam.get("kilometers");
                    JSONObject estDiamM = (JSONObject) estDiam.get("meters");
                    JSONObject estDiamMi = (JSONObject) estDiam.get("miles");


                    // Get links object
                    JSONObject linksObj = (JSONObject) specificAsteroid.get("links");

                    // Create new NEO object and add to array
                    NearEarthObject neo = new NearEarthObject((String) specificAsteroid.get("neo_reference_id"),
                            (String) specificAsteroid.get("nasa_jpl_url"), (boolean) specificAsteroid.get("is_sentry_object"),
                            (String) specificAsteroid.get("name"), (boolean) specificAsteroid.get("is_potentially_hazardous_asteroid"),
                            (Double) specificAsteroid.get("absolute_magnitude_h"), (String) linksObj.get("self"), (String) specificAsteroid.get("id"),
                            (Double) estDiamFt.get("estimated_diameter_max"), (Double) estDiamFt.get("estimated_diameter_min"),
                            (Double) estDiamKm.get("estimated_diameter_max"), (Double) estDiamKm.get("estimated_diameter_min"),
                            (Double) estDiamM.get("estimated_diameter_max"), (Double) estDiamM.get("estimated_diameter_min"),
                            (Double) estDiamMi.get("estimated_diameter_max"), (Double) estDiamMi.get("estimated_diameter_min"),
                            Double.parseDouble((String) relVelocity.get("kilometers_per_hour")),
                            Double.parseDouble((String) relVelocity.get("kilometers_per_second")),
                            Double.parseDouble((String) relVelocity.get("miles_per_hour")), (String) approachData.get("orbiting_body"),
                            (String) approachData.get("close_approach_date"), Double.parseDouble((String) missDistance.get("astronomical")),
                            Double.parseDouble((String) missDistance.get("kilometers")), Double.parseDouble((String) missDistance.get("lunar")),
                            Double.parseDouble((String) missDistance.get("miles")));
                    nearEarthObjectArrayList.add(neo);


                    // Increment iterator values
                    itr.next();
                    ++i;
                }

                // Verify that there are more than 0 objects in array list
                if (nearEarthObjectArrayList.isEmpty()) {
                    throw new IndexOutOfBoundsException();
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
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            Date javaDate = dateFormat.parse(date);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return false;
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