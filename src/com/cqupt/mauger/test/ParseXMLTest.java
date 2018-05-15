package com.cqupt.mauger.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.cqupt.mauger.bean.Url;
import com.cqupt.mauger.util.ParseXMLByDOM;
import com.cqupt.mauger.util.ParseXMLByDOM4j;
import com.cqupt.mauger.util.ParseXMLByJDOM;
import com.cqupt.mauger.util.ParseXMLBySAX;

/**
 * Test
 * 
 * @author Mauger
 * @date 2018年5月13日  
 * @version 1.0
 */
public class ParseXMLTest
{
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
	{
		File file = new File("src/resource/sitemap.xml");
		String fileName = "src/resource/sitemap.xml";
		List<Url> urlList = null;

		// 测试使用 DOM 解析 XML 文件
		System.out.println("\n---------------DOM 方法解析 XML-------------------");
		urlList = ParseXMLByDOM.getUrls(fileName);
		printParseResult(urlList);

		// 测试使用 JDOM 解析 XML 文件
		System.out.println("\n---------------JDOM 方法解析 XML-------------------");
		urlList = new ParseXMLByJDOM().getUrls(fileName);
		printParseResult(urlList);

		// 测试使用 SAX 解析 XML 文件
		System.out.println("\n---------------SAX 方法解析 XML-------------------");
		urlList = new ParseXMLBySAX().getUrls(fileName);
		printParseResult(urlList);

		// 测试使用 DOM4j 解析 XML 文件
		System.out.println("\n---------------DOM4j 方法解析 XML-------------------");
		urlList = new ParseXMLByDOM4j().getUrls(file);
		printParseResult(urlList);
	}

	private static void printParseResult(List<Url> urlList)
	{
		System.out.println("总共有 " + urlList.size() + " 条数据。");
		for (Url url : urlList)
		{
			System.out.println(url.getLoc() + ", " + url.getLastMod());
		}
	}
}