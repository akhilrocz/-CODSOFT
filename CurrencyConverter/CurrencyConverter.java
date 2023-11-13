package CurrencyConverter;

import java.util.HashMap; //Implements the Map Interface and stores key-value pairs
import java.util.Map; //Map Interface is collection of key-value pairs
import java.util.Scanner; //Implements Scanner class and takes user input

public class CurrencyConverter {

    private static Map<String, Double> exchangeRates; // private static variable exchange rates

    // Static Intialization block is used to intialize static variables
    static {
        // Initialize exchange rates (These are fixed for demonstration purposes)
        exchangeRates = new HashMap<>(); // HashMap class is used for storing key-value pairs
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.9361);
        exchangeRates.put("GBP", 0.8184);
        exchangeRates.put("INR", 83.31);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
            String currencyCode = entry.getKey();
            double rate = entry.getValue();
            System.out.println(currencyCode + ": " + rate);
        }

        System.out.println("Currency Converter Implementation in java");

        // Display available currencies
        System.out.println("Available Currencies: USD, EUR, GBP, INR");
        System.out.print("Enter the base currency code: ");
        String baseCurrency = sc.next().toUpperCase(); // Converts base currency input to uppercase

        System.out.print("Enter the target currency code: ");
        String targetCurrency = sc.next().toUpperCase(); // converts target currency input to uppercase

        // Checks the user entered currency is valid or not
        if (!isValidCurrency(baseCurrency) || !isValidCurrency(targetCurrency)) {
            System.out.println("Invalid currency codes.");
            System.exit(1); // Indicates It is a Abnormal termination.
            // If the exit method returns 1 and some other positive number that means some
            // exception occured
        }

        System.out.print("Enter the amount to convert: ");
        double amount = sc.nextDouble();

        // Validate the amount
        if (amount <= 0) {
            System.out.println("Invalid amount. Exiting...");
            System.exit(1); // Abnormal termination
        }

        // Perform currency conversion
        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);

        // Display the result
        System.out.printf("%.2f %s is equal to %.2f %s%n",
                amount, baseCurrency, convertedAmount, targetCurrency);

        sc.close(); // Closing scanner class to release the resources
    }

    private static boolean isValidCurrency(String currencyCode) {
        return exchangeRates.containsKey(currencyCode);
    }
    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        // get method is used for retreiving the values associated with the key
        // "baseCurrency,targetCurrency" from the "exchangeRates" Map.
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        // Conversion formula: targetAmount = (amount / baseRate) * targetRate
        return (amount / baseRate) * targetRate; // Coversion formula
    }
}

