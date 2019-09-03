package com.example.student.lab05;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txt_id,txt_name,txt_address,txt_conNo;
    Button btnSave,btnShow,btnUpdate,btnDelete;
    Student  student;
    DatabaseReference dbRef;

    @SuppressLint({"CutPasteId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_id = findViewById(R.id.txt_id);
        txt_name = findViewById(R.id.txt_name);
        txt_address=findViewById(R.id.txt_address);
        txt_conNo = findViewById(R.id.txt_conNo);

        btnSave =findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        student = new Student();
        
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dbRef = FirebaseDatabase.getInstance().getReference().child("Student");

                student.setId(txt_id.getText().toString().trim());
                student.setName(txt_name.getText().toString().trim());
                student.setAddress(txt_address.getText().toString().trim());
                student.contactNo(Integer.parseInt(txt_conNo.getText().toString().trim()));

                dbRef.push().setValue(student);

                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
            }
        });
    }
        public void clearData(){

        txt_id.setText("");
        txt_name.setText("");
        txt_address.setText("");
        txt_conNo.setText("");

        }
}
