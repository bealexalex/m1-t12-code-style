import java.net.URI;
import java.util.Scanner;
import java.io.IOException;

public class CalculateDeposit {
    double calculateSimplePercent(double a, double y, int d) {
        double pay;

        pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount,
                                             double yearRate,
                                             int depositPeriod) {
        return round(amount + amount
                * yearRate * depositPeriod, 2);
    }

    double round(double value
            , int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void mainMethod() {
        int period;
        int action;
        int amount;
        double outDoubleVar;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом," +
                " 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        outDoubleVar = 0;
        if (action == 1) {
            outDoubleVar = calculateSimplePercent(amount,
                    0.06, period);
        } else if (action == 2) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new CalculateDeposit().mainMethod();
    }


}
