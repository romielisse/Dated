import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //Get the current time
        LocalDateTime rightNow= LocalDateTime.now();
        //Date from the user
        LocalDate userDate=null;
        String aDate = "";

        //Set up formatters so that you can use them later
        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter shortMonthFormat_rev = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Output today's date in formats that have been preset
        print("The current date in day, Month (3 letters) and year (4 digit) format: " + rightNow.format(shortMonthFormat));
        print("The current date in Month (3 letters), day  and year (4 digit) format: " + rightNow.format(shortMonthFormat_rev));
        print("The current date in day, month (2 digits) and year format: " + rightNow.format(dTF));

        do {
            print("Enter a date in dd/mm/yyyy format: ");
            aDate = keyboard.nextLine();

        }while(!isValidFormat(dTF,aDate));

        if(isValidFormat(dTF,aDate)){
            // Check if date is on or before today - break
            // Else keep asking for new date

        }

        //This is how you parse a string with a date time formatter
        //String aDate = "22/05/2010";
        //userDate = LocalDate.parse(aDate,dTF);
        //print(userDate.format(longFormat));



        //Display the date entered
        //print(userDate.format(shortMonthFormat));
    }

    protected static Boolean isValidFormat(DateTimeFormatter format, String userDate){
        LocalDate localDate = null;

        try {
            localDate = LocalDate.parse(userDate, format);
            if (!userDate.equals(localDate.toString())) { //does not compare correctly
                localDate = null;
            }
        }
        catch (DateTimeParseException ex) {
        }

        if (localDate == null) {
            return false;
        }
        else {
            return true;
        }
    }

    protected static void print(String message){
        System.out.println(message);
    }
}