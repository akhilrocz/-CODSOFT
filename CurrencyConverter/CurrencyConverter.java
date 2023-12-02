package CurrencyConverter;

import javax.swing.*; //Contains classes for java swing api
import java.awt.*; //containes all of the classes for creating user interfaces
import java.awt.event.ActionEvent; //It is class in AWT package that represents a action event
import java.awt.event.ActionListener; //Listens to particular actions
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap; //datastructure used to store exchange rates
import java.util.Map; //Interface in java that maps keys to values

public class CurrencyConverter {

    private static final Map<String, Double> currencyRates = new HashMap<>(); // variable value never gets changed

    static {
        currencyRates.put("USD", 1.0);
        currencyRates.put("EUR", 0.91);
        currencyRates.put("GBP", 0.79);
        currencyRates.put("INR", 83.36);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> extracted());
    }

    /**
     * 
     */
    private static void extracted() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setPreferredSize(new Dimension(300, 200));
        // Using enhanced for loop for iteration
        for (String currencyCode : currencyRates.keySet()) {
            JButton button = new JButton(currencyCode);
            button.addActionListener(new CurrencyConversionListener(currencyCode));
            button.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    System.out.println("Key Pressed" + KeyEvent.getKeyText(0));
                }
            });
            button.setBounds(100, 150, 100, 30);
            panel.add(button);
        }
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLUE);
    }

    private static class CurrencyConversionListener implements ActionListener {

        private String currencyCode;

        public CurrencyConversionListener(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            double baserate = currencyRates.get(currencyCode);

            String Amount_Input = JOptionPane.showInputDialog("Enter the amount to convert:");
            try {
                double amount = Double.parseDouble(Amount_Input);

                String Target_Currency_Code = JOptionPane.showInputDialog("Enter the target currency code:")
                        .toUpperCase();

                if (!isValidCurrencyCode(Target_Currency_Code)) {
                    JOptionPane.showMessageDialog(null, "Invalid target currency code.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double targetRate = currencyRates.get(Target_Currency_Code);
                double convertedAmount = (amount / baserate) * targetRate;

                JOptionPane.showMessageDialog(null, String.format("%.2f %s is equal to %.2f %s",
                        amount, currencyCode, convertedAmount, Target_Currency_Code), "Conversion Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static boolean isValidCurrencyCode(String currencyCode) {
        return currencyRates.containsKey(currencyCode);
    }
}
