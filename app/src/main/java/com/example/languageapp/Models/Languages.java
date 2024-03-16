package com.example.languageapp.Models;

public class Languages {

    private String no;
    private String language;
    private String country;


    public Languages(){

    }

    public Languages(String no, String language, String country){
        this.no = no;
        this.language = language;
        this.country = country;
    }
    public void setNo(String no){
        this.no = no;
    }

    public void setLanguage(String language){
        this.language = language;
    }
    public void setCountry(String no){
        this.country = country;
    }

    public String getNo(){
        return no;
    }
    public String getLanguage(){
        return language;
    }

    public String getCountry(){
        return country;
    }
}
