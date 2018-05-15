package com.cqupt.mauger.test;

import java.io.File;
import java.util.List;

import com.cqupt.mauger.bean.Url;
import com.cqupt.mauger.util.ParseXMLByDOM4j;

/**
 * Test
 * 
 * @author Mauger
 * @date 2018年5月13日  
 * @version 1.0
 */
public class ParseXMLTest
{
	public static void main(String[] args)
	{
		File file = new File("src/resource/sitemap.xml");
		List<Url> urlList = new ParseXMLByDOM4j().getUrls(file);
		System.out.println("总共有 " + urlList.size() + " 条数据。");
		for (Url url : urlList)
		{
			System.out.println(url.getLoc());
		}
	}
}