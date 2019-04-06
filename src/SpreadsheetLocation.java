// Update this file with your own code

public class SpreadsheetLocation implements Location {

    private String cellLocation;
    private int row;
    private int column;

    //constructor
    public SpreadsheetLocation(String cellName) {
        this.cellLocation = cellName;
        setRow();
        setCol();
    }

    public void setRow() { //initializes row
        this.row = Integer.parseInt(this.cellLocation.substring(1, this.cellLocation.length())) - 1;
    }

    public void setCol() { //initializes column
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"}; //array of letters to check row number
        String rowLocation = this.cellLocation.substring(0, 1);
        int location_n = -1;

        for (int letter = 0; letter < 12; letter++) { //checks which letter is upfront and returns the number value of the row
            if ((rowLocation.toUpperCase()).equals(letters[letter])) {
                location_n = letter;
            }
        }

        this.column = location_n;
    }

    @Override
    public int getRow() { //returns row
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol() { //returns column
        // TODO Auto-generated method stub
        return column;
    }

}
