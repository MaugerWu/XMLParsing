package com.cqupt.mauger.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest
{
	private Logger logger = LogManager.getLogger(Log4jTest.class);

	@Test
	public void testLog4j()
	{
		logger.info("This is a Log4j info log.");
	}
}
