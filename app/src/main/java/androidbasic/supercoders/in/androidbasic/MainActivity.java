package androidbasic.supercoders.in.androidbasic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----Declaring Input Element and Finding in Our Layout View----
        final EditText edit_username=(EditText)findViewById(R.id.username);
        final EditText edit_password=(EditText)findViewById(R.id.password);
        final RadioGroup Gender=(RadioGroup) findViewById(R.id.gender);
        final RadioButton Male=(RadioButton) findViewById(R.id.male);
        final RadioButton FeMale=(RadioButton) findViewById(R.id.female);
        final Spinner Ages=(Spinner)findViewById(R.id.age);
        Button Submit=(Button)findViewById(R.id.submit);

        //==========Now Setting Value in Our DropDown Spinner==============
        //======For This We Have To Create A ArrayAdapter with Type String=====
        //===ArrayAdapter is Java Class And its Constructor Takes 3 Param
        //1. Current Class Context,2. Our Textview Layout ,3. Our List of Items in string.


        //====First Create a List of Item for age  ==

        List<String > list=new ArrayList<>();
        for(int i=10;i<50;i++){
            list.add(String.valueOf(i));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,list);

        //====Now Set the Adapter To Spinner by Using SetAdapter Method

        Ages.setAdapter(arrayAdapter);

        //====Set On Click Listener For Button ===

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //===Now Doing Some Validation====

                //====We Can Get Value of Edit Text By using method gettext==

                if(edit_username.getText().toString().isEmpty()){
                    edit_username.setError("Please Enter Username");
                }
                else if(edit_password.getText().toString().isEmpty()){
                    edit_password.setError("Please Enter Username");
                }
                else if(!Male.isChecked() && !FeMale.isChecked()){

                    //===Toast I Used Here For Small Message Display==
                    Toast.makeText(MainActivity.this, "Please Select Gender", Toast.LENGTH_SHORT).show();
                 }
                 else{
                    Toast.makeText(MainActivity.this, edit_username.getText().toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, edit_password.getText().toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, Ages.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                    RadioButton selectedGender=(RadioButton)findViewById(Gender.getCheckedRadioButtonId());
                    Toast.makeText(MainActivity.this,selectedGender.getText().toString() , Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
