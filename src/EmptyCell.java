public class EmptyCell implements Cell {

    @Override
    public String abbreviatedCellText() { //returns a string of 10 spaces for the purpose of grid construction
        return "          ";
    }

    @Override
    public String fullCellText() { //returns an empty string
        return "";
    }
}
