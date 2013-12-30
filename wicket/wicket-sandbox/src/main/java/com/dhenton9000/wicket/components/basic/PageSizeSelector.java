/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.components.basic;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Component to provide the selection of page sizes for Pageable collections
 *
 * @author dhenton
 */
public class PageSizeSelector extends ListView<Integer> {

    private final Logger logger = LoggerFactory.getLogger(PageSizeSelector.class);
    public static final String SIZE_SELECT_LINK = "sizeLink";
    private int selectedPageSize = 5;

    public PageSizeSelector(final String id, final List<Integer> availablePageSizes) {
        super(id, new Model<LinkedList<Integer>>(new LinkedList<Integer>(availablePageSizes)));
        
    }

    @Override
    protected void populateItem(ListItem<Integer> item) {
        //logger.info("size with "+item.getModelObject());
        Integer displayedValue = item.getModelObject();
        PageSizeLink p = new PageSizeLink(SIZE_SELECT_LINK, displayedValue);
        if (displayedValue.intValue() == this.getSelectedPageSize()) {
            p.setHighlighting(Boolean.TRUE);
        } else {
            p.setHighlighting(Boolean.FALSE);
        }
        item.add(p);
    }

    /**
     * @return the selectedPageSize
     */
    public int getSelectedPageSize() {
        return selectedPageSize;
    }

    /**
     * @param selectedPageSize the selectedPageSize to set
     */
    public void setSelectedPageSize(int selectedPageSize) {
        this.selectedPageSize = selectedPageSize;
    }

    public class PageSizeLink extends AjaxLink<Integer> {

        public static final String NOT_CLASS = "notSelected";
        public static final String SELECTED_CLASS = "selected";

        @Override
        public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
            replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsString());
        }

        public PageSizeLink(String id, final Integer pageSize) {
            super(id, new Model<Integer>(pageSize));
        }

        @Override
        public void onClick(AjaxRequestTarget target) {

            SizeSelectionEvent sE = new SizeSelectionEvent();
            sE.ajaxTarget = target;
            sE.sizeValue = getModelObject().intValue();
            PageSizeSelector.this.setSelectedPageSize(sE.sizeValue);
            send(getPage(), Broadcast.DEPTH, sE);


        }


        public void setHighlighting(final Boolean highlighted) {
            final String className = highlighted ? SELECTED_CLASS : NOT_CLASS;

            add(new AttributeModifier("class", new Model<String>(className)));
        }
    }

    public class SizeSelectionEvent {

        public int sizeValue = 0;
        public AjaxRequestTarget ajaxTarget = null;
    }
}
