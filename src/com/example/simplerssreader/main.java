package com.example.simplerssreader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.example.simplerssreader.util.ReadXML;
import com.example.simplerssreader.util.ReadXML.Item;
import com.example.simplerssreader.util.ReadXML.RssFeed;

public class main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//try {
			//RssReader rssReader = new RssReader("http://www.southbendtribune.com/search/?q=&t=article&l=25&d=&d1=&d2=&s=start_time&sd=desc&c[]=sports/college*&f=rss");
			
			ReadXML rssReader = new ReadXML("http://www.southbendtribune.com/search/?q=&t=article&l=25&d=&d1=&d2=&s=start_time&sd=desc&c[]=sports/college*&f=rss");
			Log.e("MAIN","Parsing rssReader");
			rssReader.parse(); 
			Log.e("MAIN","Fetching Feed");
			RssFeed feed = rssReader.getFeed();
			ListView Items = (ListView)findViewById(R.id.listView1);
			Log.e("MAIN","Looping");
			System.out.println(feed);
			//for (int i = 0; i < feed.getItems().size(); i++) 
			//	Log.e("MAIN",feed.getItems().get(i).title); 
			//for (Item i:feed.getItems()){
			//	Log.e("MAIN",i.getLink());
			//}
			// Create a list adapter
			//ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, rssReader.getItems());
			//Items.setAdapter(adapter);
			//Items.setOnItemClickListener(new ListListener(rssReader.getItems(), this));
		//}
		//catch (Exception e){
		//	String err = (e.getMessage()==null)?"Main Failure":e.getMessage();
		//	Log.e("SimpleRssReader", err);
		//}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
