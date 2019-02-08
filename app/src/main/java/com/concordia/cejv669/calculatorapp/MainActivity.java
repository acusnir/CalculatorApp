package com.concordia.cejv669.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button b = findViewById(R.id.button);

        registerForContextMenu(b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.editText);
                EditText num2 = findViewById(R.id.editText2);
                TextView tv = findViewById(R.id.textView);

                double n1 = Double.valueOf(num1.getText().toString());
                double n2 = Double.valueOf(num2.getText().toString());

                if(b.getText().toString().equals("Add")){
                    tv.setText(String.valueOf(n1 + n2));
                }else{
                    tv.setText(String.valueOf(n1 * n2));
                }

            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.button){
            menu.setHeaderTitle("Choose Fonction");
            menu.add(0, v.getId(), 0, "Add");
            menu.add(1, v.getId(), 0, "Multiply");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
// use an enum
        if (item.getItemId() == R.id.button) {
            if (item.getGroupId() ==0){

                Toast.makeText(this, "You selected Add", Toast.LENGTH_LONG).show();
                Button b = findViewById(R.id.button);
                b.setText(item.getTitle());
            }
            if (item.getGroupId() ==1){
                Toast.makeText(this, "You selected Multiply", Toast.LENGTH_LONG).show();
                Button b = findViewById(R.id.button);
                b.setText(item.getTitle());
            }

        }

        return true;
    }
}
