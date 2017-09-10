
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ayah
 */
public class PrintCaledar1 {
    
   public static void main(String[] args){
   Scanner input = new Scanner(System.in); 
   System.out.print("Enter a year:  ");
   int iyear = input.nextInt();

     System.out.print("Enter month:  ");
    int  imonth =input.nextInt(); 
    GregorianCalendar today = new GregorianCalendar();

    today.set(Calendar.YEAR,iyear);//GregorianCalender year equlas this year
    
    today.set(Calendar.MONTH,imonth);//GregorianCalender day equlas today
    
    int month = imonth;//GregorianCalender month equals this month 

    int day = today.get(Calendar.DAY_OF_MONTH);

    int year = iyear;
    
    today.set(Calendar.DAY_OF_MONTH, 1);
    
    int firstDay = today.get(Calendar.DAY_OF_WEEK);
    /* Caender.setCalrnder.DA*/
   
    today.set(Calendar.DAY_OF_MONTH, day);
    // Prompt user to enter first day of the year
   System.out.println("");
    int dayCounter = day;
    int noOfDays = 0;
    
  if(month>7&& month%2 !=0){
      noOfDays= 30; //any odd month greater than 7 has 30 days
  }
  else if(month == 2){ 
      if(year%4==0)//leap year 
          noOfDays=29; 
      else 
          noOfDays=28;
  
  }
  else if(month<7 && month%2 ==0){
      noOfDays =30; //any even month less than 7 has 3 day
      }
  else 
      noOfDays = 31;
       if(noOfDays==31){
      System.out.printf("%15s %d  \n", month , year);
                 System.out.println("----------------------------");
                 System.out.println("Fri "+"Sat "+"Sun "+"Mon "+"Tue "+"Wed "+"Thu ");
                 for (int space = 1; space<firstDay-1; space++) 
                 {
                     System.out.print("    ");
                 }
                 dayCounter=firstDay-1;
                 for (int i = 1; i <=noOfDays; i++)
                 {  
                    
                    if (dayCounter>=6 && dayCounter%7==0){
                     System.out.println(i);//print a new line every 7 days
                    }
                    else{
                    System.out.printf("%-4d", i);
                    }
                    dayCounter++;
                    
                 }
                 
                         day = (day + noOfDays)%7;

                         System.out.println();
       }
       else if(noOfDays==30 ){
                 System.out.printf("%15s %d  \n", month , year);
                 System.out.println("----------------------------");
                 System.out.println("Fri "+"Sat "+"Sun "+"Mon "+"Tue "+"Wed "+"Thu ");
                 for (int space = 1; space<firstDay-1; space++) 
                 {
                     System.out.print("    ");
                 }
                 dayCounter =firstDay-1;
                 for (int i = 1; i <=noOfDays; i++)
                 {  
                    
                    if (i%7==0){
                     System.out.println(i);
                    }
                    else{
                    System.out.printf("%-4d", i);
                    }
                    dayCounter++;
                    
                 }
                 
       }
     
    }
   
   
}
    
    

