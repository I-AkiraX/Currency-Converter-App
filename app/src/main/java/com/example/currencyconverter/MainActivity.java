package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText rs = (EditText) findViewById(R.id.editTextRupee);
        Button cal = (Button) findViewById(R.id.button);
        Button rev = (Button) findViewById(R.id.button2);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rss = rs.getText().toString();
                if(rss.equals("")){
                    Toast.makeText(getApplicationContext(),"Empty field!",Toast.LENGTH_LONG).show();
                }
                else{
                    TextView inr = (TextView) findViewById(R.id.textView);
                    double rsd = Double.parseDouble(rss);
                    if(inr.getText().toString().equals("Enter the amount in Rupees:")){
                        final CharSequence rsss = rsd/73.76+"$";
                        Toast.makeText(getApplicationContext(),rsss,Toast.LENGTH_LONG).show();
                    }
                    else{
                        final CharSequence usds = rsd*73.76+"inr";
                        Toast.makeText(getApplicationContext(),usds,Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView inr = (TextView) findViewById(R.id.textView);
                ImageView img = (ImageView) findViewById(R.id.imageView);
                if(inr.getText().toString().equals("Enter the amount in Rupees:")){
                    inr.setText("Enter the amount in Dollars:");
                    rs.setHint("Dollars...");
                    img.setImageResource(R.drawable.inr);

                }
                else{
                    inr.setText("Enter the amount in Rupees:");
                    rs.setHint("Rupees...");
                    img.setImageResource(R.drawable.dollar);
                }
            }
        });
    }
}