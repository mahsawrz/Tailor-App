package com.example.eshopsample.model;

public class WStyle {

    private String styleName;
    private String flagName;
    private String faStyleName;



    public WStyle(String styleName, String flagName, String faStyleName) {
        this.styleName = styleName;
        this.flagName= flagName;
        this.faStyleName = faStyleName;
    }

    public String getFaStyleName() {
        return faStyleName;
    }

    public void setFaStyleName(String faStyleName) {
        this.faStyleName = faStyleName;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }


    
}