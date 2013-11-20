package com.example.simplerssreader.util;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.util.Log;

import com.example.simplerssreader.data.RssItem;

public class RssReader {
	private String rssUrl;
	
	public RssReader(String rssUrl) {
		//Log.e("SimpleRssReader", "RssReader Initializing...");
		this.rssUrl = rssUrl;
	}
	
	public List<RssItem> getItems() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		RssParseHandler handler = new RssParseHandler();
		saxParser.parse(rssUrl, handler);
		
		
		
		return handler.getItems();
	}
}
