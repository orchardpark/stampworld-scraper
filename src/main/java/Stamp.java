public class Stamp {
    private final int number;
    private final String type;
    private final String D;
    private final String color;
    private final String description;
    private final int numStampsIssued;
    private final int mintPrice;
    private final int unusedPrice;
    private final int usedPrice;
    private final int letterPrice;
    private final String currency;

    public Stamp(int number, String type, String D, String color, String description, int numStampsIssued, int mintPrice, int unusedPrice, int usedPrice, int letterPrice, String currency){
        this.number = number;
        this.type = type;
        this.D = D;
        this.color = color;
        this.description = description;
        this.numStampsIssued = numStampsIssued;
        this.mintPrice = mintPrice;
        this.unusedPrice = unusedPrice;
        this.usedPrice = usedPrice;
        this.letterPrice = letterPrice;
        this.currency = currency;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getD() {
        return D;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public int getNumStampsIssued() {
        return numStampsIssued;
    }

    public int getMintPrice() {
        return mintPrice;
    }

    public int getUnusedPrice() {
        return unusedPrice;
    }

    public int getUsedPrice() {
        return usedPrice;
    }

    public int getLetterPrice() {
        return letterPrice;
    }

    public String getCurrency() {
        return currency;
    }
}
