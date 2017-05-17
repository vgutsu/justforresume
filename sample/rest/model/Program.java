package com.cinecentre.cinecentrecinema.rest.model;

/**
 * Created by victg on 27.01.2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Program {

    @SerializedName("ProgramId")
    @Expose
    private int programId;
    @SerializedName("ProgramDescription")
    @Expose
    private String programDescription;
    @SerializedName("ProgramGroupDescription")
    @Expose
    private String programGroupDescription;
    @SerializedName("ProgramType")
    @Expose
    private int programType;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Genre")
    @Expose
    private String genre;
    @SerializedName("Rating")
    @Expose
    private String rating;
    @SerializedName("Length")
    @Expose
    private int length;
    @SerializedName("Release_Date")
    @Expose
    private String releaseDate;
    @SerializedName("Format_ID")
    @Expose
    private int formatID;
    @SerializedName("Format_Description")
    @Expose
    private String formatDescription;
    @SerializedName("Cast")
    @Expose
    private String cast;
    @SerializedName("Synopsis1")
    @Expose
    private String synopsis1;
    @SerializedName("Synopsis2")
    @Expose
    private String synopsis2;
    @SerializedName("ExternalProgramId")
    @Expose
    private int externalProgramId;
    @SerializedName("EDINumber")
    @Expose
    private int eDINumber;
    @SerializedName("ProgramGroupID")
    @Expose
    private int programGroupID;
    @SerializedName("RateCardID")
    @Expose
    private int rateCardID;
    @SerializedName("Director")
    @Expose
    private String director;
    @SerializedName("Trailer_Url")
    @Expose
    private String trailerUrl;

    /**
     * No args constructor for use in serialization
     */
    public Program() {
    }

    /**
     * @param genre
     * @param rateCardID
     * @param synopsis2
     * @param externalProgramId
     * @param synopsis1
     * @param director
     * @param trailerUrl
     * @param programGroupID
     * @param programId
     * @param releaseDate
     * @param cast
     * @param eDINumber
     * @param programGroupDescription
     * @param formatID
     * @param programDescription
     * @param length
     * @param formatDescription
     * @param language
     * @param rating
     * @param programType
     */
    public Program(int programId, String programDescription, String programGroupDescription, int programType, String language, String genre, String rating, int length, String releaseDate, int formatID, String formatDescription, String cast, String synopsis1, String synopsis2, int externalProgramId, int eDINumber, int programGroupID, int rateCardID, String director, String trailerUrl) {
        super();
        this.programId = programId;
        this.programDescription = programDescription;
        this.programGroupDescription = programGroupDescription;
        this.programType = programType;
        this.language = language;
        this.genre = genre;
        this.rating = rating;
        this.length = length;
        this.releaseDate = releaseDate;
        this.formatID = formatID;
        this.formatDescription = formatDescription;
        this.cast = cast;
        this.synopsis1 = synopsis1;
        this.synopsis2 = synopsis2;
        this.externalProgramId = externalProgramId;
        this.eDINumber = eDINumber;
        this.programGroupID = programGroupID;
        this.rateCardID = rateCardID;
        this.director = director;
        this.trailerUrl = trailerUrl;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getProgramGroupDescription() {
        return programGroupDescription;
    }

    public void setProgramGroupDescription(String programGroupDescription) {
        this.programGroupDescription = programGroupDescription;
    }

    public int getProgramType() {
        return programType;
    }

    public void setProgramType(int programType) {
        this.programType = programType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getFormatID() {
        return formatID;
    }

    public void setFormatID(int formatID) {
        this.formatID = formatID;
    }

    public String getFormatDescription() {
        return formatDescription;
    }

    public void setFormatDescription(String formatDescription) {
        this.formatDescription = formatDescription;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getSynopsis1() {
        return synopsis1;
    }

    public void setSynopsis1(String synopsis1) {
        this.synopsis1 = synopsis1;
    }

    public String getSynopsis2() {
        return synopsis2;
    }

    public void setSynopsis2(String synopsis2) {
        this.synopsis2 = synopsis2;
    }

    public int getExternalProgramId() {
        return externalProgramId;
    }

    public void setExternalProgramId(int externalProgramId) {
        this.externalProgramId = externalProgramId;
    }

    public int getEDINumber() {
        return eDINumber;
    }

    public void setEDINumber(int eDINumber) {
        this.eDINumber = eDINumber;
    }

    public int getProgramGroupID() {
        return programGroupID;
    }

    public void setProgramGroupID(int programGroupID) {
        this.programGroupID = programGroupID;
    }

    public int getRateCardID() {
        return rateCardID;
    }

    public void setRateCardID(int rateCardID) {
        this.rateCardID = rateCardID;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

}
