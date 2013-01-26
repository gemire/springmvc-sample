/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.panels.crud;

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
import com.dhenton9000.wicket.components.sort.AutoHidePagingNavigator;
import com.dhenton9000.wicket.data.providers.GuiceSortableListDataProvider;
import com.dhenton9000.wicket.models.GuiceEntityModel;
import com.dhenton9000.wicket.models.SortableListModel;
import java.util.Arrays;
import java.util.List;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NoRecordsToolbar;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy;

@SuppressWarnings("serial")
public abstract class DataPanel<T> extends AjaxPanel {

    private DataTable dataTable;

    public DataPanel(String id) {
        this(id, Integer.MAX_VALUE);
    }

    
    public DataPanel(String id, int rowsPerPage) {
        super(id);
        List<IColumn> columns = getColumns();

        SortableListModel<T> sortableListModel = getSortableListModel();

        SortableDataProvider dataProvider = new GuiceSortableListDataProvider(sortableListModel) {

            @Override
            protected GuiceEntityModel getEntityModel(Identifiable identifiable) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        List<?> list = Arrays.asList(columns.toArray(new IColumn[0]));

        dataTable = new DataTable("dataTable", list, dataProvider, rowsPerPage);
        add(dataTable);
        dataTable.setOutputMarkupId(true);
        dataTable.setVersioned(false);
        dataTable.addTopToolbar(new AjaxFallbackHeadersToolbar(dataTable, dataProvider) {
            @Override
            protected WebMarkupContainer newSortableHeader(String borderId, Object property, ISortStateLocator locator) {
                WebMarkupContainer sortableHeader = super.newSortableHeader(borderId, property, locator);
                sortableHeader.add(AttributeModifier.replace("scope", "col"));
                return sortableHeader;
            }
        });
        dataTable.addBottomToolbar(new AjaxNavigationToolbar(dataTable) {
            @Override
            protected PagingNavigator newPagingNavigator(String navigatorId,
                    DataTable table) {
                return new AutoHidePagingNavigator(navigatorId, table);
            }
        });
        dataTable.addBottomToolbar(new NoRecordsToolbar(dataTable));
        dataTable.setItemReuseStrategy(new ReuseIfModelsEqualStrategy());
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    /**
     * Returns the absolute index of the first row item.
     *
     * @return
     */
    public int getFirstRowItemAbsoluteIndex() {
        // int currentPage = (int) dataTable.getCurrentPage();
        return (int) dataTable.getRowCount();
        // int rowsPerPage = dataTable.getRowsPerPage();
        // return currentPage * rowsPerPage;
    }

    protected abstract SortableListModel<T> getSortableListModel();

    protected abstract List<IColumn> getColumns();
}
