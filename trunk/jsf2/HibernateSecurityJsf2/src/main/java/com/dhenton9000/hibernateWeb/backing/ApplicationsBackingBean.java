
package com.dhenton9000.hibernateWeb.backing;

import com.dhenton9000.hibernatesecurity.Applications;
import com.dhenton9000.hibernatesecurity.Utils;
import com.dhenton9000.hibernatesecurity.dao.DataAccessLayerException;
import com.dhenton9000.hibernatesecurity.dao.Page;
import com.dhenton9000.hibernatesecurity.dao.SecurityDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author dyh
 */
public class ApplicationsBackingBean extends BaseBean {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8744404196716188384L;
	private static Logger log = LogManager.getLogger(ApplicationsBackingBean.class);
    //~--- fields ---------------------------------------------------------------
    Page currentPage = null;
    private DataModel currentDataModel = null;
    private final int batchSize = 7;
    private int firstItem = 0;
    private boolean hasPreviousPage = false;
    private boolean hasNextPage = true;
    private int groupCount = 0;
    Applications currentApp = new Applications();
    private boolean editMode = false;
    private boolean deleteMode = false;
    private boolean addMode = true; // default mode

    //~--- constructors ---------------------------------------------------------
    /**
     * Constructs ... TODO
     *
     */
    public ApplicationsBackingBean() {
        log.debug("table data constructor");

        // getAllApplications();
    }

    //~--- methods --------------------------------------------------------------
    /**
     * Method description TODO
     *
     *
     * @return
     */
    public String nextApplication() {
        if (getFirstItem() + getBatchSize() < getApplicationsCount()) {
            setFirstItem(getFirstItem() + getBatchSize());
            setGroupCount(getGroupCount() + 1);
            log.debug("first item " + getFirstItem());
        }

        int targetCount = getFirstItem() + getBatchSize();

        if (targetCount >= getApplicationsCount()) {
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
    public String prevApplication() {
        firstItem -= batchSize;

        if (firstItem < 0) {
            firstItem = 0;
        }

        groupCount--;

        if (groupCount < 0) {
            groupCount = 0;
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
    public DataModel getAllApplications() {
        log.debug("getApp");

        recalcData();


        return currentDataModel;
    }

    private void recalcData() {
        SecurityDAO dInfo = SecurityDAO.getInstance();
        try {
            currentPage = dInfo.getPageOfDataForClass(Applications.class, getGroupCount(), getBatchSize());
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
    public int getApplicationsCount() {
        SecurityDAO dInfo = SecurityDAO.getInstance();
        Long itemCount = null;
        try {
            itemCount = dInfo.getCountForClass(Applications.class);
        } catch (DataAccessLayerException ex) {
            log.error("getAllApplications() " + Utils.createErrorMessage(ex));
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
     * @return the groupCount
     */
    public int getGroupCount() {
        return groupCount;
    }

    /**
     * @param groupCount the groupCount to set
     */
    public void setGroupCount(
            int groupCount) {
        this.groupCount = groupCount;
    }

    /**
     * Method description TODO
     *
     *
     * @return
     */
    public String setUpEdit() {
        currentApp = (Applications) currentDataModel.getRowData();
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
        currentApp = (Applications) currentDataModel.getRowData();
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
    public Applications getCurrentApp() {
        return currentApp;
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
        groupCount = 0;
        currentApp = new Applications();
        currentPage = null;
    }

    public void performDelete() {
        SecurityDAO dInfo = SecurityDAO.getInstance();
        try {
            dInfo.delete(currentApp);
            resetToAddMode();
        } catch (DataAccessLayerException e) {
            String t = "Application " + currentApp.getApplicationName() + " has child records. Delete those first";
            addFacesMessage(t);
            log.error(t);
        }

    }

    public void performEdit() {

        performAdd();
    }

    public void performAdd() {


        SecurityDAO dInfo = SecurityDAO.getInstance();
        try {
            Integer q = currentApp.getId();
            if (currentApp.getApplicationName() == null
                    || currentApp.getApplicationName().trim().length() == 0) {
                this.addFacesMessage("Application name cannot be empty");
                return;
            }

            dInfo.saveOrUpdate(currentApp);
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
