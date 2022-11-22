import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatheQuiz {
  public static void main(String[] args) {
    
    String[] begruessung  = {
    "Gruess Gott",
    "Guten Tag",
    "Guten Morgen",
    "Guten Abend",
    "Willkommen"
    };
    
    int zufallszahl = (int)(Math.random()*begruessung.length);
    
    System.out.print(begruessung[zufallszahl]);
    
    int Punktestand = 0;
    
    // 6 Fragen als Array
    String[] Frage = {
    "Wie viel ergibt 25 % 12?",
    "1. 1",
    "2. 5",
    "3. 4",
    "1"
    };
    
    String[] Frage1 = {
    "Wie viel ergibt 250-79?",
    "1. 161",
    "2. 171",
    "3. 122",
    "2"
    };
    
    String[] Frage2 = {
    "Wie viel ergibt 10*10-25+5?",
    "1. 70",
    "2. 80",
    "3. 75",
    "2"
    };
    
    String[] Frage3 = {
    "Wie viel ergibt 200+520-470?",
    "1. 263",
    "2. 250",
    "3. 260",
    "2"
    };
    
    String[] Frage4 = {
    "Wie viel ergibt 25*300?",
    "1. 5000",
    "2. 7500",
    "3. 9500",
    "2"
    };
    
    String[] Frage5 = {
    "Wie viel ergibt 25*100/50*20-5+78%24?",
    "1. 1001",
    "2. 2523",
    "3. 1649",
    "1"
    };
    
    //Fragen Arrays in eine neues Array speichern
    String Frageliste[][] = {
    Frage,Frage1,Frage2,Frage3,Frage4,Frage5
    };
    
    
    for (int i = 0; i < Frageliste.length; i++) {
      System.out.println(Frageliste[i][0]);
      System.out.println(Frageliste[i][1]);
      System.out.println(Frageliste[i][2]);
      System.out.println(Frageliste[i][3]);
      System.out.println("Bitte die Antwort eingeben: ");
      
      //Einlesen der Antwort
      
      BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
      
      try {
        String antwort = eingabe.readLine();
        System.out.println("Deine Eingabe: " + antwort);
        
        if (antwort.equals(Frageliste[i][4]) {
          System.out.println("Richtige Antwort!\n\n");
          Punktestand++;
        } // end of if
        else {
          System.out.println("Die Antwort ist falsch, lern weiter!\n\n");
        } // end of if-else
      }
      catch (IOException e) {
        System.out.println("Falsche Eingabe!");
      }
      finally {
        System.out.println("Das war gut!");
      }
    }
    System.out.println("Du hast " + Punktestand + " von 3 Fragen richtig.");
    if(punkte==3)
    {
      System.out.println("Du bist gut!");
    }
    else
    {
      System.out.println("Bist ja schlechter als erwartet...");
    }
  } // end of if
}
