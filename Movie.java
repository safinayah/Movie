

import java.util.Arrays;



/* @author Ayah Sa'fin  1160063
 */
public class Movie implements Cloneable, Comparable <Movie> {
    private String title ; 
    private String [] starring;
    private int runningTime; 
    private String country ; 
    private String language; 

    public Movie(String title, String[] starring, int runningTime, String country, String language) {
        this.title = title;
        this.starring = starring;
        this.runningTime = runningTime;
        this.country = country;
        this.language = language;
    }

        
    

    public String getTilte() {
        return title;
    }

    public void setTilte(String tilte) {
        this.title = tilte;
    }

    public String[] getStarring() {
        return starring;
    }

    public void setStarring(String[] starring) {
        this.starring = starring;
    }

  

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", starring=" + Arrays.toString(starring) + ", runningTime=" + runningTime + ", country=" + country + ", language=" + language + '}';
    }

 

        @Override
    public int compareTo(Movie o) {
     
    if(this.runningTime==o.runningTime)  
        return 0;  
    else if (this.runningTime>o.runningTime)  
        return 1;  
return -1;

       }
    public Object clone() throws CloneNotSupportedException {
        return  super.clone();
}

   
    

}

