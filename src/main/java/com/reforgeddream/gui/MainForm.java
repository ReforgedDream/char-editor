package com.reforgeddream.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import com.reforgeddream.settings.TextConsts;

public class MainForm {

	public static Display display = new Display ();
	public static Shell shell = new Shell (display);
	
	public void createDisplay() {
		
	    Table tableCharacters;
	    Button buttonAdd;
	    Button buttonEdit;
	    Button buttonDel;
	    
	    /**
	     * numColumns
	     * makeColumnsEqualWidth
	     */
	    shell.setLayout(new GridLayout(2, false));
		shell.setText("Character Editor 1.0");
		shell.setSize(400, 300);
		
		//1st column (supra)
	    Composite tableCharactersComposite = new Composite(shell, SWT.BORDER);
	    tableCharactersComposite.setLayout(new GridLayout(1, false));

	    /**
	     * horizontalAlignment
	     * verticalAlignment
	     * grabExcessHorizontalSpace
	     * grabExcessVerticalSpace
	     * horizontalSpan
	     * verticalSpan
	     */
	    tableCharactersComposite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 1, 1));
		
	    //table where characters are listed
	    tableCharacters = new Table(tableCharactersComposite, SWT.FULL_SELECTION);
	    tableCharacters.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 1, 1));
	    tableCharacters.setLinesVisible(true);
	    tableCharacters.setHeaderVisible(true);
	
		//2nd column (supra)
		Composite charsActionsComposite = new Composite(shell, SWT.NONE);
		charsActionsComposite.setLayout(new GridLayout(1, false));
		charsActionsComposite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, false, true, 1, 1));
		
		//'Add' button
		buttonAdd = new Button(charsActionsComposite, SWT.PUSH);
		buttonAdd.setText(TextConsts.WORD_ADD);
		buttonAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		buttonAdd.addListener(SWT.Selection, buttonAddListener);

		//'Edit' button		
		buttonEdit = new Button(charsActionsComposite, SWT.PUSH);
		buttonEdit.setText(TextConsts.WORD_EDIT);
		buttonEdit.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		buttonEdit.addListener(SWT.Selection, buttonEditListener);
			
		//'Delete' button	
		buttonDel = new Button(charsActionsComposite, SWT.PUSH);
		buttonDel.setText(TextConsts.WORD_DELETE);
		buttonDel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		buttonDel.addListener(SWT.Selection, buttonDelListener);

	    shell.open ();
	    
	    while (!shell.isDisposed ()) {
	        if (!display.readAndDispatch ())
	        	display.sleep ();
	    }
	    display.dispose ();
	}
	
	
	//Listener and event handler for 'Add' button
	private Listener buttonAddListener = new Listener() {
		public void handleEvent(Event event) {
			if(display.getShells().length < 2)
				new AddEditForm().createAddEditForm(false);
		}
	};
	
	//Listener and event handler for 'Edit' button
	private Listener buttonEditListener = new Listener() {
		public void handleEvent(Event event) {
			if(display.getShells().length < 2)
				new AddEditForm().createAddEditForm(true);
		}
	};
	
	//Listener and event handler for 'Delete' button
	private Listener buttonDelListener = new Listener() {
		public void handleEvent(Event event) {
					
		}
	};
	
}
