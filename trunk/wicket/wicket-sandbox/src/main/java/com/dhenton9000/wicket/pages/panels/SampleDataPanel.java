/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.panels;

import com.dhenton9000.wicket.models.SortableListModel;
import com.dhenton9000.wicket.panels.DataPanel;
import java.util.List;

/**
 *
 * @author dhenton
 */
public class SampleDataPanel extends DataPanel {

    private SortableListModel model = null;
    private int rowsPerPage;
    
    
    public SampleDataPanel(String id) {
        super(id);
        setup();
    }

    public SampleDataPanel(String id, int rowsPerPage) {
        
        super(id, rowsPerPage);
        this.rowsPerPage = rowsPerPage;
        setup();
    }

    
    private final void setup()
    {
        
    }
    
    
    
    @Override
    protected SortableListModel getSortableListModel() {
       return model;
    }

    @Override
    protected List getColumns() {
        return null;
    }

    /**
     * @return the rowsPerPage
     */
    public int getRowsPerPage() {
        return rowsPerPage;
    }
    
}
