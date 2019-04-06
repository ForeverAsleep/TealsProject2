// Update this file with your own code

public class Spreadsheet implements Grid {

    private Cell[][] spreadsheet;
    private String spreadsheetString;

    public static final int rows = 20;
    public static final int columns = 12;

    public static void main(String[] args) { //for testing methods
        Spreadsheet hi = new Spreadsheet();
        System.out.println(hi.getDigits("a3 = 123.43%"));
        System.out.println(hi.processCommand("d18 = 3.14"));
        System.out.println(hi.getGridText());
    }

    //constructor
    public Spreadsheet() {
        constructClearSpreadsheet();
    }

    public void constructClearSpreadsheet() {
        this.spreadsheet = new Cell[rows][columns]; //initializes array

        for (int rowBuilding = 0; rowBuilding < rows; rowBuilding++) { //constructs an array of empty cells

            for (int columnBuilding = 0; columnBuilding < 12; columnBuilding++) {
                this.spreadsheet[rowBuilding][columnBuilding] = new EmptyCell();
            }
        }

        constructSpreadsheetString();
    }

    public void constructSpreadsheetString() { //for initializing spreadsheet String
        this.spreadsheetString = "   |";
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

        for (int colums = 0; colums < 12; colums++) {
            this.spreadsheetString = this.spreadsheetString + letters[colums] + "         |";
        }

        for (int rows = 1; rows <= 20; rows++) {

            if (rows < 10) {
                this.spreadsheetString += "\n" + rows + "  |";

            } else {
                this.spreadsheetString += "\n" + rows + " |";
            }

            for (int rowsCols = 0; rowsCols < 12; rowsCols++){
                this.spreadsheetString += this.spreadsheet[rows - 1][rowsCols].abbreviatedCellText() + "|";
            }
        }

        this.spreadsheetString += "\n";
    }

    @Override
    public String processCommand(String command) { //processes commands
        String valueReturned = "";

        if (command.indexOf('=') >= 0) { //calls assigningString()

            if (command.contains("\"")) {
                assigningString(command);

            } else if (command.contains("%")){
                assigningPercentage(command);

            } else if (command.contains("(")) {
                assigningFormula(command);

            } else {
                assigningValue(command);

            }

            valueReturned = getGridText();

        } else if (command.toLowerCase().equals("clear")) { //calls clearGrid()
            clearGrid();
            valueReturned = getGridText();

        } else if (command.toLowerCase().contains("clear")) { //calls clearCell()
            clearCell(command);
            valueReturned = getGridText();

        } else if (!command.equals("")) { //calls cellInspection()     | checks for empty String
            valueReturned = cellInspection(command);

        }

        return valueReturned;
    }

    public boolean hasDigits(String input) { //returns true if a digit if found within a string, otherwise returns false
        boolean digetFound = false;
        input = input.substring(2, input.length());
        char[] chars = input.toCharArray();

        for (char c: chars) {
            if (Character.isDigit(c)) {
                digetFound = true;
            }
        }

        return digetFound;
    }

    public String getDigits(String input) { //returns the String containing the digits within a string
        if (input.contains("%")) {
            input = input.substring(input.indexOf("=") + 2, input.length() - 1);
        } else {
            input = input.substring(input.indexOf("=") + 2, input.length());
        }

        return input;
    }

    //Methods for specific commands
    public String cellInspection(String command) { //returns a cell's fullCellText
        SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, command.length()));
        return spreadsheet[loc.getRow()][loc.getCol()].fullCellText();

    }

    public void assigningString(String command) { //Sets a cell at the specified location to a textCell containing the string the user inputs
        SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, (command.indexOf("=") - 1)));

        this.spreadsheet[loc.getRow()][loc.getCol()] = null;
        this.spreadsheet[loc.getRow()][loc.getCol()] = new TextCell(command.substring(command.indexOf("=") + 2, command.length()));

        constructSpreadsheetString();
    }

    public void assigningValue(String command) {
        SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, (command.indexOf("=") - 1)));

        this.spreadsheet[loc.getRow()][loc.getCol()] = null;
        this.spreadsheet[loc.getRow()][loc.getCol()] = new ValueCell(getDigits(command));

        constructSpreadsheetString();
    }

    public void assigningPercentage(String command) {
        SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, (command.indexOf("=") - 1)));

        this.spreadsheet[loc.getRow()][loc.getCol()] = null;
        this.spreadsheet[loc.getRow()][loc.getCol()] = new PercentCell(getDigits(command));

        constructSpreadsheetString();
    }

    public void assigningFormula(String command) {
        SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, (command.indexOf("=") - 1)));

        this.spreadsheet[loc.getRow()][loc.getCol()] = null;
        this.spreadsheet[loc.getRow()][loc.getCol()] = new FormulaCell(command);

        constructSpreadsheetString();
    }

    public void clearGrid() { //creates a new clear grid
        constructClearSpreadsheet();
        constructSpreadsheetString();
    }

    public void clearCell(String command) { //replaces a cell at the specified location to an empty one
        SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(6, command.length()));

        this.spreadsheet[loc.getRow()][loc.getCol()] = null;
        this.spreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();

        constructSpreadsheetString();
    }

    //Override methods
    @Override
    public int getRows() { //returns the number of rows
        // TODO Auto-generated method stub
        return this.spreadsheet.length;
    }

    @Override
    public int getCols() { //returns the length of a row
        // TODO Auto-generated method stub
        return this.spreadsheet[0].length;
    }

    @Override
    public Cell getCell(Location loc) { //returns a cell at loc
        // TODO Auto-generated method stub
        return spreadsheet[loc.getRow()][loc.getCol()];
    }

    @Override
    public String getGridText() { //returns spreadsheetString
        // TODO Auto-generated method stub
        return spreadsheetString;
    }
}