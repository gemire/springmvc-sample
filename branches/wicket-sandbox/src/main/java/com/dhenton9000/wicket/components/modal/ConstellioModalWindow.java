package com.dhenton9000.wicket.components.modal;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;

@SuppressWarnings("serial")
public class ConstellioModalWindow extends ModalWindow {
	
	public static int MODAL_HEIGHT = 500;
    public int MODAL_WIDTH = 595;
    public static String CSS_MODAL = ModalWindow.CSS_CLASS_GRAY;
    
    public ConstellioModalWindow(String id) {
		super(id);
        setInitialHeight(MODAL_HEIGHT);
        setInitialWidth(MODAL_WIDTH);
        setCssClassName(CSS_MODAL);
	}

}
