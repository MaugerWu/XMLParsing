package com.cqupt.mauger.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cqupt.mauger.bean.Url;

/**
 * DOM 方式解析 XML
 * 
 * @author Mauger
 * @date 2018年5月13日  
 * @version 1.0
 */
public class ParseXMLByDOM
{
	private static DocumentBuilderFactory dbFactory = null;
	private static DocumentBuilder db = null;
	private static Document document = null;
	private static List<Url> urlList = null;

	static
	{
		try
		{
			dbFactory = DocumentBuilderFactory.newInstance();
			db = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 获取 URLList
	 * @param fileName file name
	 * @return List
	 */
	public static List<Url> getUrls(String fileName)
	{
		try
		{
			// 将给定的 URI 的内容解析为一个 XML 文档，并返回给 Document 对象
			document = db.parse(fileName);
		} catch (SAXException | IOException e)
		{
			e.printStackTrace();
		}

		// 按文档顺序返回包含在文档中且具有给定标记名称的所有 Element 的 NodeList
		NodeList nodeList = document.getElementsByTagName("url");
		urlList = new ArrayList<Url>();
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			Url url = new Url();
			// 获取第 i 个 URL 节点
			Node node = nodeList.item(i);
			
			// 若 URL 节点中有其他属性，例如：id；获取 第 i 个 URL 的属性值 id
			// NamedNodeMap namedNodeMap = node.getAttributes();
			// String id = namedNodeMap.getNamedItem("id").getTextContent();
			
			// 获取 URL 结点的子节点，包含了 Test 类型的转换
			NodeList nList = node.getChildNodes();

			// 将一个 URL 里面的属性放入到数组中
			ArrayList<String> contents = new ArrayList<String>();
			for (int j = 1; j < nList.getLength(); j += 2)
			{
				Node nNode = nList.item(j);
				String content = nNode.getFirstChild().getTextContent();
				contents.add(content);
			}
			
			url.setLoc(contents.get(0));
			url.setLastMod(contents.get(1));
			urlList.add(url);
		}

		return urlList;
	}
}
