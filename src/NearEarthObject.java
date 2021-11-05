import java.util.ArrayList;

public class NearEarthObject {

    // Class for Near Earth Objects
    // General Parameters
    private String neoReferenceId;
    private String nasaJplUrl;
    private Boolean isSentryObj;
    private String name;
    private Boolean isPotentiallyHazardous;
    private double absoluteMagnitudeH;
    private String links;
    private String id;

    // Estimated Diameter
    private double estDiamMaxFt;
    private double estDiamMinFt;
    private double estDiamMaxKm;
    private double estDiamMinKm;
    private double estDiamMaxM;
    private double estDiamMinM;
    private double estDiamMaxMi;
    private double estDiamMinMi;

    // Close Approach Data
    private double relVelKmPHr;
    private double relVelKmPSec;
    private double relVelMPH;
    private String orbitingBody;
    private String closeApproachDate;
    private double missDistAstronom;
    private double missDistKm;
    private double missDistLunar;
    private double missDistMi;

    // Constructor
    public NearEarthObject(String neoReferenceId, String nasaJplUrl, Boolean isSentryObj,
                           String name, Boolean isPotentiallyHazardous, double absoluteMagnitudeH,
                           String links, String id, double estDiamMaxFt, double estDiamMinFt,
                           double estDiamMaxKm, double estDiamMinKm, double estDiamMaxM,
                           double estDiamMinM, double estDiamMaxMi, double estDiamMinMi,
                           double relVelKmPHr, double relVelKmPSec, double relVelMPH,
                           String orbitingBody, String closeApproachDate, double missDistAstronom,
                           double missDistKm, double missDistLunar, double missDistMi) {
        this.neoReferenceId = neoReferenceId;
        this.nasaJplUrl = nasaJplUrl;
        this.isSentryObj = isSentryObj;
        this.name = name;
        this.isPotentiallyHazardous = isPotentiallyHazardous;
        this.absoluteMagnitudeH = absoluteMagnitudeH;
        this.links = links;
        this.id = id;
        this.estDiamMaxFt = estDiamMaxFt;
        this.estDiamMinFt = estDiamMinFt;
        this.estDiamMaxKm = estDiamMaxKm;
        this.estDiamMinKm = estDiamMinKm;
        this.estDiamMaxM = estDiamMaxM;
        this.estDiamMinM = estDiamMinM;
        this.estDiamMaxMi = estDiamMaxMi;
        this.estDiamMinMi = estDiamMinMi;
        this.relVelKmPHr = relVelKmPHr;
        this.relVelKmPSec = relVelKmPSec;
        this.relVelMPH = relVelMPH;
        this.orbitingBody = orbitingBody;
        this.closeApproachDate = closeApproachDate;
        this.missDistAstronom = missDistAstronom;
        this.missDistKm = missDistKm;
        this.missDistLunar = missDistLunar;
        this.missDistMi = missDistMi;
    }

    // Getters and Setters
    // Not necessary for now, but to be used for future use
    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public Boolean getSentryObj() {
        return isSentryObj;
    }

    public void setSentryObj(Boolean sentryObj) {
        isSentryObj = sentryObj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPotentiallyHazardous() {
        return isPotentiallyHazardous;
    }

    public void setPotentiallyHazardous(Boolean potentiallyHazardous) {
        isPotentiallyHazardous = potentiallyHazardous;
    }

    public double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getEstDiamMaxFt() {
        return estDiamMaxFt;
    }

    public void setEstDiamMaxFt(double estDiamMaxFt) {
        this.estDiamMaxFt = estDiamMaxFt;
    }

    public double getEstDiamMinFt() {
        return estDiamMinFt;
    }

    public void setEstDiamMinFt(double estDiamMinFt) {
        this.estDiamMinFt = estDiamMinFt;
    }

    public double getEstDiamMaxKm() {
        return estDiamMaxKm;
    }

    public void setEstDiamMaxKm(double estDiamMaxKm) {
        this.estDiamMaxKm = estDiamMaxKm;
    }

    public double getEstDiamMinKm() {
        return estDiamMinKm;
    }

    public void setEstDiamMinKm(double estDiamMinKm) {
        this.estDiamMinKm = estDiamMinKm;
    }

    public double getEstDiamMaxM() {
        return estDiamMaxM;
    }

    public void setEstDiamMaxM(double estDiamMaxM) {
        this.estDiamMaxM = estDiamMaxM;
    }

    public double getEstDiamMinM() {
        return estDiamMinM;
    }

    public void setEstDiamMinM(double estDiamMinM) {
        this.estDiamMinM = estDiamMinM;
    }

    public double getEstDiamMaxMi() {
        return estDiamMaxMi;
    }

    public void setEstDiamMaxMi(double estDiamMaxMi) {
        this.estDiamMaxMi = estDiamMaxMi;
    }

    public double getEstDiamMinMi() {
        return estDiamMinMi;
    }

    public void setEstDiamMinMi(double estDiamMinMi) {
        this.estDiamMinMi = estDiamMinMi;
    }

    public double getRelVelKmPHr() {
        return relVelKmPHr;
    }

    public void setRelVelKmPHr(double relVelKmPHr) {
        this.relVelKmPHr = relVelKmPHr;
    }

    public double getRelVelKmPSec() {
        return relVelKmPSec;
    }

    public void setRelVelKmPSec(double relVelKmPSec) {
        this.relVelKmPSec = relVelKmPSec;
    }

    public double getRelVelMPH() {
        return relVelMPH;
    }

    public void setRelVelMPH(double relVelMPH) {
        this.relVelMPH = relVelMPH;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    public String getCloseApproachDate() {
        return closeApproachDate;
    }

    public void setCloseApproachDate(String closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }

    public double getMissDistAstronom() {
        return missDistAstronom;
    }

    public void setMissDistAstronom(double missDistAstronom) {
        this.missDistAstronom = missDistAstronom;
    }

    public double getMissDistKm() {
        return missDistKm;
    }

    public void setMissDistKm(double missDistKm) {
        this.missDistKm = missDistKm;
    }

    public double getMissDistLunar() {
        return missDistLunar;
    }

    public void setMissDistLunar(double missDistLunar) {
        this.missDistLunar = missDistLunar;
    }

    public double getMissDistMi() {
        return missDistMi;
    }

    public void setMissDistMi(double missDistMi) {
        this.missDistMi = missDistMi;
    }

    public void printGeneralInfo() {
        System.out.println("Name: " + getName());
        System.out.println("NEO Reference ID: " + getNeoReferenceId());
        System.out.println("ID: " + getId());
        System.out.println("Absolute Magnitude (H): " + getAbsoluteMagnitudeH());
        System.out.println("Is potentially hazardous: " + getPotentiallyHazardous());
        System.out.println("Is sentry object: " + getSentryObj());
        System.out.println("NASA JPL URL: " + getNasaJplUrl());
        System.out.println("Links: " + getLinks() + "\n");
        return;
    }

    public void printEstDiamInfo() {
        System.out.println("Diameter information of NEO reference ID " + getNeoReferenceId());

        System.out.println("Estimated maximum diameter in feet: " + getEstDiamMaxFt());
        System.out.println("Estimated minimum diameter in feet: " + getEstDiamMinFt());

        System.out.println("Estimated maximum diameter in miles: " + getEstDiamMaxMi());
        System.out.println("Estimated minimum diameter in miles: " + getEstDiamMinMi());

        System.out.println("Estimated maximum diameter in meters: " + getEstDiamMaxM());
        System.out.println("Estimated minimum diameter in meters: " + getEstDiamMinM());

        System.out.println("Estimated maximum diameter in kilometers: " + getEstDiamMaxKm());
        System.out.println("Estimated minimum diameter in kilometers: " + getEstDiamMinKm() + "\n");
    }

    public void printVelData() {
        System.out.println("Velocity information of NEO reference ID " + getNeoReferenceId());

        System.out.println("Relative velocity in miles per hour: " + getRelVelMPH());
        System.out.println("Relative velocity in kilometers per hour: " + getRelVelKmPHr());
        System.out.println("Relative velocity in kilometers per second: " + getRelVelKmPSec());
    }

    public void printMissData() {
        System.out.println("NEO reference ID " + getNeoReferenceId() + " is near " + getOrbitingBody() + " on " + getCloseApproachDate());

        System.out.println("Miss distance (astronomical): " + getMissDistAstronom());
        System.out.println("Miss distance (lunar): " + getMissDistLunar());
        System.out.println("Miss distance (miles): " + getMissDistMi());
        System.out.println("Miss distance (kilometers): " + getMissDistKm() + "\n");
    }

    public void printAllData() {
        printGeneralInfo();
        printEstDiamInfo();
        printVelData();
        printMissData();
        return;
    }

    // Prints information for all potentially hazardous or all not hazardous
    public static void printOnlyHazardous(String wantHazardous, ArrayList<NearEarthObject> list) throws Exception {
        // Loop through arraylist of NEOs
        for (NearEarthObject neo : list) {
            // Based on wantHazardous response, print correct options
            switch (wantHazardous) {
                case "1":
                    // If potentially hazardous is true, print data
                    if (neo.getPotentiallyHazardous()) {
                        neo.printAllData();
                        break;
                    } else {continue;}
                case "2":
                    // If potentially hazardous is false, print data
                    if (!neo.getPotentiallyHazardous()) {
                        neo.printAllData();
                        break;
                    } else {continue;}
                case "3":
                    // Print data regardless of hazardous
                    neo.printAllData();
                    break;
                default:
                    throw new Exception(wantHazardous + " not a valid option.");
            }
        }
        return;
    }

}
