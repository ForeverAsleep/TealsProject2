public class RealCell implements Cell {

    private double value;

    //constructors
    public RealCell() {} //default for formulaCell

    public RealCell(String setValue) { //for Value and Percent Cells
        this.value = Double.parseDouble(setValue);
    }

    //accessor
    public void setvalue(double newValue) {
        this.value = newValue;
    }

    //mutator
    public double getDoubleValue() {
        return this.value;
    }

    public String getTruncatedValue() { //returns a 10 character String containing the truncated value
        String truncatedValueString = "" + this.value;

        if (truncatedValueString.length() >= 10) {

            return truncatedValueString.substring(0, 10);

        } else {

            while (truncatedValueString.length() != 10) {
                truncatedValueString += " ";
            }

            return truncatedValueString;
        }


    }

    @Override
    public String abbreviatedCellText() {
        return null;
    }

    @Override
    public String fullCellText() {
        return null;
    }
}
