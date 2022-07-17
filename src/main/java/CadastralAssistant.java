public class CadastralAssistant {

    public boolean checkDeal(int pricePerSquareMeter, int dealWorth, int square) {
        return dealWorth / square >= pricePerSquareMeter;
    }
}
