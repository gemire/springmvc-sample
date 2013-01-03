/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.panels;

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
import com.dhenton9000.wicket.pages.Application;
import com.dhenton9000.wicket.shared.images.MountSharedImage;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
//import org.apache.wicket.ajax.IAjaxCallDecorator;
//import org.apache.wicket.ajax.calldecorator.AjaxCallDecorator;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeaderlessColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.dhenton9000.wicket.components.holders.ImgLinkHolder;
import com.dhenton9000.wicket.components.holders.ModalImgLinkHolder;
import com.dhenton9000.wicket.components.modal.ConstellioModalWindow;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.PackageResourceReference;

@SuppressWarnings("serial")
public abstract class CRUDPanel<T> extends DataPanel<T> {

    public static int MODAL_HEIGHT = 500;
    public int MODAL_WIDTH = 595;
    public static String CSS_MODAL = ModalWindow.CSS_CLASS_GRAY;
    private AbstractLink addLink;
    private ModalWindow addModal;

    public CRUDPanel(String id, int rowsPerPage) {
        super(id, rowsPerPage);
        initComponents();
    }

    public CRUDPanel(String id) {
        super(id);
        initComponents();
    }

    private void initComponents() {
        if (isUseModalsAddEdit()) {
            addLink = new AjaxLink("addLink") {
                @Override
                public void onClick(AjaxRequestTarget target) {
                    String addMsg = getLocalizer().getString("add", CRUDPanel.this);
                    addModal.setTitle(addMsg);

                    WebMarkupContainer addContent = createAddContent(addModal.getContentId());
                    addModal.setContent(addContent);
                    addModal.show(target);
                }

                @Override
                public boolean isVisible() {
                    return super.isVisible() && isAddLink();
                }
            };
        } else {
            addLink = new StatelessLink("addLink") {
                @Override
                public void onClick() {
                    WebMarkupContainer addContent = createAddContent(CRUDPanel.this.getId());
                    CRUDPanel.this.replaceWith(addContent);
                }

                @Override
                public boolean isVisible() {
                    return super.isVisible() && isAddLink();
                }
            };
        }
        add(addLink);

        addModal = new ConstellioModalWindow("addModal");
        add(addModal);
    }

    public ModalWindow getAddModalWindow() {
        return addModal;
    }

    @Override
    protected List<IColumn> getColumns() {
        List<IColumn> columns = new ArrayList<IColumn>();
        List<IColumn> dataColumns = getDataColumns();
        columns.addAll(dataColumns);
        if (isEditColumn()) {
            IColumn editLinkColumn = getEditLinkColumn();
            if (editLinkColumn != null) {
                columns.add(editLinkColumn);
            }
        }
        if (isDeleteColumn()) {
            IColumn deleteLinkColumn = getDeleteLinkColumn();
            if (deleteLinkColumn != null) {
                columns.add(deleteLinkColumn);
            }
        }
        return columns;
    }

    protected IColumn getEditLinkColumn() {
        return new HeaderlessColumn() {
            @Override
            public void populateItem(Item cellItem, String componentId, final IModel rowItemModel) {
                Item rowItem = (Item) cellItem.findParent(Item.class);
                final int rowIndex = getFirstRowItemAbsoluteIndex() + rowItem.getIndex();
                cellItem.add(new ModalImgLinkHolder(componentId) {
                    @Override
                    public WebMarkupContainer newLink(String id) {
                        if (isUseModalsAddEdit()) {
                            return new AjaxLink(id) {
                                @Override
                                public void onClick(AjaxRequestTarget target) {
                                    ModalWindow editModal = getModalWindow();
                                    editModal.setInitialHeight(MODAL_HEIGHT);
                                    editModal.setInitialWidth(MODAL_WIDTH);
                                    String editMsg = getLocalizer().getString("edit", CRUDPanel.this);
                                    editModal.setTitle(editMsg);

                                    WebMarkupContainer editContent =
                                            createEditContent(editModal.getContentId(), rowItemModel, rowIndex);
                                    editModal.setContent(editContent);
                                    editModal.show(target);
                                }

                                @Override
                                public boolean isVisible() {
                                    return super.isVisible() && isEditLink(rowItemModel, rowIndex);
                                }
                            };
                        } else {
                            return new Link(id) {
                                @Override
                                public void onClick() {
                                    WebMarkupContainer editContent = createEditContent(CRUDPanel.this.getId(), rowItemModel, rowIndex);
                                    CRUDPanel.this.replaceWith(editContent);
                                }

                                @Override
                                public boolean isVisible() {
                                    return super.isVisible() && isEditLink(rowItemModel, rowIndex);
                                }
                            };
                        }
                    }

                    @Override
                    protected Component newImg(String id) {
                        return new NonCachingImage(id, new ResourceReference(Application.class, "images/ico_crayon.png") {
                            @Override
                            public IResource getResource() {
                                throw new UnsupportedOperationException("Not supported yet.");
                            }
                        });
                    }
                });

                int columnWidth = getEditColumnWidth();
                if (columnWidth != -1) {
                    cellItem.add(new AttributeModifier("style", true, new Model("width:" + columnWidth + "px;")));
                }
            }

            @Override
            public String getCssClass() {
                return "aligncenter";
            }
        };
    }

    protected IColumn getDeleteLinkColumn() {
        return new HeaderlessColumn() {
            @Override
            public void populateItem(Item cellItem, String componentId, final IModel rowItemModel) {
                Item rowItem = (Item) cellItem.findParent(Item.class);
                final int rowIndex = getFirstRowItemAbsoluteIndex() + rowItem.getIndex();
                cellItem.add(new ImgLinkHolder(componentId) {
                    @Override
                    public WebMarkupContainer newLink(String id) {
                        return createDeleteLink(id, rowItemModel, rowIndex);
                    }

                    @Override
                    protected Component newImg(String id) {
                        return new NonCachingImage(id, new PackageResourceReference(MountSharedImage.class, "images/write.png"));
                    }
                });

                int columnWidth = getDeleteColumnWidth();
                if (columnWidth != -1) {
                    cellItem.add(new AttributeModifier("style", true, new Model("width:" + columnWidth + "px;")));
                }
            }

            @Override
            public String getCssClass() {
                return "aligncenter";
            }
        };
    }

    protected WebMarkupContainer createDeleteLink(String id, final IModel rowItemModel, final int index) {
        return new AjaxLink(id) {
            @Override
            public void onClick(AjaxRequestTarget target) {
                onClickDeleteLink(rowItemModel, target, index);
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
                super.updateAjaxAttributes(attributes);
                AjaxCallListener ajaxCallListener = new AjaxCallListener();
                ajaxCallListener.onPrecondition("return confirm('Remove Application?');");
                attributes.getAjaxCallListeners().add(ajaxCallListener);
            }

            

            @Override
            public boolean isVisible() {
                return super.isVisible() && isDeleteLink(rowItemModel, index);
            }
        };
    }

    protected String getConfirmMessage(IModel rowItemModel) {
        return getLocalizer().getString("confirmDelete", CRUDPanel.this);
    }

    protected int getEditColumnWidth() {
        return 16;
    }

    protected int getDeleteColumnWidth() {
        return 16;
    }

    protected boolean isUseModals() {
        return true;
    }

    protected boolean isUseModalsAddEdit() {
        return isUseModals();
    }

    protected boolean isAddLink() {
        return true;
    }

    protected boolean isEditColumn() {
        return true;
    }

    protected boolean isDeleteColumn() {
        return true;
    }

    protected boolean isEditLink(IModel rowItemModel, int index) {
        return true;
    }

    protected boolean isDeleteLink(IModel rowItemModel, int index) {
        return true;
    }

    protected void setAddLinkVisibility(Boolean isVisible) {
        this.addLink.setVisible(isVisible);
    }

    protected abstract List<IColumn> getDataColumns();

    protected abstract WebMarkupContainer createAddContent(String id);

    protected abstract WebMarkupContainer createEditContent(String id, IModel rowItemModel, int index);

    protected abstract void onClickDeleteLink(IModel rowItemModel, AjaxRequestTarget target, int index);
}
