public class FormulaCell extends RealCell {

    private String formulaExpression;

    //constructor
    public FormulaCell(String expression) {
        this.formulaExpression = expression.substring(expression.indexOf("=") + 2, expression.length());
    }

    @Override
    public String abbreviatedCellText() { //for now returns formula to show a formula in a cell
        return "formula   ";
    }

    @Override
    public String fullCellText() {
        String expressionOfFormula = formulaExpression;

        if (expressionOfFormula.length() >= CELLWIDTH) {

            return expressionOfFormula.substring(0,CELLWIDTH);

        } else {

            while (expressionOfFormula.length() != CELLWIDTH) {

                expressionOfFormula += " ";

            }

            return  expressionOfFormula;
        }
    }
}
