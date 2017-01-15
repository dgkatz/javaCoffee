package com.strattondesign.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "Total: $" + (quantity * 5);
        priceMessage += "\nThankyou!";
        displayMessage(priceMessage);

        int price = calculatePrice();

        String orderSummary = createOrderSummary(price);

        displayMessage(orderSummary);
    }
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    public void decrement(View view) {
        if (quantity != 0){
            quantity = quantity - 1;
        }
        display(quantity);
    }

    private String createOrderSummary(int price){
        String orderSummary = "Name: Dan Katz\n";
        orderSummary += "Quantity: ";
        orderSummary += quantity;
        orderSummary += "\nTotal: ";
        orderSummary += "$" + price;
        orderSummary += "\nThank you!";
        return orderSummary;
    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayMessage(String priceSummary) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(priceSummary);
    }
}