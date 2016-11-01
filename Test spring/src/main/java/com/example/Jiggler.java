package com.example;

import java.awt.AWTException;
import java.awt.Robot;

public class Jiggler {
	public static void main(String[] args) throws InterruptedException, AWTException {
		while (true) {
			Robot r = new Robot();
			r.mouseMove(0, 0);
			Thread.sleep(1000 * 5);
			r.mouseMove(200, 200);
			Thread.sleep(1000 * 20);
		}
	}
}
