/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernateWeb.backing;

import com.dhenton9000.hibernatesecurity.GroupAssignments;
import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.Groups;
import com.dhenton9000.hibernatesecurity.Users;
import com.dhenton9000.hibernatesecurity.Utils;
import com.dhenton9000.hibernatesecurity.dao.DataAccessLayerException;
import com.dhenton9000.hibernatesecurity.dao.SecurityDAO;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dyh
 */
public class GroupAssignmentsBackingBean extends BaseBean {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6304825860935837169L;
	private static Logger log = LogManager.getLogger(GroupAssignmentsBackingBean.class);
    private int selectedGroup = 0;
    private SelectItem[] groupItems = null;
    private DataModel currentAvailableUsers = null;
    private DataModel currentUsers = null;

    public GroupAssignmentsBackingBean() {
        if (groupItems == null) {
            SecurityDAO dInfo = SecurityDAO.getInstance();
            try {
                List list = dInfo.findAll(Groups.class);
                groupItems = new SelectItem[list.size() + 1];
                groupItems[0] = new SelectItem("0", "--Select  Group--");
                for (int j = 0; j < list.size(); j++) {
                    Groups a = (Groups) list.get(j);
                    groupItems[j + 1] = new SelectItem(a.getId() + "", a.getGroupName());
                }

                setSelectedGroup(0);
            } catch (DataAccessLayerException ex) {

                log.error("constructor problem " + Utils.createErrorMessage(ex));
                addFacesErrorMessage(ex);

            }
        }
    }

    public DataModel getAvailableUsers() {

        return currentAvailableUsers;
    }

    public void groupChanged(ValueChangeEvent valueChangeEvent) {

        String t = valueChangeEvent.getNewValue().toString();
        this.selectedGroup = Integer.parseInt(t);
        recalcUsers();
        recalcAvailableUsers();
    }

    private void recalcAvailableUsers() {
        SecurityDAO dInfo = SecurityDAO.getInstance();
        List userData = null;
        if (selectedGroup == 0) {
            return;
        }

        try {
            userData = dInfo.getAvailableUsersForGroups(selectedGroup);
        } catch (DataAccessLayerException ex) {

            log.error("getAvailableUsers() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);

        }
        currentAvailableUsers = new ListDataModel(userData);


    }

    public void recalcUsers() {
        SecurityDAO dInfo = SecurityDAO.getInstance();
        List userData = null;
        if (selectedGroup == 0) {
            return;
        }
        try {
            userData = dInfo.getUsersForGroups(selectedGroup);
        } catch (DataAccessLayerException ex) {

            log.error("getUsers() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);

        }
        currentUsers = new ListDataModel(userData);



    }

    public DataModel getUsers() {

        return currentUsers;


    }

    /**
     * @return the selectedGroup
     */
    public int getSelectedGroup() {
        return selectedGroup;
    }

    /**
     * @param selectedGroup the selectedGroup to set
     */
    public void setSelectedGroup(int selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    /**
     * @return the groupItems
     */
    public SelectItem[] getGroupItems() {
        return groupItems;
    }

    public void doDeleteAction(ActionEvent e) {
        log.debug("action event called " + e.getComponent().toString());
        Users u = null;
        DataModel uModel = getUsers();

        if (uModel == null) {
            return;
        }


        Groups gg = null;
        if (this.getSelectedGroup() == 0) {
            return;
        }

        SecurityDAO dInfo = SecurityDAO.getInstance();
        u = (Users) uModel.getRowData();
        try {
            gg = (Groups) dInfo.find(Groups.class, new Integer(this.getSelectedGroup()));
            String uId = u.getUserId();
            int gId = gg.getId();
            dInfo.deleteGroupAssignment(gId, uId);
            recalcAvailableUsers();
            recalcUsers();
        } catch (DataAccessLayerException ex) {

            log.error("dodeleteaction() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);
            return;

        }

    }

    public void doAssign() {
        DataModel gModel = getAvailableUsers();
        Users g = null;
        Groups aa = null;
        if (this.getSelectedGroup() == 0) {
            return;
        }
        if (gModel != null) {
            SecurityDAO dInfo = SecurityDAO.getInstance();
            g = (Users) gModel.getRowData();
            GroupAssignments aG = new GroupAssignments();
            try {
                aa = (Groups) dInfo.find(Groups.class, new Integer(this.getSelectedGroup()));
                aG.setGroups(aa);
                aG.setUsers(g);
                dInfo.saveOrUpdate(aG);
                recalcAvailableUsers();
                recalcUsers();
            } catch (DataAccessLayerException ex) {

                log.error("doAssign() " + Utils.createErrorMessage(ex));
                addFacesErrorMessage(ex);
                return;

            }


        }

    }
}
