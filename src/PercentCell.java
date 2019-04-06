public class PercentCell extends RealCell {

    //constructor
    public PercentCell(String setValue) {
        super(setValue);
    }

    @Override
    public double getDoubleValue() { //returns the value in decimal form
        return (super.getDoubleValue() / 100);
    }

    @Override
    public String abbreviatedCellText() { //returns a string of length 10 containing value truncated at the decimal point
        String value = "" + super.getDoubleValue();
        value = value.substring(0, value.indexOf('.')) + "%";

        if (value.length() >= CELLWIDTH) {

            return value.substring(0, CELLWIDTH);

        } else {

            while (value.length() != CELLWIDTH) {
                value += " ";
            }

            return value;
        }
    }

    @Override
    public String fullCellText() { //returns the value in percentage form as a String
        return super.getDoubleValue() + "%";
    }
}
