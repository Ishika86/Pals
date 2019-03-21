package com.isha.pals;
import android.content.Context;
        import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AlertDialog;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
import android.widget.ImageView;
        import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MyListAdapter extends ArrayAdapter<CompanyUser>
{

    //the list values in the List of type companyObj
    List<CompanyUser> companyObjList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource, List<CompanyUser> companyObjList) {
        super(context, resource, companyObjList);
        this.context = context;
        this.resource = resource;
        this.companyObjList = companyObjList;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        int id=view.getId();

        //getting the view elements of the list from the view
        ImageView imageView = (ImageView)view.findViewById(R.id.icon);
        TextView textViewName = (TextView)view.findViewById(R.id.company_name);
        TextView textViewTeam = (TextView)view.findViewById(R.id.subcompany_name);


        //getting the companyObj of the specified position
        CompanyUser companyObj = companyObjList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(companyObj.getImage()));
        textViewName.setText(companyObj.getCompany());
        textViewTeam.setText(companyObj.getCompany_location());
    //trial

        //finally returning the view
        return view;
    }
    //trial

    //this method will remove the item from the list
   private void removecompanyObj(final int position) {
        //Creating an alert dialog to confirm the deletion
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");

        //if the response is positive in the alert
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //removing the item
                companyObjList.remove(position);

                //reloading the list
                notifyDataSetChanged();
            }
        });

        //if response is negative nothing is being done
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //creating and displaying the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
