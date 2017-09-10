/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ayah
 */
public class Hollywood extends Movie {
    
    
 public Hollywood (String title, String []satrring, int runningTime, String country, String language) {
        super(title, satrring, runningTime, country, language);
    }
 @Override
    public String toString() {
        return "Rescue{ title="+getTilte() +  ", starring=" + getStarring()+ ", runningTime=" + getRunningTime() + ", country=" + getCountry() + ", language=" +getLanguage()+ '}';}
}

