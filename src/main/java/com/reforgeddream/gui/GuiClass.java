package com.reforgeddream.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GuiClass {

	public void createDisplay() {
		
		Display display = new Display ();
	    Shell shell = new Shell (display);
	    shell.open ();
	    
	    while (!shell.isDisposed ()) {
	        if (!display.readAndDispatch ()) display.sleep ();
	    }
	    display.dispose ();
	}
}
