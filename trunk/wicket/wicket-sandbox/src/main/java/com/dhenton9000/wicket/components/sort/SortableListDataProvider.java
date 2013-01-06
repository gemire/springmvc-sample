/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.components.sort;

/**
 *
 * @author dhenton
 */
/**
 * Constellio, Open Source Enterprise Search
 * Copyright (C) 2010 DocuLibre inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
 

import com.dhenton9000.jpa.domain.Identifiable;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;


import com.dhenton9000.wicket.models.GuiceEntityModel;
import com.dhenton9000.wicket.models.SortableListModel;
import com.dhenton9000.wicket.models.SortablePropertyListModel;
import java.io.Serializable;

/**
 * 
 * 
 * @author Vincent Dussault
 */
@SuppressWarnings("serial")
public class SortableListDataProvider extends SortableDataProvider {

	protected SortableListModel<? extends Object> listModel;
	
	@SuppressWarnings("unchecked")
    public SortableListDataProvider(List<? extends Object> listModelObject) {
		this(new SortablePropertyListModel(listModelObject));
	}

	/**
	 * 
	 */
	public SortableListDataProvider(SortableListModel<? extends Object> listModel) {
		super();
		this.listModel = listModel;
	}

	/**
	 * @see org.apache.wicket.markup.repeater.data.IDataProvider#iterator(int,
	 *      int)
	 */
    @Override
	public Iterator<? extends Object> iterator(long first, long count) {
		SortParam sortParam = getSort();
		String sortProperty = sortParam != null ? sortParam.getProperty().toString() : null;
		Boolean sortAscending = sortParam != null ? sortParam.isAscending() : null;
		List<? extends Object> list = getSortedList(sortProperty, sortAscending);

		int toIndex = (int) (first + count);
		if (toIndex > list.size()) {
			toIndex = list.size();
		}
		return list.subList((int) first, toIndex).listIterator();
	}

	/**
	 * @see org.apache.wicket.markup.repeater.data.IDataProvider#size()
	 */
    @Override
	public long size() {
		SortParam sortParam = getSort();
                Object t =   sortParam != null ? sortParam.getProperty() : null;
		String sortProperty = (String) t;
		Boolean sortAscending = sortParam != null ? sortParam.isAscending() : null;
		List<? extends Object> list = getSortedList(sortProperty, sortAscending);
		return (long) list.size();
	}

	/**
	 * @see org.apache.wicket.markup.repeater.data.IDataProvider#model(java.lang.Object)
	 */
    @Override
	public IModel model(Object object) {
	    Object modelObject;
	    if (object instanceof Identifiable) {
	        modelObject = 
                        new GuiceEntityModel<Identifiable<Serializable>,Serializable> ((Identifiable) object);
	    } else {
	        modelObject = object;
	    }
		return new CompoundPropertyModel(modelObject) {
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				Object subModelObject = getObject();
				result = prime * result + ((subModelObject == null) ? 0 : subModelObject.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				CompoundPropertyModel other = (CompoundPropertyModel) obj;
				Object subModelObject = getObject();
				Object otherSubModelObject = other.getObject();
				if (subModelObject == null) {
					if (otherSubModelObject != null)
						return false;
				} else if (!subModelObject.equals(otherSubModelObject))
					return false;
				return true;
			}
		};
	}

	/**
	 * Default implementation calls getObject() on the listModel and sorts its content using
	 * Java reflection. 
	 * 
	 * @param orderByProperty
	 * @param orderByAsc
	 * @return
	 */
	public List<? extends Object> getSortedList(final String orderByProperty, final Boolean orderByAsc) {
		return listModel.getObject(orderByProperty, orderByAsc);
	}

	public void detach() {
		listModel.detach();
	}

}
