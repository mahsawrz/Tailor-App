package com.example.eshopsample.model;

public class Response {
  private String CR_ID;
    private String CR_RegisterDate;
    private String CR_RegisterTime;
    private String CR_ResponseDate;
    private String   CR_ResponseTime;
    private String     U_ID_fk;
    private String   CR_ResponseDescription;
    private String   CR_RegisterDescription;
    private String     CR_Image;

    public Response(String CR_ID, String CR_RegisterDate, String CR_RegisterTime, String CR_ResponseDate, String CR_ResponseTime, String u_ID_fk, String CR_ResponseDescription, String CR_RegisterDescription, String CR_Image) {
        this.CR_ID = CR_ID;
        this.CR_RegisterDate = CR_RegisterDate;
        this.CR_RegisterTime = CR_RegisterTime;
        this.CR_ResponseDate = CR_ResponseDate;
        this.CR_ResponseTime = CR_ResponseTime;
        U_ID_fk = u_ID_fk;
        this.CR_ResponseDescription = CR_ResponseDescription;
        this.CR_RegisterDescription = CR_RegisterDescription;
        this.CR_Image = CR_Image;
    }

    public String getCR_ID() {
        return CR_ID;
    }

    public void setCR_ID(String CR_ID) {
        this.CR_ID = CR_ID;
    }

    public String getCR_RegisterDate() {
        return CR_RegisterDate;
    }

    public void setCR_RegisterDate(String CR_RegisterDate) {
        this.CR_RegisterDate = CR_RegisterDate;
    }

    public String getCR_RegisterTime() {
        return CR_RegisterTime;
    }

    public void setCR_RegisterTime(String CR_RegisterTime) {
        this.CR_RegisterTime = CR_RegisterTime;
    }

    public String getCR_ResponseDate() {
        return CR_ResponseDate;
    }

    public void setCR_ResponseDate(String CR_ResponseDate) {
        this.CR_ResponseDate = CR_ResponseDate;
    }

    public String getCR_ResponseTime() {
        return CR_ResponseTime;
    }

    public void setCR_ResponseTime(String CR_ResponseTime) {
        this.CR_ResponseTime = CR_ResponseTime;
    }

    public String getU_ID_fk() {
        return U_ID_fk;
    }

    public void setU_ID_fk(String u_ID_fk) {
        U_ID_fk = u_ID_fk;
    }

    public String getCR_ResponseDescription() {
        return CR_ResponseDescription;
    }

    public void setCR_ResponseDescription(String CR_ResponseDescription) {
        this.CR_ResponseDescription = CR_ResponseDescription;
    }

    public String getCR_RegisterDescription() {
        return CR_RegisterDescription;
    }

    public void setCR_RegisterDescription(String CR_RegisterDescription) {
        this.CR_RegisterDescription = CR_RegisterDescription;
    }

    public String getCR_Image() {
        return CR_Image;
    }

    public void setCR_Image(String CR_Image) {
        this.CR_Image = CR_Image;
    }
}
