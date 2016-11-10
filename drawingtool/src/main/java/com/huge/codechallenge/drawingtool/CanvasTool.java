package com.huge.codechallenge.drawingtool;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DrawingTool
 * CanvasTool.java
 * Purpose: Draw a canvas on the terminal and allow the user to draw lines, rectangles
 * 			and fill areas with some character
 *
 * @author Santiago Campuzano Vallejo
 * @version 1.0.0 07/11/16
 */
public class CanvasTool {
	
	// Define class private variables
	private char[][] canvas;
	private int canvasHeight;
	private int canvasWidth;
	private char[] horCanvasBorder;
	private boolean isCanvasInitialized;
	
	/**
	 * @return the canvas
	 */
	public char[][] getCanvas() {
		return canvas;
	}
	/**
	 * @return the canvasHeight
	 */
	public int getCanvasHeight() {
		return canvasHeight;
	}
	/**
	 * @return the canvasWidth
	 */
	public int getCanvasWidth() {
		return canvasWidth;
	}
	/**
	 * @return the horCanvasBorder
	 */
	public char[] getHorCanvasBorder() {
		return horCanvasBorder;
	}
	/**
	 * @return the isCanvasInitialized
	 */
	public boolean isCanvasInitialized() {
		return isCanvasInitialized;
	}


	//
	/**
	 * This is the Class Constructor
	 */
	public CanvasTool() {
		super();
		isCanvasInitialized=false;
	}
	/**
	 * This method is used to initialize or create the Canvas
	 * It takes width and height as parameters and then creates
	 * the 2D char (spaces) array representing the Canvas
	 * @param w This is the width of the canvas
	 * @param h  This is the height of the canvas
	 * @return Nothing.
	 */
	protected void initCanvas(int w, int h) {
		//Validate whether the weight and canvasHeight are positive integers
		if (w >= 1 && h >= 1) {
			// Set the canvasHeight and canvasWidth of the Canvas
			this.canvasHeight = h;
			this.canvasWidth = w;

			// Initialize the 2d char matrix, the Canvas
			canvas = new char[h][w];

			// Create 1 char array for setting the canvas top and bottom border with "-" chars
			horCanvasBorder = new char[w + 2];
			Arrays.fill(horCanvasBorder, '-');

			// Set all canvas "pixels" with space " " chars
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					canvas[y][x] = ' ';
				}
			}
			isCanvasInitialized=true;
		}
	}
	/**
	 * This method is used to print the Canvas contents on standard
	 * output (Command Line Output).  It puts a header a footer and
	 * then the contents of the Canvas itself
	 * @return Nothing.
	 */
	protected void printCanvas() {
		if(isCanvasInitialized){
			//Print the canvas top border with "-" chars 
			System.out.println(horCanvasBorder);
			//Loop and print the Canvas "pixels" 2d char array...
			for (int y = 0; y < this.canvasHeight; y++) {
				System.out.print("|");
				for (int x = 0; x < this.canvasWidth; x++) {
					System.out.print(canvas[y][x]);
				}
				System.out.println("|\n");
			}
			//Print the canvas bottom border with "-" chars 
			System.out.println(horCanvasBorder);
		}
	}
	/**
	 * This method is used to create or draw a rectangle
	 * inside the Canvas 2D char array. It takes 2 pairs
	 * of x,y coordinates.  The first pair for the upper left corner
	 * and the second one for the lower right corner.
	 * @param x1 Upper left corner
	 * @param y1  Upper left corner
	 * @param x2 Lower right corner
	 * @param y2  Lower right corner
	 * @return Nothing.
	 */
	protected void drawRectangle(int x1, int y1, int x2, int y2) {
		// Check whether the coordinates are inside the canvas borders
		if(checkCoordinates(x1, y1, x2, y2) && isCanvasInitialized){
			drawLine(x1,y1,x2,y1);
			drawLine(x1,y2,x2,y2);
			drawLine(x1,y1,x1,y2);
			drawLine(x2,y1,x2,y2);
		}
		else{
			System.out.println("The rectangle can't be drawn");
		}

	}
	/**
	 * This method is used to create or draw a vertical or horizontal line
	 * inside the Canvas 2D char array. It takes 2 pairs
	 * of x,y coordinates.  The first pair for the starting point
	 * and the second one for the finish point
	 * @param x1 Starting point
	 * @param y1 Starting point
	 * @param x2 Finish point
	 * @param y2 Finish point
	 * @return Nothing.
	 */
	protected void drawLine(int x1, int y1, int x2, int y2) {
		// Check whether the coordinates are inside the canvas borders
		if(checkCoordinates(x1, y1, x2, y2) && isCanvasInitialized){
			// Check whether it's a horizontal line
			if (y1 == y2) {
				//Draw a horizontal line with 'X' character
				for (int x = x1; x <= x2; x++) {
					canvas[y1 - 1][x - 1] = 'X';
				}
				// Check whether it's a vertical line
			} 
			else if (x1 == x2) {
				//Draw a vertical line with 'X' character
				for (int y = y1; y <= y2; y++) {
					canvas[y - 1][x1 - 1] = 'X';
				}
			}
			// Otherwise, the line is not drawn...
			else {
				System.out.println("The line can't be drawn as it's not horizontal nor vertical..");
			}
		}
	}
	/**
	 * This method is used to fill the entire area connected
	 * with (x,y) point inside the canvas with color "c"
	 * It takes a recursive approach to do that
	 * @param x Starting point
	 * @param y Starting point
	 * @param c Color to fill with
	 * @return Nothing.
	 */
	protected void fillBucket(int x, int y, char c){
		// Check whether the coordinates are inside the canvas borders and if the point is white (space)
		if(checkCoordinates(x, y, x, y) && (canvas[y-1][x-1]==' ') && isCanvasInitialized){			
			//Fill the pixel with the selected color
			canvas[y-1][x-1]=c;
			//Recursively invoke the fillBucket function in the surrounding points
			fillBucket(x, y-1, c);
			fillBucket(x, y+1, c);
			fillBucket(x-1, y, c);
			fillBucket(x+1, y, c);

		}		
	}
	/**
	 * This method is used to validate the commands entered by the user
	 * According with the command typed by the user, this method
	 * validates only the number of parameters required
	 * @param arguments[] String array containing the command and it's arguments
	 * @return A boolean indicating whether the number of arguments it's right.
	 */
	protected boolean validateCommand(String[] arguments){
		boolean response;
		switch(arguments[0]){
		case "C":
			response = (arguments.length == 3) ? true:false;
			break;
		case "L":
		case "R":
			response = (arguments.length == 5) ? true:false;
			break;
		case "B":
			response = (arguments.length == 4) ? true:false;
			break;
		case "Q":
			response = (arguments.length == 1) ? true:false;
			break;
		case "?":
		case "h":
		case "H":
			response = true;
				break;
		default:
			response = false;			
		}
		return response;		
	}

	/**
	 * This method is used to validate whether a pair of coordinates
	 * are inside the Canvas
	 * @param x1 First point
	 * @param y1 First point
	 * @param x2 Second point
	 * @param y2 Second point
	 * @return A boolean indicating whether the pair of coordinates are inside the Canvas
	 */
	protected boolean checkCoordinates(int x1, int y1, int x2, int y2) {
		return validateCoordinate(x1, y1) && validateCoordinate(x2, y2) ;	
	}

	/**
	 * This method is used to validate whether a coordinate is inside the Canvas
	 * @param x 
	 * @param y 
	 * @return A boolean indicating whether the coordinate is inside the Canvas
	 */
	protected boolean validateCoordinate(int x, int y) {
		return x >= 1 && y >= 1 && x <= this.canvasWidth && y <= this.canvasHeight;
	}
	
	
	/**
	 * This is method is used for printing a simple help
	 * for the users
	 * @return Nothing
	 */
	protected void printHelp(){		
		System.out.println("The program support the following commands:\n");
		System.out.println("C w h 		  -> Should create a new canvas of width w and height h.\n");
		System.out.println("L x1 y1 x2 y2 -> Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported.\n");
		System.out.println("R x1 y1 x2 y2 -> Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). \n");
		System.out.println("B x y c       -> Should fill the entire area connected to (x,y) with 'colour' c. The behaviour of this is the same as that of the 'bucket fill' tool in paint programs. \n");
		System.out.println("Q             -> Should quit the program.\n");
	}
	/**
	 * This is the main method used to initialize a CanvasTool object
	 * and interact with the user through the command line
	 * @return Nothing
	 */
	public static void main(String[] args) {
		CanvasTool myCt = new CanvasTool();

		Scanner scanner = new Scanner(System.in);
		String[] parameters;
		while(true){
			//Ask the user to enter a command and then split it to extract the command an the parameters
			System.out.print("enter command: ");
			String command = scanner.nextLine();
			parameters=command.split(" ");
						
			try {
				//Validate the correctness of the invoked command...
				if (myCt.validateCommand(parameters)) {
					switch (parameters[0]) {
					case "C":
						myCt.initCanvas(Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2]));
						myCt.printCanvas();
						break;
					case "L":
						myCt.drawLine(Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2]),
								Integer.valueOf(parameters[3]), Integer.valueOf(parameters[4]));
						myCt.printCanvas();
						break;
					case "R":
						myCt.drawRectangle(Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2]),
								Integer.valueOf(parameters[3]), Integer.valueOf(parameters[4]));
						myCt.printCanvas();
						break;
					case "B":
						myCt.fillBucket(Integer.valueOf(parameters[1]), Integer.valueOf(parameters[2]),
								parameters[3].charAt(0));
						myCt.printCanvas();
						break;
					case "h":
					case "H":
					case "?":							
						myCt.printHelp();
						break;
					case "Q":
						return;
					default:
						break;
					}
				} 
			//Validate a NumberFormatException in case the user typed strings instead of integers for the coordinates
			} catch (java.lang.NumberFormatException e) {
				System.out.println(" There is an error with the parameters, please check and try again...");				
			}
			catch(Exception e){
				e.printStackTrace();				
			}
		}		
	}
}
