package com.example.nikos.papaapadakis;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyCategories extends ArrayAdapter<CatLists> {


    public MyCategories(Context context, int resource,List<CatLists> items) {
        super(context, resource, items);
    }

/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        ViewHolderItems holder;
        View listview = null;

       if(listview == null){
            LayoutInflater li = LayoutInflater.from(getContext());
            listview = li.inflate(R.layout.List_item, parent, false );
            holder = new ViewHolderItems();
            holder.listViewName = (TextView)listview.findViewById(R.id.listName);
            listview.setTag(holder);


        }
        else {
            holder = (ViewHolderItems)listview.getTag();

        }

        CatLists current = getItem(position);
        holder.listViewName.setText(current.getName());

    }
*/

    static class ViewHolderItems{
        TextView listViewName;
    }
}
