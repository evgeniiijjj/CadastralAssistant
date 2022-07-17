import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int dealsNum = 10;
    private static final int min = 10;
    private static final int max = 90;
    private static final int minPrice = 500000;
    private static final int maxPrice = 10000000;

    public static void main(String[] args) {
        CadastralAssistant assistant = new CadastralAssistant();

        while (true) {
            try {
                System.out.println("\nВведите цену за квадратный метр или end для завершения");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("end")) break;
                int price = Integer.parseInt(input);
                if (price < 10) throw new NumberFormatException();
                getDeals(dealsNum).stream()
                        .peek(deal -> deal.setHonesty(assistant.checkDeal(price, deal.getDealWorth(), deal.getSquare())))
                        .sorted((deal1, deal2) -> deal1.isHonesty() == deal2.isHonesty() ? deal2.getDealWorth() - deal1.getDealWorth() : deal1.isHonesty() ? -1 : 1)
                        .forEach(System.out::println);
            } catch (NumberFormatException e) {
                System.out.println("Ввод некорректен, повторите ввод");
            }
        }
    }

    public static List<Deal> getDeals(int dealsNum) {
        Random rnd = new Random();
        List<Deal> deals = new ArrayList<>();
        for (int i = 0; i < dealsNum; i++) {
            deals.add(new Deal(min + rnd.nextInt(max), min + rnd.nextInt(max), minPrice + rnd.nextInt(maxPrice)));
        }
        return deals;
    }
}
