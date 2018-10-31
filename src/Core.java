
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

	private Display display;
	private Shell shell;

	private List<Button> gridButtons = new ArrayList<>();
	
	private boolean playerXTurn = true;

	/*
	 * This is where everything will be initialized, setting up the display
	 * creating the 3x3 X3 grids, and any other methods to setup the game.
	 */
	public Core() {
		setupDisplay();
	}

	private void setupDisplay() {
		display = new Display();
		shell = new Shell(display);
		
		//Set the title
		shell.setText("3D Tic Tac Toe");
		
		// Setup the grids / buttons
		generateGridButtons();
		
		//Add Listeners
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
		
		for (int i = 0; i < 27; i++) {
			Button button = new Button(shell, SWT.PUSH);
			button.setSize(new Point(60, 60));
			button.setLocation(new Point(x, y));
			button.setVisible(true);
			
			x += 60;
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
					y += 20;
				}
			}
			
			gridButtons.add(button);
		}
	}
	
	/*
	 * This method will loop through each of the buttons
	 * in the gridButtons array and add the mouse listener class
	 * to the button, by getting the button by index I.
	 */
	private void addClickListeners() {
		for (int i = 0; i < gridButtons.size(); i++) {
			gridButtons.get(i).addMouseListener(new MouseListeners(gridButtons.get(i)));
		}
	}
	
	/*
	 * This is an inner class that implements the mouse listener
	 * this helps minimize the code as much as possible, so 
	 * I can loop through each button and add the listener, and perform
	 * any action from there. Gotta make it efficient you know.
	 */
	class MouseListeners implements MouseListener{
			
		private Button button;
		
		public MouseListeners(Button button) {
			this.button = button;
		}
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void mouseUp(MouseEvent e) {
		}	
		
		@Override
		public void mouseDown(MouseEvent e) {
			if(playerXTurn) {
				button.setText("X");
				playerXTurn = false;
			} else {
				button.setText("O");
				playerXTurn = true;
			}
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
