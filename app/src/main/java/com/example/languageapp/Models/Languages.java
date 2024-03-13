package com.example.languageapp.Models;

public class Languages {

    private String no;
    private String langage;
    private String countyry;


    public Languages(){

    }

    public Languages(String no, String langage, String countyry){
        this.no = no;
        this.langage = langage;
        this.countyry = countyry;

    }
    public void setNo(String no){
        this.no = no;
    }

    public void setLangage(String langage){
        this.langage = langage;
    }
    public void setCountyry(String no){
        this.countyry = countyry;
    }

    public String getNo(){
        return no;
    }
    public String getLangage(){
        return langage;
    }

    public String getCountyry(){
        return countyry;
    }
}
