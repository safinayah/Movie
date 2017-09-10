/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ayah
 */
public class Movie2 extends Application {
            private int currentIndex = 0 ;
            Button next = new Button("Next");
            Button prev = new Button("Prev");
                      String line ;
            String [] tokens ;
            String [] temp ;
            String [] temp2 ;
            String[] params ;
            String[] params2;
            String[] starring ;
            Button displayMoviesBtn = new Button("");
            Label runTime= new Label();
            Label title2= new Label();
            Label city2= new Label();
            Label lang = new Label(); 
            Label data = new Label();
            
           
           
            ArrayList<Movie> info = new ArrayList<>();// we created this array list to save the strings ad be able to modify on it
            ToggleGroup group = new ToggleGroup(); 
            RadioButton rb1 = new RadioButton("sort on running time");
            RadioButton rb2 = new RadioButton("sort on title");
                 int runningTime;
                 String title;
                 String city;
                 String language;
                 StringBuilder test = new StringBuilder(); 
                
    @Override
public void start(Stage primaryStage) {
       
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 400);
        //root.setStyle("-fx-background-color: GRAY; -fx-padding: 10;");                     
       root.setStyle("-fx-background-image: url(aaaa.jpg); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");


       
       
        Text scenetitle = new Text("Welcome To Movies library");
        //scenetitle.setFill(WHITE);
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 50));
        root.setTop(scenetitle);
        
         //Display movies on runningTime or type button      
       
        displayMoviesBtn.setText("Display all Movies");
        HBox hb  = new HBox(); 
        root.setCenter(displayMoviesBtn);
        VBox vb = new VBox(); 
        vb.getChildren().addAll(rb1,rb2); 
         VBox vb2 = new VBox(data,lang); 
         
        root.setLeft(vb);
        root.setRight(vb2);
        hb.getChildren().addAll(next,prev);
        root.setBottom(hb);
        next.setOnAction(e -> nextLabel(info));
        prev.setOnAction(e -> prevLabel(info));
        displayMoviesBtn.setOnAction(e -> loadData(info));
        rb1.setOnAction(e -> sort() );
        primaryStage.setTitle("Display Movie");
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        
      
        
    }
    
    public static void main(String[] args) throws FileNotFoundException{
      Application.launch(args);
         }           

    private void loadData(ArrayList<Movie> info) {
         File x = new File("movies.txt"); //This is used to input the movies text
         StringBuilder test = new StringBuilder();
        if (x.exists()) {
             try {
                 //System.out.print("Helloooooooooo");
                 Scanner input = new Scanner(x);// Scanning
                 input.nextLine();
                               while (input.hasNext()) {
                     //System.out.println("I CAN SEE THE FILE");
                     line = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                     tokens = line.split(":");
                     temp = tokens[1].split("\\[");
                     temp2 = temp[1].split("\\]");
                     params = temp[0].split(",");
                     params2= temp2[1].split(",");
                     starring = temp2[0].split(",");
                    runningTime= Integer.parseInt(params2[1].trim());
                    title= params[0].trim(); 
                    city = params2[2].trim();
                   language =  params2[3].trim(); 
                test.append("Type is "+tokens[0]+"\n"+"Movie title is "+title+"\n"+ "running time is"+ runningTime+"\n\n"); 
               //lang.setText("Press next to view movies one by one"); 
                //land\g.setStyle("-fx-border-color: black;");
                System.out.print("Movie title is "+title+"\n"+ "running time"+ runningTime); 
                 
                
                     if(tokens[0].equalsIgnoreCase("Romance")){
                         info.add(new Romance(params[0].trim(),starring, Integer.parseInt(params2[1].trim()), params2[2].trim(), params2[3].trim()));
                       
                     }
                     
                     if(tokens[0].equalsIgnoreCase("Comedy")){
                         info.add(new Comedy(params[0].trim(),starring, parseInt(params2[1].trim()), params2[2].trim(), params2[3].trim()));
                     }
                     
                     if(tokens[0].equalsIgnoreCase("Rescue")){
                         info.add(new Rescue(params[0].trim(),starring, parseInt(params2[1].trim()), params2[2].trim(), params2[3].trim()));
                     }
                     
                     if(tokens[0].equalsIgnoreCase("Mystery")){
                         info.add(new Mystery(params[0].trim(),starring, parseInt(params2[1].trim()), params2[2].trim(), params2[3].trim()));
                     } 
                     
                     if(tokens[0].equalsIgnoreCase("Hollywood")){
                         info.add(new Hollywood(params[0].trim(),starring, parseInt(params2[1].trim()), params2[2].trim(), params2[3].trim()));
                     }
                     
                
                    
                 }} catch (FileNotFoundException ex) {
                 System.out.println("File not found");
             }
             data.setText(test.toString());
             data.setStyle("-fx-border-color: black;");
         
        }
        
     
            
          }

    
        private void nextLabel(ArrayList<Movie> info) {
           

        if(currentIndex< info.size()){
        currentIndex = (currentIndex+1);
        Movie temp = info.get(currentIndex);
       data.setText("Running Time is "+ temp.getRunningTime() + "\n"+ "title is"+temp.getTilte());
       data.setStyle("-fx-border-color: black;");
         
      
    }
       }

    private void prevLabel(ArrayList<Movie> info) {
        
      currentIndex = (currentIndex-1);
     // currentIndex = (currentIndex+1);
      Movie temp = info.get(currentIndex);
      data.setText("Running Time is "+ temp.getRunningTime() + "\n"+ "title is"+temp.getTilte());
      data.setStyle("-fx-border-color: black;");
         
    }

    private void sort() {
         Collections.sort(info); // This is to sort them
       }

  
}