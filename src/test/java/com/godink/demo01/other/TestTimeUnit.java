package com.godink.demo01.other;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class TestTimeUnit {

	@Test
	void test1() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2L);
	}

}
