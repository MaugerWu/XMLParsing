package com.cqupt.mauger.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cqupt.mauger.bean.Url;

/**
 * 用 SAX 解析 XML 文件时需要的 Handler
 * 
 * @author Mauger
 * @date 2018年5月13日  
 * @version 1.0
 */
public class SAXParseHandler extends DefaultHandler
{
	private List<Url> urlList = null; // 存放解析到的 URL 数组
	private Url url = null; // 存放当前解析的 URL
	private String content = null; // 存放当前节点值

	/**
	 * 开始解析 XML 时调用此方法
	 */
	@Override
	public void startDocument()
	{
		try
		{
			super.startDocument();
		} catch (SAXException e)
		{
			e.printStackTrace();
		}
		System.out.println(">> Start parsing the XML file...");
		urlList = new ArrayList<Url>();
	}

	/**
	 * XML 文件解析完成后调用此方法
	 */
	@Override
	public void endDocument()
	{
		try
		{
			super.endDocument();
		} catch (SAXException e)
		{
			e.printStackTrace();
		}
		System.out.println(">> The XML file is parsed.");
	}

	/**
	 * 开始解析节点时调用此方法
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	{
		try
		{
			super.startElement(uri, localName, qName, attributes);
			if (qName.equals("url"))
			{
				url = new Url();
			}
		} catch (SAXException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 节点解析完毕后调用此方法
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
	{
		try
		{
			super.endElement(uri, localName, qName);
		} catch (SAXException e)
		{
			e.printStackTrace();
		}

		if (qName.equals("loc"))
		{
			url.setLoc(content);
		} else if (qName.equals("lastmod"))
		{
			url.setLastMod(content);
		} else if (qName.equals("url"))
		{
			urlList.add(url);
			url = null;
		}
	}

	/**
	 * 此方法用来获取节点的值
	 */
	@Override
	public void characters(char[] ch, int start, int length)
	{
		try
		{
			super.characters(ch, start, length);
		} catch (SAXException e)
		{
			e.printStackTrace();
		}

		content = new String(ch, start, length);
		if (!content.trim().equals(""))
		{
			System.out.println("节点值为： " + content);
		}
	}

	/**
	 * 获取 URL List
	 * 
	 * @return urlList
	 */
	public List<Url> getUrls()
	{
		return urlList;
	}
}