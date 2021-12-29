package com.godink.demo01.openUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.itextpdf.text.log.SysoCounter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TestOpenUtils {

	@Test
	void testStringUtils() {
		log.info("result1: {}", StringUtils.leftPad("test", 8, "0"));
		log.info("result2: {}", StringUtils.rightPad("test", 8, "0"));
		
		log.info("test3:{}", StringUtils.replace("aba", "a", "z"));
		log.info("test4:{}", StringUtils.replaceOnce("aba", "a", "z"));
	}
	
	@Test
	void test2() throws ParseException, IOException, InterruptedException {
		Stopwatch stopwatch = Stopwatch.createStarted();
		TimeUnit.SECONDS.sleep(2L);
		System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
	}
	
}
