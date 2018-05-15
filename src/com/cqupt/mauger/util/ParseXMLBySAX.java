package com.cqupt.mauger.util;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.cqupt.mauger.bean.Url;
import com.cqupt.mauger.handler.SAXParseHandler;

/**
 * SAX 方式解析 XML
 * 
 * @author Mauger
 * @date 2018年5月13日  
 * @version 1.0
 */
public class ParseXMLBySAX
{
	private SAXParserFactory factory = null;
	private SAXParser parser = null;

	public List<Url> getUrls(String fileName) throws SAXException, IOException, ParserConfigurationException
	{
		factory = SAXParserFactory.newInstance();
		parser = factory.newSAXParser();
		SAXParseHandler handler = new SAXParseHandler();
		parser.parse(fileName, handler);

		return handler.getUrls();
	}
}
