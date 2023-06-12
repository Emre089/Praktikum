import java.util.Scanner;

public class ChatCheapyT{


  /**
   *  if (input.isBlank())
   *  return "Dann sage ich aber auch nichts!";
   *
   * @param input
   * @return
   */
  private static String handleSilence(String input){
    if (input.isBlank())
      return "Dann sage ich aber auch nichts!";
    else
      return null;
  }

  /**
   * // Methode: handleTooLong
   *     //Bedingung: Anzahl der Zeichen größer als 50
   * @param input
   * @return
   */
  private static String handleTooLong(String input){

    if(input.length() > 50 ){
      throw new IllegalArgumentException("Das ist mir zuviel zu lesen! Bitte kürzen Sie Ihre Anfrage!");
    }
    return null;
  }

  /**
   * // Methode: handleExam
   * @param input
   * @return
   */
  private static String handleExam(String input){
    if(input.equalsIgnoreCase("Was kommt in der Klausur dran?")){
      return "Die Klausur orientiert sich an den Praktika!";
    }
    return null;

  }

  /**
   *  // Methode: handleQuestion
   *     //Bedingung: Eingabe endet mit einem Fragezeichen
   * @param input
   * @return
   */
  private static String handleQuestion(String input){
    if(input.endsWith("?")) {
    return "Tut mir leid, aber die ChatCheapyT-Server sind gerade ausgelastet! Schließen Sie bitte ein ChatCheapyT-Pro-Abo ab!";
    }
    return null;
  }

  /**
   * handleExclamation
   * @param input
   * //Methode: handleExclamation
   * //Bedingung: Eingabe beinhaltet mindestens ein Ausrufezeichen
   * @return
   */
  private static String handleExclamation(String input){

    if(input.toLowerCase().contains("bitte")){
    return  "Wie ist das Zauberwort?";
      }
    return null;
  }

  /**
   * Methode: handleChatGPT
   * Bedingung: Eingabe beinhaltet mindestens einmal genau das Wort "ChatGPT"
   * @param input
   * @ return Ausgabe: Alle Vorkommen von "ChatGPT" werden durch "ChatCheapyT" ersetzt und das Ergebnis
   */
  private static String handleChatGPT(String input) {
    String guterGPT = "ChatCheapyT";
    String boeserGPT = "ChatGPT";

    if (input.toLowerCase().contains(boeserGPT)) {
      input = input.replace(boeserGPT, guterGPT);
      return input;
    }
    return null;
  }


  private static String handleScream(String input){
  int upperCaseCount = 0;

  for(int i = 0; i < input.length(); i++) {
    if (Character.isUpperCase(input.charAt(i))) {
      upperCaseCount++;
    }
  }
  if (upperCaseCount >= input.length() / 2) {
      return "Bitte schreien Sie mich nicht an!";
    }
    return null;
  }

  /**
   * Bedingung: Die Eingabe beginnt mit "Umdrehen:" (Groß-/Kleinschreibung werden ignoriert)
   * Ausgabe: Die Ausgabe sind die Zeichen nach dem Doppelpunkt der Eingabe in umgekehrter
   * @param input
   * @return
   */
  private static String handleReverse(String input) {

    if (input.toLowerCase().startsWith("umdrehen:")) {
      String reverso = input.substring(input.indexOf(":") + 1);
      StringBuffer buffer = new StringBuffer(reverso);
      return buffer.reverse().toString();
    }
    return null;
  }

  /**
   * Beginnt die Eingabe
   * mit Addiere (Groß-/Kleinschreibung ignoriert), dann werden die beiden darauf folgenden double
   * @param input
   * @return
   */

  private static String handleAdd(String input){
    // Wenn Stichwort Addiere, dann addiere 2 double Werte und gebe Sie in einem Format aus.
    // 1. Uberpruefe Wort "Addiere" , Arithmetik, Ausgabe

    if(input.toLowerCase().startsWith("addiere")){
      try {
      String[] parts = input.split(" ");
      double num1 = Double.parseDouble(parts[1]);
      double num2 = Double.parseDouble(parts[2]);
      double result = num1 + num2;
      return String.format("%.6f plus %.6f ist gleich %.6f! Take that, ChatGPT!", num1, num2, result);

    } catch(Exception e){
        return "Fehler: Eingabe ist ungueltig.";
      }
    }
    return null;
  }

  private static String handleMultiplication(String input) {
    if (input.toLowerCase().startsWith("multipliziere")) {
      try {
        String[] parts = input.split(" ");
        double num1 = Double.parseDouble(parts[1]);
        double num2 = Double.parseDouble(parts[2]);
        double result = num1 * num2;
        return String.format("%.6f mal %.6f ist gleich %.6f! Take that, ChatGPT!", num1, num2, result);
      } catch (Exception e) {
        return "Fehler: Die Eingabe ist ungültig.";
      }
    }
    return null;
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    String prompt = null;

    do {

      System.out.print("Prompt: ");
      prompt = input.nextLine(); 

      String answer = handleSilence(prompt);

      if (answer == null)
        answer = handleTooLong(prompt);

      if (answer == null)
        answer = handleExam(prompt);

      if (answer == null)
        answer = handleQuestion(prompt);

      if (answer == null)
        answer = handleExclamation(prompt);

      if (answer == null)
        answer = handleScream(prompt);

      if (answer == null)
        answer = handleReverse(prompt);

      if (answer == null)
        answer = handleAdd(prompt);

      if (answer == null)
        answer = handleChatGPT(prompt);

      if (prompt.equalsIgnoreCase("bye"))
        continue;

      if (answer != null)        
        System.out.println("ChatCheapyT: " + answer);
      else
        System.out.println("ChatCheapyT: Ich verstehe Sie leider nicht!");


    } while (!prompt.equalsIgnoreCase("bye"));

    System.out.println("Bye!");

    input.close();
    
  }





}
