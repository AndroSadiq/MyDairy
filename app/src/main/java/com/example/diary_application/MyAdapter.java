package com.example.diary_application;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class MyAdapter extends BaseAdapter {
    ArrayList<Diary> diaryArrayList;
    Context context;

    public MyAdapter(SecondActivity context,ArrayList<Diary> diaryArrayList) {
        this.diaryArrayList = diaryArrayList;
        this.context = context;
    }

    @Override
    public int getCount() { return diaryArrayList.size();}

    @Override
    public Object getItem(int position) { return diaryArrayList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        if (view==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            view=layoutInflater.inflate(R.layout.list_view,null);
        }

        TextView tvMonth=view.findViewById(R.id.tv_month);
        TextView tvDay=view.findViewById(R.id.tv_day);
        TextView tvYear=view.findViewById(R.id.tv_year);

        TextView tv2=view.findViewById(R.id.tv_sub);
        TextView tv3=view.findViewById(R.id.tv_mat);

        String temp=diaryArrayList.get(position).getDate();
        try {
            Date t=new SimpleDateFormat("EEEE, MMMM d, yyyy").parse(temp);
            tvMonth.setText(new SimpleDateFormat("MMM").format(t));
            tvDay.setText(new SimpleDateFormat("dd").format(t));
            tvYear.setText(new SimpleDateFormat("yyyy").format(t));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Month :"+tvMonth.getText().toString());
        if (true)
        {
            tvMonth.setBackgroundColor(Color.GREEN);
        }

        if (tvMonth.getText().toString().equalsIgnoreCase("FEB"))
        {
            tvMonth.setBackgroundColor(Color.BLUE);
        }

        if (tvMonth.getText().toString().equalsIgnoreCase("MAR"))
        {
            tvMonth.setBackgroundColor(Color.DKGRAY);
        }

        if (tvMonth.getText().toString().equalsIgnoreCase("APR"))
        {
            tvMonth.setBackgroundColor(Color.RED);
        }

        if (tvMonth.getText().toString().equalsIgnoreCase("MAY"))
        {
            tvMonth.setBackgroundColor(Color.YELLOW);
        }

        if (tvMonth.getText().toString().equalsIgnoreCase("JUN"))
        {
            tvMonth.setBackgroundColor(Color.MAGENTA);
        }

        if (tvMonth.getText().toString().equalsIgnoreCase("JUL"))
        {
            tvMonth.setBackgroundColor(Color.CYAN);
        }

        if (tvMonth.getText().toString().equals("Aug"))
        {
            tvMonth.setBackgroundColor(Color.BLACK);
        }

        if (tvMonth.getText().toString().equals("Sep"))
        {
            tvMonth.setBackgroundColor(Color.rgb(93,165,210));
        }

        if (tvMonth.getText().toString().equals("Oct"))
        {
            tvMonth.setBackgroundColor(Color.rgb(214,57,136));
        }

        if (tvMonth.getText().toString().equalsIgnoreCase("NOV"))
        {
            tvMonth.setBackgroundColor(Color.rgb(78,109,196));
            // tvMonth.setBackgroundColor(context.getResources().getColor(R.color.colorC));
        }

        if (tvMonth.getText().toString().equals("Dec"))
        {
            tvMonth.setBackgroundColor(Color.rgb(101,217,108));
        }
        tv2.setText(diaryArrayList.get(position).getSubject());
        tv3.setText(diaryArrayList.get(position).getMatter());

        return view;
    }
}
