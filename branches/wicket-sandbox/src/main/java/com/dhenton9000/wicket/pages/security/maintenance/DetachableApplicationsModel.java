/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.pages.security.maintenance;

import com.dhenton9000.jpa.entities.Applications;
import com.dhenton9000.wicket.dao.IApplicationsDao;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author dhenton
 */
public class DetachableApplicationsModel extends LoadableDetachableModel<Applications> {

    private Integer id;
    private IApplicationsDao applicationsService;

    /**
     * @param c
     */
    public DetachableApplicationsModel(Applications c, IApplicationsDao dao) {
        this(c.getId(),dao);
    }

    /**
     * @param id
     */
    public DetachableApplicationsModel(Integer id,IApplicationsDao dao) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.applicationsService = dao;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Integer.valueOf(id).hashCode();
    }

    /**
     * used for dataview with ReuseIfModelsEqualStrategy item reuse strategy
     * public DetachableApplicationsModel(Applications object) { }
     *
     * @see org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof DetachableApplicationsModel) {
            DetachableApplicationsModel other = (DetachableApplicationsModel) obj;
            return other.id == id;
        }
        return false;
    }

    /**
     * @see org.apache.wicket.model.LoadableDetachableModel#load()
     */
    @Override
    protected Applications load() {
        return applicationsService.findById(id);
    }
}
