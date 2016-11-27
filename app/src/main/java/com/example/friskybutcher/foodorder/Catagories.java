package com.example.friskybutcher.foodorder;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toolbar;

public class Catagories extends ListActivity
{
    String[] columns = {"CATAGORY"};
    int[] to = {R.id.catagory};
    Cursor mCursor;
    DBManager db;
    Intent soup;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        soup = new Intent(this, Catagories.class);
        db = new DBManager(this);

        try
        {
            db.open();
            mCursor = db.getCategories();
            //mCursor.getString( mCursor.getColumnIndex( "CATAGORY "));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.row, mCursor, columns, to, 0);

        setListAdapter(mAdapter);
    }


    protected void onListItemClick(ListView i, View v, int position, long id)
    {
        switch(position)
        {
            case 0:
                Intent starterActivity = new Intent(Catagories.this, Starters.class);
                startActivity(starterActivity);
                break;
            case 1:
                Intent soupsActivity = new Intent(Catagories.this, Soups.class);
                startActivity(soupsActivity);
                break;
            case 2:
                Intent sandwichActivity = new Intent(Catagories.this, Sandwiches.class);
                startActivity(sandwichActivity);
                break;
            case 3:
                Intent pastaActivity = new Intent(Catagories.this, Pasta.class);
                startActivity(pastaActivity);
                break;
            case 4:
                Intent fishActivity = new Intent(Catagories.this, Fish.class);
                startActivity(fishActivity);
                break;
            case 5:
                Intent mainCourseActivity = new Intent(Catagories.this, MainCourse.class);
                startActivity(mainCourseActivity);
                break;
            case 6:
                Intent desertActivity = new Intent(Catagories.this, Desert.class);
                startActivity(desertActivity);
                break;
        }
    }
}
