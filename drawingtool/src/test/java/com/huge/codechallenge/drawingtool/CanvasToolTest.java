package com.huge.codechallenge.drawingtool;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CanvasToolTest {

		
	private static CanvasTool ct;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ct=new CanvasTool();
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCoordinates() {
		assertEquals(false, ct.checkCoordinates(1, 1, 1, 1));
		ct.initCanvas(10, 20);
		assertEquals(true, ct.checkCoordinates(1, 1, 1, 1));
		assertEquals(false, ct.checkCoordinates(0, 1, 1, 1));
		assertEquals(false, ct.checkCoordinates(20, 21, 1, 1));
		
	}
	@Test
	public void testCommandSyntax() {
		String[] testCommand_1={"C","10","20","30"};
		String[] testCommand_2={"C","10","20"};
		String[] testCommand_3={"L","10","20","40","50"};
		String[] testCommand_4={"L","10","20","40"};
		assertEquals(false, ct.validateCommand(testCommand_1));
		assertEquals(true, ct.validateCommand(testCommand_2));
		assertEquals(true, ct.validateCommand(testCommand_3));
		assertEquals(false, ct.validateCommand(testCommand_4));
		
	}
	
	

}
