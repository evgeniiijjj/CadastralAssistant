public class Deal {
    private final int length;
    private final int width;
    private final int dealWorth;
    private boolean honesty;

    public Deal(int length, int width, int dealWorth) {
        this.length = length;
        this.width = width;
        this.dealWorth = dealWorth;
    }

    public int getSquare() {
        return length * width;
    }

    public int getDealWorth() {
        return dealWorth;
    }

    public boolean isHonesty() {
        return honesty;
    }

    public void setHonesty(boolean honesty) {
        this.honesty = honesty;
    }

    @Override
    public String toString() {
        return "Земельный участок"
                + " длиной " + length + " м.,"
                + " шириной " + width + " м.,"
                + " продан по цене " + dealWorth + " р."
                + " - Сделка " + (honesty ? " честная." : " нечестная.");
    }
}
