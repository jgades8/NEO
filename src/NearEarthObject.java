
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
    public NearEarthObject(String neoReferenceId, String nasaJplUrl, Boolean isSentryObj, String name, Boolean isPotentiallyHazardous, double absoluteMagnitudeH, String links, String id, double estDiamMaxFt, double estDiamMinFt, double estDiamMaxKm, double estDiamMinKm, double estDiamMaxM, double estDiamMinM, double estDiamMaxMi, double estDiamMinMi, double relVelKmPHr, double relVelKmPSec, double relVelMPH, String orbitingBody, String closeApproachDate, double missDistAstronom, double missDistKm, double missDistLunar, double missDistMi) {
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

}
