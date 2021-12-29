package com.godink.demo01.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class TestAwt {

	@Test
	void test1() throws InterruptedException {
		Frame f = new Frame("nihao");
		f.add(new Button("Press me"));
		f.setSize(100,100);
		f.setVisible(true);
		TimeUnit.SECONDS.sleep(10);
	}
	

    public static void main(String[] args) {
        Frame f = new Frame("hello");
        Panel p = new Panel();
        p.add(new Button("press me"));
        p.setBackground(Color.GRAY);
        f.add(p);
        f.setSize(100,100);
        f.setBackground(Color.BLUE);
        f.setVisible(true);
    }
  

}
