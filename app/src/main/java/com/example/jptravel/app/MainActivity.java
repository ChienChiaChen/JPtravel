package com.example.jptravel.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.awt.font.TextAttribute;
import java.math.BigDecimal;


public class MainActivity extends ActionBarActivity {
    public static double Yen=0.2612;
    private Button change;
    private EditText input;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=input.getText().toString();
                double nt=Double.parseDouble(temp);
                nt=nt*Yen;
                double nnt=new BigDecimal(nt).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
                String total=String.valueOf(nnt);
                output.setText("NT "+total);
                input.setText("");

            }
        });
    }

    public void init(){
        change=(Button)findViewById(R.id.change);
        input=(EditText)findViewById(R.id.input);
        output=(TextView)findViewById(R.id.output);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_settings:
                    setDialog();
                return true;

        }


        return super.onOptionsItemSelected(item);
    }
    public  void setDialog(){
        final EditText et=new EditText(this);
        new AlertDialog.Builder(this).setTitle("輸入匯率")
                .setMessage("ex:0.26").setView(et).setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Yen = Double.parseDouble(et.getText().toString());
            }
        });
    }
}
