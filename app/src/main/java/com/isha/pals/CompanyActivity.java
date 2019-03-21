package com.isha.pals;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CompanyActivity extends AppCompatActivity
{
    List<CompanyUser> company_lists;
    MyListAdapter adapter;
    //the listview
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



                company_lists = new ArrayList<>();
                listView = (ListView) findViewById(R.id.listView);

                //adding some values to our list
                company_lists.add(new CompanyUser(R.drawable.infosys, "Infoys", "Indore"));
                 company_lists.add(new CompanyUser(R.drawable.oyo, "OYO", "jaipur"));
                 company_lists.add(new CompanyUser(R.drawable.tcs, "TCS", "Pune"));
                 company_lists.add(new CompanyUser(R.drawable.wipro, "Wipro", "Delhi"));
                 company_lists.add(new CompanyUser(R.drawable.samsung, "SamSung", "Mumbai"));
                company_lists.add(new CompanyUser(R.drawable.axisbank, "Axis Bank", "Indore"));
                company_lists.add(new CompanyUser(R.drawable.ebay, "Ebay", "Pune"));
                company_lists.add(new CompanyUser(R.drawable.hp, "HP", "Bangalore"));
                company_lists.add(new CompanyUser(R.drawable.indigo, "Indigo", "Mumbai"));
                company_lists.add(new CompanyUser(R.drawable.ibm, "IBM", "Indore"));




                //creating the adapter
                MyListAdapter adapter = new MyListAdapter(this, R.layout.company_list, company_lists);

                //attaching adapter to the listview
                listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
               if(i==0)
               {
                   Intent intent = new Intent(CompanyActivity.this, InfosysActivity.class);
                   startActivity(intent);
               }
                else if(i==1)
               {
                   Intent intent = new Intent(CompanyActivity.this, OyoActivity.class);
                   startActivity(intent);

               }
                else if(i==2)
               {
                   Intent intent=new Intent(CompanyActivity.this,TCSActivity.class);
                   startActivity(intent);
               }
               else if(i==3)
               {
                   Intent intent=new Intent(CompanyActivity.this,WiproActivity.class);
                   startActivity(intent);
               }
               else if(i==4)
               {
                   Intent intent=new Intent(CompanyActivity.this,SamsungActivity.class);
                   startActivity(intent);
               }
               else if(i==5)
               {
                   Intent intent=new Intent(CompanyActivity.this,AxixBankActivity.class);
                   startActivity(intent);
               }
               else if(i==6)
               {
                   Intent intent=new Intent(CompanyActivity.this,EbayActivity.class);
                   startActivity(intent);
               }
               else if(i==7)
               {
                   Intent intent=new Intent(CompanyActivity.this,HPActivity.class);
                   startActivity(intent);
               }
               else if(i==8)
               {
                   Intent intent=new Intent(CompanyActivity.this,IndigoActivity.class);
                   startActivity(intent);
               }
               else if(i==9)
               {
                   Intent intent=new Intent(CompanyActivity.this,IBMActivity.class);
                   startActivity(intent);
               }


            }
        });


            }

}
