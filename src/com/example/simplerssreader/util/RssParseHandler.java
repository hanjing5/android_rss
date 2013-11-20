package com.example.simplerssreader.util;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.example.simplerssreader.data.RssItem;

public class RssParseHandler extends DefaultHandler {
	private List<RssItem> rssItems;
	
	//Used to reference item while parsing
	private RssItem currentItem;
	
	//parsing title indicator
	private boolean parsingTitle;
	
	//parsing link indicator
	private boolean parsingLink;
	
	public RssParseHandler() {
		//Log.e("SimpleRssReader","Intialize RssParseHandler...");
		rssItems = new ArrayList<RssItem>();
	}
	
	public List<RssItem> getItems(){
		return rssItems;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws  SAXException {
		super.startElement(uri, localName, qName, attributes);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
	}
}
