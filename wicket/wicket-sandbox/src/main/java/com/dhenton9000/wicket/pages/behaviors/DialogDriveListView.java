/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.behaviors;

import com.dhenton9000.jpa.entities.Restaurant;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * This class is for a demo of driving a list view off of a dialog box
 * 
 * @author dhenton
 */
public class DialogDriveListView extends  RefreshingView<DialogDemoModel> {

    private List<DialogDemoModel> dialogItems = null;
    public DialogDriveListView(String id,List<DialogDemoModel> d) {
        super(id);
        dialogItems = d;
    }

   
    @Override
    protected Iterator<IModel<DialogDemoModel>> getItemModels() {
        Iterator<DialogDemoModel> modelIter = getDialogItems().iterator();
        
         return new ModelIteratorAdapter<DialogDemoModel>(modelIter) {
                @Override
                protected IModel<DialogDemoModel> model(DialogDemoModel object) {
                    return new CompoundPropertyModel<DialogDemoModel>(object);
                }
            };
        
        
        
        
    }

    @Override
    protected void populateItem(Item<DialogDemoModel> item) {
        IModel<DialogDemoModel> demoItem = item.getModel();
             
            item.add(new Label("name"));
            item.add(new Label("age"));
            item.add(new Label("occupation"));
             

    }
    /**
     * @return the dialogItems
     */
    public List<DialogDemoModel> getDialogItems() {
        return dialogItems;
    }

    /**
     * @param dialogItems the dialogItems to set
     */
    public void setDialogItems(List<DialogDemoModel> dialogItems) {
        this.dialogItems = dialogItems;
    }

   
    
    
   
    
}
