import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Core {

	// The display and shell variables used to setup the window.
	private Display display;
	private Shell shell;
	private GameBoard gameBoard;
	private int clickedButtonID = 0;

	/*
	 * The List to store the all of the buttons that can be clicked in the game.
	 */
	private List<Button> gridButtons = new ArrayList<>();

	/*
	 * Determine which player turn it is, start with X then swap to player O,
	 * then back, vis-versa
	 */
	private boolean playerXTurn = true;

	/*
	 * This is where everything will be initialized, setting up the display
	 * creating the 3x3 X3 grids, and any other methods to setup the game.
	 */
	public Core() {
		setupDisplay();
	}

	/*
	 * This method will perform everything that is needed in order to setup the
	 * game and display the game. Initialize the display and shell, generate the
	 * buttons add the click listeners, set the size, and code for disposal
	 */
	private void setupDisplay() {
		display = new Display();
		shell = new Shell(display);
		gameBoard = new GameBoard();

		// Set the title
		shell.setText("3D Tic Tac Toe");

		// Setup the grids / buttons
		generateGridButtons();

		// Add Listeners
		addClickListeners();

		shell.pack();
		shell.setSize(196, 637);
		shell.setVisible(true);

		// Check for if the x button is closed.
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		shell.dispose();
	}

	/*
	 * This method will generate all of the grid buttons onto the shell and
	 * display them.
	 */
	private void generateGridButtons() {
		int x = 0;
		int y = 0;

		// Loop through 27 times, 3x3 -- 3 times
		for (int i = 0; i < 27; i++) {
			/*
			 * Create an empty button with the size 60x60 pixels then set the
			 * location according the the x and y.
			 */
			Button button = new Button(shell, SWT.PUSH);
			button.setSize(new Point(60, 60));
			button.setLocation(new Point(x, y));
			// button.setFont(new Font(display, "Tahoma", 10, SWT.BOLD));
			//button.setText("" + i);
			button.setVisible(true);

			// Add 60 to x
			x += 60;
			// If x is 180; so 3 buttons on a row, set
			// x to 0 to start on the left then increase y
			// by 60 to move down a row.
			if (x == 180) {
				x = 0;
				y += 60;

				/*
				 * Add Spacer in between the grids
				 */

				if (y == 180 || y == 380 || y == 580) {
					Button filler = new Button(shell, SWT.PUSH);
					filler.setSize(new Point(180, 20));
					filler.setLocation(new Point(x, y));
					filler.setVisible(true);
					// add 20 to keep formatting nice
					y += 20;
				}
			}

			// Finally add the buttons to the list for later use.
			gridButtons.add(button);
		}
	}

	/*
	 * This method will loop through each of the buttons in the gridButtons
	 * array and add the mouse listener class to the button, by getting the
	 * button by index I.
	 */
	private void addClickListeners() {
		for (int i = 0; i < gridButtons.size(); i++)
			gridButtons.get(i).addMouseListener(new MouseListeners(gridButtons.get(i)));
	}

	/*
	 * This is an inner class that implements the mouse listener this helps
	 * minimize the code as much as possible, so I can loop through each button
	 * and add the listener, and perform any action from there. Gotta make it
	 * efficient you know.
	 */
	class MouseListeners implements MouseListener {

		private Button button;

		public MouseListeners(Button button) {
			this.button = button;
		}

		/*
		 * Check when the player clicks on the button, if they click perform any
		 * check needed to place the O or X character, and check wins.
		 */
		@Override
		public void mouseDown(MouseEvent e) {

			//Get the button index in the array on click.
			clickedButtonID = gridButtons.indexOf(button);
			
			/*
			 * Mr. Nestor's mapping method to get the specific level, row, column 
			 * depending on which button is clicked and it's ID, in a single
			 * dimensional array. 
			 */
			double remainder = clickedButtonID % 9;
			int level = (int) clickedButtonID / 9;
			int row = (int) remainder / 3;
			int col = (int) remainder % 3;
			
			//Check if the move can be made to the specific level, row and column by checking if the space is blank 
			if (gameBoard.checkMove(Integer.valueOf(level + 1), Integer.valueOf(row + 1), Integer.valueOf(col + 1)).equalsIgnoreCase(GameBoard.playerFree)) {
				//Make a move depending on who's turn it is on the specific level, row and column.
				if (gameBoard.makeMove((playerXTurn) ? GameBoard.playerX :  GameBoard.playerO, Integer.valueOf(level + 1), Integer.valueOf(row + 1), Integer.valueOf(col + 1))) {
				
					System.out.println("Made move to level: " + level + " row: " + row + " col: " + col);
					
					/*
					 * Update the button text to let the player know which player
					 * made a move onto that grid slot.
					 */
					button.setText((playerXTurn) ? GameBoard.playerX :  GameBoard.playerO);
					
					//Swap the player turn.
					playerXTurn = !playerXTurn;
				}
			} else {
				System.out.println("The player: \"" + button.getText() + "\" already chose there.");
			}

		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void mouseUp(MouseEvent e) {
		}
	}

	/*
	 * This is the main method, the program will call this method and run any
	 * code within this class upon pressing start
	 */
	public static void main(String[] args) {
		new Core();
	}
}
