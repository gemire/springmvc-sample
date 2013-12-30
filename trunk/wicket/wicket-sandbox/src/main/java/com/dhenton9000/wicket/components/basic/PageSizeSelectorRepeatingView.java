/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.components.basic;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Component to provide the selection of page sizes for Pageable collections
 *
 * @author dhenton
 */
public class PageSizeSelectorRepeatingView extends ListView<Integer> {

    private final Logger logger = LoggerFactory.getLogger(PageSizeSelectorRepeatingView.class);
    public static final String SIZE_SELECT_LINK = "sizeLink";
    private IProvider provider;

    public PageSizeSelectorRepeatingView(final String id, final List<Integer> availablePageSizes, IProvider p) {
        super(id, new Model<LinkedList<Integer>>(new LinkedList<Integer>(availablePageSizes)));
        provider = p;
    }

    @Override
    protected void populateItem(ListItem<Integer> item) {
        item.add(new PageSizeLink(SIZE_SELECT_LINK, item.getModelObject()));
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

            updateGroupHighlighting();
            provider.processSizeChange(target,getModelObject().intValue());
            SizeSelectionEvent sE = new SizeSelectionEvent();
            sE.ajaxTarget = target;
            sE.sizeValue = getModelObject().intValue();
            send(getPage(), Broadcast.DEPTH, sE);
           
        }

        private void updateGroupHighlighting() {
            getParent().visitChildren(
                    PageSizeLink.class,
                    new IVisitor<PageSizeLink, Void>() {
                        @Override
                        public void component(final PageSizeLink link, final IVisit<Void> visit) {
                            link.setHighlighting(link.equals(PageSizeLink.this));
                            visit.stop();
                        }
                    });
        }

        private void setHighlighting(final Boolean highlighted) {
            final String className = highlighted ? SELECTED_CLASS : NOT_CLASS;

            add(new AttributeModifier("class", new Model<String>(className)));
        }
    }

    public class SizeSelectionEvent
    {
        public int sizeValue = 0;
        public AjaxRequestTarget ajaxTarget = null;
    }
    public interface IProvider {

    
        /**
         * describe what/how this puppy will update things
         *
         * @param target
         * @param size
         */

        void processSizeChange(AjaxRequestTarget target,int size);
    }
}
