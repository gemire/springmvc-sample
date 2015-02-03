
package com.dhenton9000.hibernateWeb.backing;

import com.dhenton9000.hibernatesecurity.Users;
import com.dhenton9000.hibernatesecurity.Utils;
import com.dhenton9000.hibernatesecurity.dao.DataAccessLayerException;
import com.dhenton9000.hibernatesecurity.dao.Page;
 
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author dyh
 */
public class UsersBackingBean extends BaseBean {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6289152958136347335L;
	private static Logger log = LogManager.getLogger(UsersBackingBean.class);
    //~--- fields ---------------------------------------------------------------
    Page currentPage = null;
    private DataModel currentDataModel = null;
    private final int batchSize = 7;
    private int firstItem = 0;
    private boolean hasPreviousPage = false;
    private boolean hasNextPage = true;
    private int userCount = 0;
    Users currentUser = new Users();
    private boolean editMode = false;
    private boolean deleteMode = false;
    private boolean addMode = true; // default mode

    //~--- constructors ---------------------------------------------------------
    /**
     * Constructs ... TODO
     *
     */
    public UsersBackingBean() {
        log.debug("table data constructor");

        // getAllUsers();
         
    }

    //~--- methods --------------------------------------------------------------
    /**
     * Method description TODO
     *
     *
     * @return
     */
    public String nextUser() {
        if (getFirstItem() + getBatchSize() < getUsersCount()) {
            setFirstItem(getFirstItem() + getBatchSize());
            setUserCount(getUserCount() + 1);
            log.debug("first item " + getFirstItem());
        }

        int targetCount = getFirstItem() + getBatchSize();

        if (targetCount >= getUsersCount()) {
            setHasNextPage(false);
            setHasPreviousPage(true);
        } else {
            setHasNextPage(true);
            setHasPreviousPage(true);
        }

        return null;
    }

    /**
     * Method description TODO
     *
     *
     * @return
     */
    public String prevUser() {
        firstItem -= batchSize;

        if (firstItem < 0) {
            firstItem = 0;
        }

        userCount--;

        if (userCount < 0) {
            userCount = 0;
        }

        if (firstItem == 0) {
            setHasNextPage(true);
            setHasPreviousPage(false);
        } else {
            setHasNextPage(true);
            setHasPreviousPage(true);
        }

        return null;
    }

    /**
     * Method description TODO
     *
     *
     * @return
     */
    public DataModel getAllUsers() {
        log.debug("getUsers");

        recalcData();


        return currentDataModel;
    }

    private void recalcData() {
         
        try {
            currentPage = this.getSecurityService().getPageOfDataForClass(Users.class, getUserCount(), getBatchSize());
        } catch (DataAccessLayerException ex) {

            log.error("recalcData() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);

        }
        log.debug("getting recalc with first item " + getFirstItem() + " batch size " + getBatchSize());
        currentDataModel = new ListDataModel(currentPage.getList());
        log.debug("row count is " + currentDataModel.getRowCount());

        // setHasNextPage(currentPage.isNextPage());
        // setHasPreviousPage(currentPage.isPreviousPage());
    }

    /**
     * @return the firstItem
     */
    public int getFirstItem() {
        return firstItem;
    }

    /**
     * @param firstItem the firstItem to set
     */
    public void setFirstItem(
            int firstItem) {
        this.firstItem = firstItem;
    }

    /**
     * @return the batchSize
     */
    public int getBatchSize() {
        return batchSize;
    }

    /**
     * @return the itemCount
     */
    public int getUsersCount() {
        
        Long itemCount = null;
        try {
            log.debug("in getUsersCount");
            itemCount = this.getSecurityService().getCountForClass(Users.class);
        } catch (DataAccessLayerException ex) {
            log.error("getAllUsers() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);
        }

        return itemCount.intValue();
    }

    /**
     * Method description TODO
     *
     *
     * @return
     */
    public int getLastItem() {
        return firstItem + batchSize;
    }

    /**
     * @return the hasNextPage
     */
    public boolean isHasNextPage() {
        return hasNextPage;
    }

    /**
     * @param hasNextPage the hasNextPage to set
     */
    public void setHasNextPage(
            boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    /**
     * @return the hasPreviousPage
     */
    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    /**
     * @param hasPreviousPage the hasPreviousPage to set
     */
    public void setHasPreviousPage(
            boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    /**
     * @return the userCount
     */
    public int getUserCount() {
        return userCount;
    }

    /**
     * @param userCount the userCount to set
     */
    public void setUserCount(
            int userCount) {
        this.userCount = userCount;
    }

    /**
     * Method description TODO
     *
     *
     * @return
     */
    public String setUpEdit() {
        currentUser = (Users) currentDataModel.getRowData();
        setDeleteMode(false);
        setEditMode(true);
        setAddMode(false);
        return null;
    }

    /**
     * Method description TODO
     *
     *
     * @return
     */
    public String setUpDelete() {
        currentUser = (Users) currentDataModel.getRowData();
        setDeleteMode(true);
        setEditMode(false);
        setAddMode(false);
        return null;
    }

    /**
     * Method description TODO
     *
     *
     * @return
     */
    public Users getCurrentUser() {
        return currentUser;
    }

    public void resetToAddMode() {
        log.debug("hit reset ");
        setDeleteMode(false);
        setEditMode(false);
        setAddMode(true);
        resetCounters();
        recalcData();
    }

    public void resetCounters() {
        firstItem = 0;
        hasPreviousPage = false;
        hasNextPage = true;
        userCount = 0;
        currentUser = new Users();
        currentPage = null;
    }

    public void performDelete() {
        
        try {
            this.getSecurityService().delete(currentUser);
            resetToAddMode();
        } catch (DataAccessLayerException e) {
            String t = "User " + currentUser.getUsername() + " has child records. Delete those first";
            addFacesMessage(t);
            log.error(t);
        }

    }

    public void performEdit() {

        performAddUpdate(true);
    }

    public void performAdd( ) {
      performAddUpdate(false);
    }
    private void performAddUpdate(boolean isUpdate) {


         
        try {
            String uId = currentUser.getUserId();
            if (currentUser.getUsername() == null
                    || currentUser.getUsername().trim().length() == 0) {
                this.addFacesMessage("User name cannot be empty");
                return;
            }

            if (uId == null
                    || uId.trim().length() == 0) {
                this.addFacesMessage("User id cannot be empty");
                return;
            }


            if (isUpdate)
                this.getSecurityService().saveOrUpdate(currentUser);
            else
                this.getSecurityService().save(currentUser);
        } catch (DataAccessLayerException ex) {
            log.error("performAdd() " + Utils.createErrorMessage(ex));
            addFacesErrorMessage(ex);
        }

        resetToAddMode();
    }

    /**
     * @return the editMode
     */
    public boolean isEditMode() {
        return editMode;
    }

    /**
     * @param editMode the editMode to set
     */
    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    /**
     * @return the deleteMode
     */
    public boolean isDeleteMode() {
        return deleteMode;
    }

    /**
     * @param deleteMode the deleteMode to set
     */
    public void setDeleteMode(boolean deleteMode) {
        this.deleteMode = deleteMode;
    }

    /**
     * @return the addMode
     */
    public boolean isAddMode() {
        return addMode;
    }

    /**
     * @param addMode the addMode to set
     */
    public void setAddMode(boolean addMode) {
        this.addMode = addMode;
    }
}
