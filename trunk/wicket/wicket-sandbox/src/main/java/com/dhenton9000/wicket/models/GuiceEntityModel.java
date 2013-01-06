/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.models;

/**
 *
 * @author dhenton
 */
/**
 * Constellio, Open Source Enterprise Search Copyright (C) 2010 DocuLibre inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to: Free Software Foundation,
 * Inc. 51 Franklin Street, Fifth Floor Boston, MA 02110-1301 USA
 */
import com.dhenton9000.jpa.domain.Identifiable;
import java.io.Serializable;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

@SuppressWarnings("serial")
public class GuiceEntityModel<T extends Identifiable<PK>, PK extends Serializable> extends Model {

    private ReloadableEntityModel<T, PK> reloadableEntityModel;

    public GuiceEntityModel() {
    }

    public GuiceEntityModel(IModel entityModel) {
        super();
        this.reloadableEntityModel = new GuiceReloadableEntityModel<T, PK>(entityModel);
    }

    public GuiceEntityModel(T entity) {
        this(new GuiceReloadableEntityModel<T, PK>(entity));
    }

    @Override
    public Serializable getObject() {
        return (Serializable) (reloadableEntityModel != null
                ? reloadableEntityModel.getObject() : null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setObject(Serializable object) {
        if (object != null) {
            Identifiable myEntity = (Identifiable) object;
            if (reloadableEntityModel != null) {
                if (reloadableEntityModel.getObject() == null
                        || !reloadableEntityModel.getObject().equals(myEntity)) {
                    reloadableEntityModel.detach();
                    reloadableEntityModel = new GuiceReloadableEntityModel<T, PK>((T) myEntity);
                }
            } else {
                reloadableEntityModel = new GuiceReloadableEntityModel<T, PK>((T) myEntity);
            }
        } else if (reloadableEntityModel != null) {
            reloadableEntityModel.detach();
            reloadableEntityModel = null;
        }
    }

    @Override
    public void detach() {
        if (reloadableEntityModel != null) {
            reloadableEntityModel.detach();
        }
        super.detach();
    }
}
