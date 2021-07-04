package com.example.currencyconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.currencyconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final EditText rs = binding.enterAmount;
        Button cal = binding.calculate;
        Button rev = binding.reverse;
        TextView result = binding.result;
        final String usdresult = "USD: ";
        final String inrresult = "INR: ";

        cal.setOnClickListener(view -> {
            String rss = rs.getText().toString();
            if(rss.equals("")){
                Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_LONG).show();
            }
            else{
                TextView enterText = binding.enterText;
                double rsd = Double.parseDouble(rss);
                if(enterText.getText().toString().equals("Enter the amount in Rupees:")){
                    final String rsss = rsd/73.76+"$";
                    //Toast.makeText(getApplicationContext(),rsss,Toast.LENGTH_LONG).show();
                    result.setText(String.format("%s%s", usdresult, rsss));
                }
                else{
                    final String usds = rsd*73.76+"₹";
                    //Toast.makeText(getApplicationContext(),usds,Toast.LENGTH_LONG).show();
                    result.setText(String.format("%s%s", inrresult, usds));
                }
            }
        });
        rev.setOnClickListener(view -> {
            result.setText("");
            TextView enterText = binding.enterText;
            ImageView img = binding.imageView;
            if(enterText.getText().toString().equals("Enter the amount in Rupees:")){
                enterText.setText(R.string.enter_dollar);
                rs.setHint("Dollars...");
                img.setImageResource(R.drawable.inr);

            }
            else{
                enterText.setText(R.string.enter_rupee);
                rs.setHint("Rupees...");
                img.setImageResource(R.drawable.dollar);
            }
        });
    }
}