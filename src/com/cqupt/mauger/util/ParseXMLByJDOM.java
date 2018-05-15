package com.cqupt.mauger.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.cqupt.mauger.bean.Url;

/**
 * JDOM 方式解析 XML
 * 
 * @author Mauger
 * @date 2018年5月13日  
 * @version 1.0
 */
public class ParseXMLByJDOM
{
	private List<Url> urlList = null;
	private Url url = null;

	public List<Url> getUrls(String fileName)
	{
		// 这里需要 jdom-2.0.6.jar
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document;
		try
		{
			document = saxBuilder.build(new FileInputStream(fileName));
			// 获取根节点 urlset
			Element rootElement = document.getRootElement();
			// 获取根节点 urlset 下的子节点，返回子节点数组
			List<Element> childList = rootElement.getChildren();
			
			urlList = new ArrayList<Url>();
			for (Element childElement : childList)
			{
				url = new Url();
				// 获取 url 下的子节点
				List<Element> children = childElement.getChildren();
				for (Element element : children)
				{
					if (element.getName().equals("loc"))
					{
						String loc = element.getValue();
						url.setLoc(loc);
					} else if (element.getName().equals("lastmod"))
					{
						String lastMod = element.getValue();
						url.setLastMod(lastMod);
					}
				}
				
				urlList.add(url);
				url = null;
			}
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} catch (JDOMException e2)
		{
			e2.printStackTrace();
		} catch (IOException e3)
		{
			e3.printStackTrace();
		}
		return urlList;
	}
}
