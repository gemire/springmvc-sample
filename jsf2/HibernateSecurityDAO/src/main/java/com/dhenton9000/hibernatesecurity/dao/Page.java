
package com.dhenton9000.hibernatesecurity.dao;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import java.util.List;


/**
 *
 * @author dyh
 */
public class Page {
  private static Logger log = LogManager.getLogger(Page.class);

  //~--- fields ---------------------------------------------------------------

  private List results;
  private int  page;
  // this is the number of items in a page eg 5 means 5 total items
  private int  pageSize;

  //~--- constructors ---------------------------------------------------------


  /**
   * Constructs ... TODO
   *
   *
   * @param query
   * @param page
   * @param countofPageItems
   */
  public Page(
      Query query,
      int page,
      int countofPageItems
  ) {
    this.page = page;
    this.pageSize = countofPageItems;
    results = query.setFirstResult(page * this.pageSize).setMaxResults(this.pageSize).list();
    log.debug("results count from page "+results.size());
  }

  //~--- methods --------------------------------------------------------------


  /**
   * Method description TODO
   *
   *
   * @return
   */
  public boolean isNextPage() {
    return !(results.size() < this.pageSize);
  }


  /**
   * Method description TODO
   *
   *
   * @return
   */
  public boolean isPreviousPage() {
    return page > 0;
  }


  /**
   * Method description TODO
   *
   *
   * @return
   */
  public List getList() {
//    return isNextPage()
//           ? results.subList(0, this.pageSize )
//           : results;
    return results;
  }
}
