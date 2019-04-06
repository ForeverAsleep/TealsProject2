import java.util.Scanner;

public class TextExcel {

    public static void main(String[] args) {

        boolean running = true; //to stop program if needed

        //initializing objects
        Spreadsheet spreadsheet = new Spreadsheet();
        Scanner input = new Scanner(System.in);

        System.out.println(spreadsheet.getGridText());

        while (running) { //main loop

            System.out.println("\nenter a command");
            String str = input.nextLine();

            if (str.toLowerCase().equals("quit")) { //if user desires to exit program
                running = false;
                break;

            } else {
                System.out.println(spreadsheet.processCommand(str));
            }
        }
    }
}