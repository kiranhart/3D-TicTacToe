import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Core {

	private Display display;
	private Shell shell;

	private List<Button> gridButtons = new ArrayList<>();

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

		// Setup the grids / buttons
		generateGridButtons();

		shell.pack();
		shell.setSize(200, 600);
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
			}
			gridButtons.add(button);
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
