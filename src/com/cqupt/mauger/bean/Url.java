package com.cqupt.mauger.bean;


/**
 * Java 解析 XML 文件
 * 
 * 1.DOM 方式解析 XML 
 * 	DOM 解析是将 XML 文件全部载入到内存，组装成一颗 DOM 树，然后通过节点以及节点之间的关系来解析 XML文件，与平台无关， 
 * 	Java 提供的一种基础的解析 XML 文件的 API，理解较简单，但是由于整个文档都需要载入内存，不适用于文档较大时。
 * 
 * 2.SAX 方式解析 XML 
 * 	基于事件驱动，逐条解析，适用于只处理 XML 数据，不易编码，而且很难同时访问同一个文档中的多处不同数据。
 * 
 * 3.JDOM 方式解析 XML 
 * 	简化与 XML 的交互并且比使用 DOM 实现更快，仅使用具体类而不使用接口因此简化了 API，并且易于使用。
 * 
 * 4.DOM4j 方式解析 XML 
 * 	JDOM 的一种智能分支，功能较强大，建议熟练使用。
 * 
 * @author Mauger
 * @date 2018年5月13日  
 * @version 1.0
 */
public class Url
{
	private String loc;
	private String lastMod;

	public String getLoc()
	{
		return loc;
	}

	public void setLoc(String loc)
	{
		this.loc = loc;
	}

	public String getLastMod()
	{
		return lastMod;
	}

	public void setLastMod(String lastMod)
	{
		this.lastMod = lastMod;
	}

	@Override
	public String toString()
	{
		return "Url [loc=" + loc + ", lastMod=" + lastMod + "]";
	}

}