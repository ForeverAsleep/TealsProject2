public class TextCell implements Cell {

    private String content;

    //constructor
    public TextCell(String text) {
        this.content = text;
    }

    @Override
    public String abbreviatedCellText() { //returns the first 10 characters of content without the quotation marks. if content isn't 10 characters long, adds spaces till it is
        String withoutQuotes = content.substring(1, content.length() - 1);
        int contentLength = withoutQuotes.length();

        if (contentLength < CELLWIDTH) {
            for (int spaces = 0; spaces < CELLWIDTH - contentLength; spaces++) {
                withoutQuotes += " ";
            }

            return withoutQuotes;

        } else {
            return withoutQuotes.substring(0, CELLWIDTH);
        }
    }

    @Override
    public String fullCellText() { //returns content
        return content;
    }
}
