package com.example.diary_application;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {
   private EditText edtDate,edtSubject,edtMatter;
   private Button btnSave,btnSubmit,btnCancel;
   private ListView lv;
   private DatePicker datePicker;

   private ArrayList<Diary> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        edtDate=findViewById(R.id.edt_calendar);
        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=getLayoutInflater();
                View view=inflater.inflate(R.layout.dialog_layout,null);

                final Dialog dialog=new Dialog(SecondActivity.this);
                dialog.setContentView(view);
                datePicker=view.findViewById(R.id.date_picker);
                btnSubmit=view.findViewById(R.id.btn_submit);
                btnCancel=view.findViewById(R.id.btn_cancel);
                dialog.show();

                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String date=datePicker.getDayOfMonth()+"/"+(datePicker.getMonth()+1)+"/"+datePicker.getYear();
                        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date t=new SimpleDateFormat("dd/MM/yyyy").parse(date);
                            //SimpleDateFormat ft=new SimpleDateFormat("EEEE, MMMM d, yyyy");
                            edtDate.setText(new SimpleDateFormat("EEEE, MMMM d, yyyy").format(t));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        dialog.dismiss();
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
        edtSubject=findViewById(R.id.edt_subject);
        edtMatter=findViewById(R.id.edt_matter);

        btnSave=findViewById(R.id.btn_save);

        lv=findViewById(R.id.lv);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date=edtDate.getText().toString();
                String subject=edtSubject.getText().toString();
                String matter=edtMatter.getText().toString();

                Diary diary=new Diary(date,subject,matter);

                if(date.equals("")||subject.equals("")||matter.equals(""))
                {
                    edtDate.setError("Please insert date");
                    edtSubject.setError("Please insert subject");
                    edtMatter.setError("Please insert matter");

                }
                else
                {
                    arrayList.add(diary);
                    Collections.reverse(arrayList);
                    MyAdapter myAdapter=new MyAdapter(SecondActivity.this,arrayList);

                    lv.setAdapter(myAdapter);
                    edtDate.setText("");
                    edtSubject.setText("");
                    edtMatter.setText("");
                }
            }
        });
    }
}
