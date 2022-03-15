package com.ashok.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class SampleTest {

	@BeforeAll
	static void beforAll() {
		System.out.println("Intialize connection to datbase");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("Close connection to database");
	}

	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize test data for each testcase " + info.getDisplayName());
	}

	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("clean up test data " + info.getDisplayName());
	}

	@Test
	void test() {
		int actuallength = "sbcd".length();

		int expectedlength = 4;

		assertEquals(expectedlength, actuallength);
	}

	@Test
	@DisplayName("When length is null, throw an exception ")
	void length_exeption() {
		String str = null;
		assertThrows(NullPointerException.class, () -> str.length());
	}

	@Test
	void toUpperCase_basic() {
		String str = "abcd".toUpperCase();
		assertEquals("ABCD", str);
	}

	@Test
	void containsMethod() {
		String str = "asdfgh";
		boolean result = str.contains("adsd");
		assertEquals(false, result);
	}

	@Test
	void split_basic() {
		String str = "abc cde fgh";
		String actialresult[] = str.split(" ");
		String[] expectingresult = new String[] { "abc", "cde", "fgh" };
		assertArrayEquals(expectingresult, actialresult);

	}
}
