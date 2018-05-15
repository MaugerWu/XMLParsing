package com.cqupt.mauger.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cqupt.mauger.bean.Url;

/**
 * DOM4j 方式解析 XML
 * 
 * @author Mauger
 * @date 2018年5月13日  
 * @version 1.0
 */
public class ParseXMLByDOM4j
{
	private List<Url> urlList = null;
	private Url url = null;

	public List<Url> getUrls(File file)
	{
		SAXReader reader = new SAXReader();
		try
		{
			Document document = reader.read(file);
			Element urlset = document.getRootElement();
			@SuppressWarnings("rawtypes")
			Iterator iterator = urlset.elementIterator();

			urlList = new ArrayList<Url>();
			while (iterator.hasNext())
			{
				url = new Url();
				Element urlElement = (Element) iterator.next();
				@SuppressWarnings("rawtypes")
				Iterator urls = urlElement.elementIterator();
				while (urls.hasNext())
				{
					Element child = (Element) urls.next();
					String nodeName = child.getName();
					if (nodeName.equals("loc"))
					{
						String loc = child.getStringValue();
						url.setLoc(loc);
					} else if (nodeName.equals("lastmod"))
					{
						String lastMod = child.getStringValue();
						url.setLastMod(lastMod);
					}
				}
				urlList.add(url);
				url = null;
			}
		} catch (DocumentException e)
		{
			e.printStackTrace();
		}
		return urlList;
	}
}