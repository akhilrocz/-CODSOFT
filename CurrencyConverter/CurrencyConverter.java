package CurrencyConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static Map<String, Double> exchangeRates;

    static {
        // Initialize exchange rates (These are fixed for demonstration purposes)
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85); // 1 USD = 0.85 EUR
        exchangeRates.put("GBP", 0.74);   // 1 USD = 0.74 GBP
         exchangeRates.put("INR", 75.0);   // 1 USD = 75 INR
         
        // Add more currencies as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        // Display available currencies
        System.out.println("Available Currencies: USD, EUR, GBP, INR");
        System.out.print("Enter the base currency code: ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();

        // Validate currencies
        if (!isValidCurrency(baseCurrency) || !isValidCurrency(targetCurrency)) {
            System.out.println("Invalid currency codes. Exiting...");
            System.exit(1);
        }

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Validate the amount
        if (amount <= 0) {
            System.out.println("Invalid amount. Exiting...");
            System.exit(1);
        }

        // Perform currency conversion
        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);

        // Display the result
        System.out.printf("%.2f %s is equal to %.2f %s%n",
                amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    private static boolean isValidCurrency(String currencyCode) {
        return exchangeRates.containsKey(currencyCode);
    }

    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        // Conversion formula: targetAmount = (amount / baseRate) * targetRate
        return (amount / baseRate) * targetRate;
    }
}

