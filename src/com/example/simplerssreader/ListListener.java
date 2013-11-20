package com.example.simplerssreader;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.simplerssreader.util.ReadXML.Item;

public class ListListener implements OnItemClickListener{
	List<Item> listItems;
	Activity activity;
	/**
	public ListListener(List<RssItem> listItems, Activity activity) {
		this.listItems = listItems;
		this.activity = activity;
	}
	 **/
	
	public ListListener(List<Item> listItems, Activity activity){
		this.listItems = listItems;
		this.activity = activity;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		// TODO Auto-generated method stub
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(listItems.get(pos).getLink()));
		activity.startActivity(i);
	}
}
