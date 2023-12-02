package CurrencyConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, Double> currencyRates = new HashMap<>();
    static {
        currencyRates.put("USD", 1.0);
        currencyRates.put("EUR", 0.91);
        currencyRates.put("GBP", 0.79);
        currencyRates.put("INR", 83.36);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        displayCurrencyOptions();
    }

    /**
     * 
     */
    private static void displayCurrencyOptions() {
        System.out.println("Available currencies:");
        for (String currencyCode : currencyRates.keySet()) {
            System.out.println(currencyCode);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the source currency code: ");
            String sourceCurrency = scanner.nextLine().toUpperCase();

            if (!isValidCurrencyCode(sourceCurrency)) {
                System.out.println("Invalid currency code");
                return;
            }

            System.out.print("Enter the amount to convert: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the target currency code: ");
            String targetCurrency = scanner.next().toUpperCase();

            if (!isValidCurrencyCode(targetCurrency)) {
                System.out.println("Invalid target currency code.");
                return;
            }

            extracted2(sourceCurrency, amount, targetCurrency);
        }
    }

    private static void extracted2(String sourceCurrency, double amount, String targetCurrency) {
        extracted(sourceCurrency, amount, targetCurrency);
    }

    private static void extracted(String sourceCurrency, double amount, String targetCurrency) {
        convertCurrency(sourceCurrency, amount, targetCurrency);
    }

    /**
     * @param sourceCurrency
     * @param amount
     * @param targetCurrency
     */
    private static void convertCurrency(String sourceCurrency, double amount, String targetCurrency) {
        double Base_Rate = currencyRates.get(sourceCurrency);
        double Target_Rate = currencyRates.get(targetCurrency);
        double convertedAmount = (amount / Base_Rate) * Target_Rate;

        System.out.printf("%.2f %s is equal to %.2f %s\n", amount, sourceCurrency, convertedAmount, targetCurrency);
    }

    private static boolean isValidCurrencyCode(String currencyCode) {
        return currencyRates.containsKey(currencyCode);
    }
}
