/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.components.holders;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

@SuppressWarnings("serial")
public abstract class ModalImgLinkHolder extends ModalLinkHolder {
	
	public ModalImgLinkHolder(String id) {
		super(id);
	}

	@Override
	public Component newLabel(String id, IModel labelModel) {
		return newImg(id);
	}
	
	@Override
    protected IModel getLabelModel() {
	    return null;
    }

    protected abstract Component newImg(String id);

}

