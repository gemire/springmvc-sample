package com.dhenton9000.spring.rest.store.categories;

  

import java.util.List;

/**
 *
 * @author dhenton
 */
public interface CategoryDataProvider {

    /**
     * *getLevelData?level=1&groupId=3
     *
     * @return the base categories for Level 1
     */
    List<BaseCategory> getLevel1Data();

    /**
     * getLevelData?level=2&groupId=3&id=7811
     *
     * @param level1Id
     * @return
     */
    List<BaseCategory> getLevel2Data(Integer level1Id);

    /**
     * '*getLevelData?level=3&groupId=3&id=43',
     *
     * @param level1Id
     * @return
     */
    List<BaseCategory> getLevel3Data(Integer level2Id);
    
}