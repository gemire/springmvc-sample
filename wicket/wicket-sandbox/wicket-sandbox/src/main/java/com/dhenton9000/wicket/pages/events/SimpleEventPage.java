/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.events;

import com.dhenton9000.wicket.pages.TemplatePage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.hibernate.event.AbstractEvent;

/**
 *
 * @author dhenton
 */
public final class SimpleEventPage extends TemplatePage {

    public SimpleEventPage() {
        super();

        setPageTitle(getClass().getSimpleName());
        IModel<Integer> model = new Model<Integer>(0);


        add(new EventListenerLabel("label", model));
        add(new EventSenderAjaxLink("link", model));
    }

    public class EventListenerLabel extends Label {

        public EventListenerLabel(String id, IModel<Integer> model) {
            super(id, model);
            setOutputMarkupId(true);
        }

        @Override
        public void onEvent(IEvent<?> event) {
            if (event.getPayload() instanceof UpdateEvent) {
                Event update = (Event) event.getPayload();
                update.getTarget().add(this);
            }
        }
    }

    public class UpdateEvent extends AbstractEvent implements Event {

        public UpdateEvent(AjaxRequestTarget target) {
            super(target);
        }
    }

    public interface Event {

        public AjaxRequestTarget getTarget();
    }

    public class AbstractEvent {

        private final AjaxRequestTarget target;

        public AbstractEvent(AjaxRequestTarget target) {
            this.target = target;
        }

        public AjaxRequestTarget getTarget() {
            return target;
        }
    }

    public class EventSenderAjaxLink extends AjaxLink<Integer> {

        public EventSenderAjaxLink(String id, IModel<Integer> model) {
            super(id, model);
        }

        @Override
        public void onClick(AjaxRequestTarget target) {
            Integer obj = getModelObject();
            setModelObject(++obj);//change model value
            send(getPage(), Broadcast.BREADTH, new UpdateEvent(target)); 
            //send event on click.

        }
    }
}
