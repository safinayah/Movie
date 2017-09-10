/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;

/**
 *
 * @author ayah
 */
public class Action extends Movie {

    public Action(String title, String[] starring, int runningTime, String country, String language) {
        super(title, starring, runningTime, country, language);
    }
    
    
 
 @Override
    public String toString() {
        return "Action{ title="+getTilte() +  ", starring=" + Arrays.toString(getStarring())+ ", runningTime=" + getRunningTime() + ", country=" + getCountry() + ", language=" +getLanguage()+ '}';}
}