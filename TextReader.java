/* This class is designed to open and read text documents. In the case of 
 * this project, the document being viewed contains the NBA Top 100 Players
 * and their respective statistics. Given that Java cannot view Excel 
 * spreadsheets without additional plugins such as Apache POI, the data has
 * been converted to a text document under the following formatting.
 * 
 * [PLAYER RANKING]
 * [PLAYER TEAM]
 * [PLAYER FULL NAME]
 * [POINTS PER GAME (PPG)]
 * [REBOUNDS PER GAME (RPG)]
 * [ASSISTS PER GAME (APG)]
 * [FIELD GOAL PERCENTAGE (FGP)]
 * [FREE THROW PERCENTAGE (FTP)]
 * [PLAYER EFFICIENCY RATING (PER)]
 *
 * *Repeated for the NBA Top 100 Players
 *
 * *View Excel formatted data in project folder
 *
 * *All players and statistics are taken from the following websites:
 * **https://www.si.com/nba/top-100-nba-players-2020#20-11
 * **https://www.basketball-reference.com/
*/

import java.io.*;
import java.util.ArrayList;

public class TextReader {
   private String fileName; 
   private String line;
   
   //Default TextReader constructor contains file name of where data is stored
   public TextReader() {
      fileName = "Test.txt";
   }
   
   //Returns the players on a team that are also on the NBA Top 100 list
   public ArrayList getPlayersByTeam(String team) {
      ArrayList ans = new ArrayList();
      try {
         //Java imported reader of text documents
         BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
         
         //Iterate through each line in the text document and find where line equals team name
         while((line = reader.readLine()) != null) {
            if(line.equals(team)) {
               //Adds player to answer array
               ans.add(reader.readLine());
            }
         }
         
         //Closes Java reader to prevent data overflow
         reader.close();
         return ans;
      }
      
      //If error in opening text document catch
      catch (Exception e) {
         System.out.println("ERROR: Cannot open file " + this.fileName);
         return null;
      }
   }
   
   //Returns a player's statistic when specified. If no statistic type is specified, return all player statistics
   public ArrayList getPlayerStat(String player, String statType) {
      ArrayList ans = new ArrayList();
      try {
         //Java imported reader of text documents
         BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
         
         //Iterate through each line in the text document and find where line equals player name
         while((line = reader.readLine()) != null) {
            if(line.equals(player)) {
               switch(statType) {
                  //If statistic type is specified to PPG
                  case "PPG":
                     ans.add(reader.readLine());
                     break;
                  
                  //If statistic type is specified to RPG
                  case "RPG":
                     reader.readLine();
                     ans.add(reader.readLine());
                     break;
                     
                  //If statistic type is specified to APG
                  case "APG":
                     reader.readLine();
                     reader.readLine();
                     ans.add(reader.readLine());
                     break;
                     
                  //If statistic type is specified to FGP
                  case "FGP":
                     reader.readLine();
                     reader.readLine();
                     reader.readLine();
                     ans.add(reader.readLine());
                     break;
                     
                  //If statistic type is specified to FTP
                  case "FTP":
                     reader.readLine();
                     reader.readLine();
                     reader.readLine();
                     reader.readLine();
                     ans.add(reader.readLine());
                     break;
                     
                  //If statistic type is specified to PER
                  case "PER":
                     reader.readLine();
                     reader.readLine();
                     reader.readLine();
                     reader.readLine();
                     reader.readLine();
                     ans.add(reader.readLine());
                     break;
                     
                  //If statistic type is unknown
                  default:
                     for(int i = 0; i <= 5; i++) {
                        ans.add(reader.readLine());
                     }
               }           
            }
         }

         //Closes Java reader to prevent data overflow
         reader.close();
         return ans;
      }
      
      //If error in opening text document catch
      catch (Exception e) {
         System.out.println("ERROR: Cannot open file " + this.fileName);
         return null;
      }   
   }
   
   public static void main(String [] args) {
      TextReader text = new TextReader();
      ArrayList<String> players = text.getPlayersByTeam("Los Angeles Lakers");
      for(String player : players) {
         System.out.println(text.getPlayerStat(player, "PPG"));
         System.out.println(text.getPlayerStat(player, "RPG"));
         System.out.println(text.getPlayerStat(player, "APG"));
         System.out.println(text.getPlayerStat(player, "FGP"));
         System.out.println(text.getPlayerStat(player, "FTP"));
         System.out.println(text.getPlayerStat(player, "PER"));
         System.out.println(text.getPlayerStat(player, ""));
      }
   }
}