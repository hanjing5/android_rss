package com.example.simplerssreader;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.simplerssreader.util.ReadXML;
import com.example.simplerssreader.util.ReadXML.Item;
import com.example.simplerssreader.util.ReadXML.RssFeed;

public class main extends Activity {
	ListView Items;
	ArrayAdapter<Item> adapter;
	RssFeed feed;
	public Activity activity = this;

	private class DowloadFeed extends AsyncTask<String, Void, String>{
		@Override
		protected String doInBackground(String... urls) {
			String response = "";
			// TODO Auto-generated method stub
			ReadXML rssReader = new ReadXML("http://www.southbendtribune.com/search/?q=&t=article&l=25&d=&d1=&d2=&s=start_time&sd=desc&c[]=sports/college*&f=rss");
			Log.e("MAIN","Parsing rssReader");
			rssReader.parse(); 
			Log.e("MAIN","Fetching Feed");
			feed = rssReader.getFeed();

			return response;
		}

		@Override
		protected void onPostExecute(String result) {
			Log.e("MAIN","Looping Views");
			System.out.println(feed);
			//for (int i = 0; i < feed.getItems().size(); i++) 
			//Log.e("MAIN",feed.getItems().get(i).title); 
			//for (Item i:feed.getItems())
			//	Log.e("MAIN",i.getLink());
			
			// Create a list adapter
			Items = (ListView)findViewById(R.id.listView1);
			
			ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(activity, android.R.layout.simple_list_item_1, feed.getItems());

			Items.setAdapter(adapter);
			Items.setOnItemClickListener(new ListListener(feed.getItems(), activity));
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//RssReader rssReader = new RssReader("http://www.southbendtribune.com/search/?q=&t=article&l=25&d=&d1=&d2=&s=start_time&sd=desc&c[]=sports/college*&f=rss");
		DowloadFeed task = new DowloadFeed();
		
		//TODO: This is hard coded and not even the correct URL
		task.execute(new String[] { "http://www.vogella.com" });

	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
