import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class EndGameButton {
	
	//End Game Button
	public static Button EndGame;

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("End Game Button");
        
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 15;
        shell.setLayout(rowLayout);
 
        EndGame = new Button(shell, SWT.TOGGLE);
        EndGame.setSize(new Point(200, 100));
        EndGame.setLocation(new Point(100, 500));
        EndGame.setText("End Game");
        EndGame.setVisible(true);
       
        SelectionListener selectionListener = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
 
                if (source.getSelection()) 
                {
                    System.exit(0); //Ends/Closes the Game program
                } 
                
                }
             };
             EndGame.addSelectionListener(selectionListener); //Enables the listener when the button is selected
                
        shell.setSize(100, 100);
        shell.open();
        while (!shell.isDisposed()) 
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
        }
     }