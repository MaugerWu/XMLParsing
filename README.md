## XMLParsing

> 最初是想着将自己的博客 [Mauger\` Blog](https://wumaozheng.com) 提交给百度收录，由于 Github 是不允许爬取的，所以尝试了几次还是没有找到合适的解决办法。想把 URL 拿出来手动提交，奈何 XML 记录太多了不想一条一条去复制粘贴，得嘞，写个 Java 程序让其自己去解析 XML 文件吧！

## Java 解析 XML 文件

1. DOM 方式解析 XML 
DOM 解析是将 XML 文件全部载入到内存，组装成一颗 DOM 树，然后通过节点以及节点之间的关系来解析 XML文件，与平台无关， 
Java 提供的一种基础的解析 XML 文件的 API，理解较简单，但是由于整个文档都需要载入内存，不适用于文档较大时。

2. SAX 方式解析 XML 
基于事件驱动，逐条解析，适用于只处理 XML 数据，不易编码，而且很难同时访问同一个文档中的多处不同数据。
 
3. JDOM 方式解析 XML 
简化与 XML 的交互并且比使用 DOM 实现更快，仅使用具体类而不使用接口因此简化了 API，并且易于使用。
 
4. DOM4j 方式解析 XML 
JDOM 的一种智能分支，功能较强大，建议熟练使用。

## XML 文件示例

使用 Java 解析个人博客的 sitemap.xml 文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
  <url>
    <loc>http://wumaozheng.com/2018/Singleton-Pattern.html</loc>
    <lastmod>2018-05-09T18:03:31.848Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/Design-Pattern-Introduction.html</loc>
    <lastmod>2018-05-09T17:08:50.276Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/clone.html</loc>
    <lastmod>2018-04-30T15:44:42.920Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/mybatis3.4-technology-insider.html</loc>
    <lastmod>2018-04-26T15:48:55.083Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2017/git-in-linux.html</loc>
    <lastmod>2018-04-25T19:13:01.654Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2017/markdown-introduction.html</loc>
    <lastmod>2018-04-25T19:12:04.700Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/LeBron-James-20180219.html</loc>
    <lastmod>2018-04-18T13:56:20.903Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/LeBron-James-20180228.html</loc>
    <lastmod>2018-04-18T13:56:05.061Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/LeBron-James-20180124.html</loc>
    <lastmod>2018-04-18T13:55:55.888Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/LeBron-James-20180209.html</loc>
    <lastmod>2018-04-18T13:55:42.143Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/lost-and-confused.html</loc>
    <lastmod>2018-04-18T13:55:15.723Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/sitemap-seo.html</loc>
    <lastmod>2018-03-25T10:13:41.859Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/instagram/ins.json</loc>
    <lastmod>2018-03-22T15:58:05.911Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/Music-For-NBA.html</loc>
    <lastmod>2018-03-14T19:19:05.042Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/baidu-analysis.html</loc>
    <lastmod>2018-03-03T08:06:43.846Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/instagram/index.html</loc>
    <lastmod>2018-02-01T09:15:21.385Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/music-chengdu.html</loc>
    <lastmod>2018-01-30T02:36:22.190Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/message/index.html</loc>
    <lastmod>2018-01-30T00:47:42.836Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2017/hello-world.html</loc>
    <lastmod>2018-01-29T06:03:05.502Z</lastmod>
  </url>
  <url>
    <loc>http://wumaozheng.com/2018/music-gdsnaqgs.html</loc>
    <lastmod>2018-01-29T05:55:20.989Z</lastmod>
  </url>
</urlset>
```
