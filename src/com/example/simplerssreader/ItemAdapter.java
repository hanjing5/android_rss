package com.example.simplerssreader;

import java.util.List;

import com.example.simplerssreader.util.ReadXML;
import com.example.simplerssreader.util.ReadXML.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItemAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Item> objects;

    public ItemAdapter(Context context, List<Item> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            // Do the same for description and link
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        Item item = objects.get(position);
        holder.title.setText(item.getTitle());
        // Same for description and link
        return convertView;
    }

    // Override the other required methods for BaseAdapter

    public class ViewHolder {
        TextView title;
        TextView description;
        TextView link;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
}