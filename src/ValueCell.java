public class ValueCell extends RealCell {

    //constructor
    public ValueCell(String setValue) {
        super(setValue);
    }

    @Override
    public String abbreviatedCellText() { //returns a 10 character string containing the truncated value
        return super.getTruncatedValue();
    }

    @Override
    public String fullCellText() { //returns a String of the entire value
        return "" + super.getDoubleValue();
    }
}
