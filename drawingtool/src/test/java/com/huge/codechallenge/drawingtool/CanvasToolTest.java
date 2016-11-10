package com.huge.codechallenge.drawingtool;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CanvasToolTest {

		
	private static CanvasTool ct;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		ct=new CanvasTool();
	}

	@Test
	public void testCoordinates() {
		//A pair of coordinates must not be valid in a non initialized Canvas
		assertEquals(false, ct.checkCoordinates(1, 1, 1, 1));
		//Initialize a 10x20 canvas
		ct.initCanvas(10, 20);
		//This pair of coordinates should be valid in a initialized Canvas
		assertEquals(true, ct.checkCoordinates(1, 1, 1, 1));
		//A coordinate which contains a 0 must be invalid
		assertEquals(false, ct.checkCoordinates(0, 1, 1, 1));
		//The (20,21) coordinate is invalid as the y=21 is out of the Canvas
		assertEquals(false, ct.checkCoordinates(20, 21, 1, 1));
		//Test a pair of out of border (negative) coordinates
		assertEquals(false, ct.checkCoordinates(-5, 21, -11, 1));
		
	}
	@Test
	public void testCommandSyntax() {
		//Initialize some commands to test their correctness
		String[] testCommand_1={"C","10","20","30"};
		String[] testCommand_2={"C","10","20"};
		String[] testCommand_3={"L","10","20","40","50"};
		String[] testCommand_4={"L","10","20","40"};
		//This test should expect a false because the C command expects 2 arguments 
		assertEquals(false, ct.validateCommand(testCommand_1));
		//This test should expect a true because the C command expects 2 arguments 
		assertEquals(true, ct.validateCommand(testCommand_2));
		//This test should expect a true because the L command expects 4 arguments 
		assertEquals(true, ct.validateCommand(testCommand_3));
		//This test should expect a false because the L command expects 4 arguments 
		assertEquals(false, ct.validateCommand(testCommand_4));
	}
	
	@Test
	public void testInitCanvas() {
		//Test whether the canvas is not initialized
		assertEquals(false,ct.isCanvasInitialized());
		//Lets initialize a 5 (Width) x 10 (Height) Canvas
		ct.initCanvas(5, 10);
		//Test whether the canvas is now initialized
		assertEquals(true,ct.isCanvasInitialized());
		//Test the canvas Width and Height
		assertEquals(5, ct.getCanvasWidth());
		assertEquals(10, ct.getCanvasHeight());
				
	}
	
	@Test
	public void testDrawLine() {
		//Test whether the canvas is not initialized
		assertEquals(false,ct.isCanvasInitialized());
		//Lets initialize a 5 (Width) x 10 (Height) Canvas
		ct.initCanvas(5, 10);
		//Test whether the canvas is now initialized
		assertEquals(true,ct.isCanvasInitialized());
		//Draw a horizontal line and then check whether four X are effectively in the Canvas
		ct.drawLine(1, 1, 4, 1);
		
		assertEquals('X', ct.getCanvas()[0][0]);
		assertEquals('X', ct.getCanvas()[0][1]);
		assertEquals('X', ct.getCanvas()[0][2]);
		assertEquals('X', ct.getCanvas()[0][3]);
		
		//Draw a vertical line and then check whether four X are effectively in the Canvas
		ct.drawLine(3, 2, 3, 5);
				
		assertEquals('X', ct.getCanvas()[1][2]);
		assertEquals('X', ct.getCanvas()[2][2]);
		assertEquals('X', ct.getCanvas()[3][2]);
		assertEquals('X', ct.getCanvas()[4][2]);
							
	}
	
	@Test
	public void testDrawRectangle() {
		//Test whether the canvas is not initialized
		assertEquals(false,ct.isCanvasInitialized());
		//Lets initialize a 5 (Width) x 10 (Height) Canvas
		ct.initCanvas(10, 10);
		//Test whether the canvas is now initialized
		assertEquals(true,ct.isCanvasInitialized());
		//Draw a 4x4 rectangle and then check some X points on the Canvas
		ct.drawRectangle(1, 1, 4, 4);
		
		assertEquals('X', ct.getCanvas()[0][0]);
		assertEquals('X', ct.getCanvas()[0][1]);
		assertEquals('X', ct.getCanvas()[0][2]);
		assertEquals('X', ct.getCanvas()[0][3]);
						
		assertEquals('X', ct.getCanvas()[3][0]);
		assertEquals('X', ct.getCanvas()[3][1]);
		assertEquals('X', ct.getCanvas()[3][2]);
		assertEquals('X', ct.getCanvas()[3][3]);
							
	}

}
