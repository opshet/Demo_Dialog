package sg.edu.rp.c346.id20010021.demo_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button buttonDemo1;
    Button buttonDemo2;
    Button buttonDemo3;
    Button buttonEx3;
    Button buttonDemo4;
    Button buttonDemo5;

    TextView textViewd2;
    TextView textViewd3;
    TextView textViewEx3;
    TextView textView4;
    TextView textView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDemo1 = findViewById(R.id.buttonDemo1);
        buttonDemo2= findViewById(R.id.buttonDemo2);
        buttonDemo3= findViewById(R.id.buttonDemo3);
        buttonEx3= findViewById(R.id.buttonEx3);
        buttonDemo4= findViewById(R.id.buttonDemo4);
        buttonDemo5= findViewById(R.id.buttonDemo5);

        textViewd3= findViewById(R.id.textViewd3);
        textViewEx3= findViewById(R.id.textViewEx3);
        textView4= findViewById(R.id.textView4);
        textView5= findViewById(R.id.textView5);


        buttonDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

//                myBuilder.setTitle("Demo 1-Simple Dialog");
//                myBuilder.setMessage("I can develop Android App");
//                myBuilder.setCancelable(true);
//                myBuilder.setPositiveButton("Close", null);

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });


        buttonDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select One of the Buttons Below.");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textViewd2.setText("You have selected Positive");
                    }

                });
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textViewd2.setText("You have selected Negative");
                    }
                });


                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        buttonDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        textViewd3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        buttonEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.ex3, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText num1 = viewDialog.findViewById(R.id.etNum1);
                final EditText num2 = viewDialog.findViewById(R.id.etNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Excercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user

                        String n1= num1.getText().toString();
                        String n2= num2.getText().toString();
                        int int1=Integer.parseInt(n1);
                        int int2=Integer.parseInt(n2);
                        int int3= int1+int2;

                        // Set the text to the TextView
                        textViewEx3.setText("The sum is "+int3);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        buttonDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                DatePickerDialog.OnDateSetListener myDateListener= new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        textView4.setText("Date: "+dayOfMonth+ "/"+ (monthOfYear+1)+ "/"+year);
//                    }
//                };
//
//                DatePickerDialog myDateDialog=new DatePickerDialog(MainActivity.this,
//                        myDateListener, 2014, 11, 31);
//                myDateDialog.show();



                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textView4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog to show the current date when it first appears
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);

                myDateDialog.show();

            }
        });

        buttonDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int mintue) {
                        textView5.setText("Time: " + hourOfDay + ":" + mintue);
                    }
                };

//                TimePickerDialog myTimeDialog= new TimePickerDialog(MainActivity.this,
//                        myTimeListener, 20, 00, true);
//
//                myTimeDialog.show();

//                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
//                        myTimeListener, 20, 00, false);
//                myTimeDialog.show();

                // Create the Date Picker Dialog to show the current date when it first appears
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hourOfDay, minute, true);



            }
        });




    }
}