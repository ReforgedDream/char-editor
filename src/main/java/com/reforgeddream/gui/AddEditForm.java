package com.reforgeddream.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.reforgeddream.settings.TextConsts;

public class AddEditForm {
	
	Shell shellAddEdit = new Shell (MainForm.display, SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
	
	public void createAddEditForm(Boolean isEdit) {
		
		Button buttonSave;
		Button buttonCancel;
		
		Text textId;
		Text textName;
		Text textPassword;
		Text textHealth;
		Text textDamage;
		Text textRating;

	    shellAddEdit.setLayout(new GridLayout(2, false));
	    if(isEdit) {
	    	shellAddEdit.setText(TextConsts.WORD_EDIT_CHARACTER);
	    } else {
	    	shellAddEdit.setText(TextConsts.WORD_ADD_NEW_CHARACTER);
	    }
	    
	    shellAddEdit.setSize(220, 190);
		
		//1st column (supra)
	    Composite fieldsComposite = new Composite(shellAddEdit, SWT.BORDER);
	    fieldsComposite.setLayout(new GridLayout(2, false));
	    fieldsComposite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 1, 1));
		
	  
	    //fields with character's parameters
	    
	    //ID label and text field
	    Label labelId = new Label(fieldsComposite, SWT.NONE);
	    labelId.setText(TextConsts.WORD_ID);
		textId = new Text(fieldsComposite, SWT.SINGLE + SWT.BORDER);
		textId.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
	    //name label and text field
	    Label labelName = new Label(fieldsComposite, SWT.NONE);
	    labelName.setText(TextConsts.WORD_NAME);
		textName = new Text(fieldsComposite, SWT.SINGLE + SWT.BORDER);
		textName.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
	    //Password label and text field
	    Label labelPassword = new Label(fieldsComposite, SWT.NONE);
	    labelPassword.setText(TextConsts.WORD_PASSWORD);
		textPassword = new Text(fieldsComposite, SWT.SINGLE + SWT.BORDER);
		textPassword.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

	    //Health label and text field
	    Label labelHealth = new Label(fieldsComposite, SWT.NONE);
	    labelHealth.setText(TextConsts.WORD_HEALTH);
		textHealth = new Text(fieldsComposite, SWT.SINGLE + SWT.BORDER);
		textHealth.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
	    //Damage label and text field
	    Label labelDamage = new Label(fieldsComposite, SWT.NONE);
	    labelDamage.setText(TextConsts.WORD_DAMAGE);
		textDamage = new Text(fieldsComposite, SWT.SINGLE + SWT.BORDER);
		textDamage.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
	    //Rating label and text field
	    Label labelRating = new Label(fieldsComposite, SWT.NONE);
	    labelRating.setText(TextConsts.WORD_RATING);
		textRating = new Text(fieldsComposite, SWT.SINGLE + SWT.BORDER);
		textRating.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
		//2nd column (supra)
		Composite saveCancelButtonsComposite = new Composite(shellAddEdit, SWT.NONE);
		saveCancelButtonsComposite.setLayout(new GridLayout(1, false));
		saveCancelButtonsComposite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, false, true, 1, 1));
		
		//'Save' button
		buttonSave = new Button(saveCancelButtonsComposite, SWT.PUSH);
		
		if(isEdit) {
			buttonSave.setText(TextConsts.WORD_SAVE);
		} else {
			buttonSave.setText(TextConsts.WORD_CREATE);
		}
		
		buttonSave.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		buttonSave.addListener(SWT.Selection, buttonSaveListener);

		//'Cancel' button		
		buttonCancel = new Button(saveCancelButtonsComposite, SWT.PUSH);
		buttonCancel.setText(TextConsts.WORD_CANCEL);
		buttonCancel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		buttonCancel.addListener(SWT.Selection, buttonCancelListener);

		shellAddEdit.open ();
	    
	    if(MainForm.shell.isDisposed())
	    	shellAddEdit.dispose ();
	}
	
	//Listener and event handler for 'Save' button
	private Listener buttonSaveListener = new Listener() {
		public void handleEvent(Event event) {
			
		}
	};
	
	//Listener and event handler for 'Cancel' button
	private Listener buttonCancelListener = new Listener() {
		public void handleEvent(Event event) {
			shellAddEdit.dispose ();
		}
	};
	
}
