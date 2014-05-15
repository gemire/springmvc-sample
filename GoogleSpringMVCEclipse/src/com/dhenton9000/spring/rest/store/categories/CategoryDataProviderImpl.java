package com.dhenton9000.spring.rest.store.categories;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.codehaus.jackson.map.ObjectMapper;


/**
 *
 * @author dhenton
 */
public class CategoryDataProviderImpl implements CategoryDataProvider {

    private HashMap<Integer, BaseCategory> level1Data =
            new HashMap<Integer, BaseCategory>();

    public CategoryDataProviderImpl()
    {
        setData();
    }
    private void setData()
    {
        level1Data.put(1, getClothingData());
        level1Data.put(2, getElectronicData());
        level1Data.put(3, getGamesData());
        level1Data.put(4, getHomeImprovementData());
    }
       
    private String toJson(List<BaseCategory> cats) throws IOException
    {
        String t = "";
        ObjectMapper mapper = new ObjectMapper();
        t = mapper.writeValueAsString(cats);
        return t;
    }
    /**
     * *getLevelData?level=1&groupId=3
     *
     * @return the base categories for Level 1
     */
    @Override
    public List<BaseCategory> getLevel1Data() {
        ArrayList<BaseCategory> a = new ArrayList<BaseCategory>();
        
        for (Integer j: level1Data.keySet())
        {
            BaseCategory orig = level1Data.get(j);
            a.add(new BaseCategory(orig.getId(),orig.getName()));
        }
        return a;
    }

    /** I want level 2 data for level1 id of 7811
     * getLevelData?level=2&groupId=3&id=7811
     *
     * @param level1Id
     * @return
     */
    @Override
    public List<BaseCategory> getLevel2Data(Integer level1Id) {
        BaseCategory foundLevel = level1Data.get(level1Id);
        List<BaseCategory> listItems = null;
        if (foundLevel != null) {
            listItems = foundLevel.getChildren();
        } else {
            listItems = new ArrayList<BaseCategory>();
        }
        return listItems;
    }

    /**
     * '*getLevelData?level=3&groupId=3&id=43',
     *
     * @param level1Id
     * @return
     */
    @Override
    public List<BaseCategory> getLevel3Data(Integer level2Id) {
        Set<Integer> firstLevelKey = level1Data.keySet();
        BaseCategory foundLevel = null;
        for (Integer firstLevelItem : firstLevelKey) {
            BaseCategory firstCat = level1Data.get(firstLevelItem);
            for (BaseCategory secondCat : firstCat.getChildren()) {
                if (secondCat.getId().equals(level2Id)) {
                    foundLevel = secondCat;
                    break;
                }
            }
        }

        List<BaseCategory> listItems = null;
        if (foundLevel != null) {
            listItems = foundLevel.getChildren();
        } else {
            listItems = new ArrayList<BaseCategory>();
        }
        return listItems;
    }

    private BaseCategory getClothingData() {
        ArrayList<BaseCategory> data = new ArrayList<BaseCategory>();
        BaseCategory d = null;

        d = new BaseCategory();
        d.setId(201);
        d.setName("Mens");
        ArrayList<BaseCategory> data4 = new ArrayList<BaseCategory>();
        data4.add(new BaseCategory(400, "Excercise Clothes"));
        data4.add(new BaseCategory(401, "Men's Shoes"));
        data4.add(new BaseCategory(402, "Gloves"));
        data4.add(new BaseCategory(403, "Men's Sports Wear"));
        d.setChildren(data4);
        
        data.add(d);

        d = new BaseCategory();
        d.setId(202);
        d.setName("Womens");
        ArrayList<BaseCategory> data3 = new ArrayList<BaseCategory>();
        data3.add(new BaseCategory(303, "Evening Wear"));
        data3.add(new BaseCategory(304, "Womens Shoes"));
        data3.add(new BaseCategory(306, "Luxury Coats"));
        data3.add(new BaseCategory(305, "Jewelry"));
        d.setChildren(data3);
        data.add(d);

        d = new BaseCategory();
        d.setId(203);
        d.setName("Childrens");
        data3 = new ArrayList<BaseCategory>();
        data3.add(new BaseCategory(307, "Boys"));
        data3.add(new BaseCategory(308, "Girls"));
        data3.add(new BaseCategory(309, "Infants"));
        data3.add(new BaseCategory(310, "Toddlers"));
        d.setChildren(data3);

        data.add(d);
        d = new BaseCategory(1, "Clothing");
        d.setChildren(data);
        return d;
    }

    private BaseCategory getElectronicData() {
        ArrayList<BaseCategory> data = new ArrayList<BaseCategory>();
        BaseCategory d = null;
        ArrayList<BaseCategory> data3 = null;
        d = new BaseCategory();
        d.setId(204);
        d.setName("Cellphones");
        data3 = new ArrayList<BaseCategory>();
        data3.add(new BaseCategory(314, "IPhone"));
        data3.add(new BaseCategory(315, "Galaxy"));
        d.setChildren(data3);
        data.add(d);

        d = new BaseCategory();
        d.setId(205);
        d.setName("Cameras");
        data.add(d);

        d = new BaseCategory();
        d.setId(206);
        d.setName("TV/Home Entertainment");
        data3 = new ArrayList<BaseCategory>();
        data3.add(new BaseCategory(311, "Game Consoles"));
        data3.add(new BaseCategory(312, "Stereos"));
        data3.add(new BaseCategory(313, "Big Screen TV"));
        d.setChildren(data3);
        data.add(d);

        d = new BaseCategory(2, "Electronics");
        d.setChildren(data);
        return d;
    }

    private BaseCategory getGamesData() {

    	 ArrayList<BaseCategory> data = new ArrayList<BaseCategory>();
         BaseCategory d = null;
         ArrayList<BaseCategory> data3 = null;
         
         d = new BaseCategory();
         d.setId(291);
         d.setName("Childrens");
         data3 = new ArrayList<BaseCategory>();
         data3.add(new BaseCategory(391, "Board Games"));
         data3.add(new BaseCategory(392, "Outdoor Games"));
         d.setChildren(data3);
         data.add(d);
         
         d = new BaseCategory();
         d.setId(292);
         d.setName("Card Games");
         data3 = new ArrayList<BaseCategory>();
         data3.add(new BaseCategory(394, "Poker"));
         data3.add(new BaseCategory(395, "Roulette"));
         d.setChildren(data3);
         data.add(d);
         
         
         
        d = new BaseCategory(3, "Games");
        d.setChildren(data);
        return d;
    }

    private BaseCategory getHomeImprovementData() {

    	 ArrayList<BaseCategory> data = new ArrayList<BaseCategory>();
         BaseCategory d = null;
         ArrayList<BaseCategory> data3 = null;
         d = new BaseCategory();
         d.setId(271);
         d.setName("Garden");
         data3 = new ArrayList<BaseCategory>();
         data3.add(new BaseCategory(371, "Plants"));
         data3.add(new BaseCategory(372, "Lawn Fertilizer"));
         d.setChildren(data3);
         data.add(d);

         d = new BaseCategory();
         d.setId(272);
         d.setName("Electrical");
         data3 = new ArrayList<BaseCategory>();
         data3.add(new BaseCategory(376, "Lighting"));
         data3.add(new BaseCategory(377, "Space Heaters"));
      
         d.setChildren(data3);
         data.add(d);

         d = new BaseCategory();
         d.setId(273);
         d.setName("Plumbing");
         data3 = new ArrayList<BaseCategory>();
         data3.add(new BaseCategory(373, "Bath"));
         data3.add(new BaseCategory(374, "Saunas"));
         data3.add(new BaseCategory(375, "Kitchen"));
         d.setChildren(data3);
         data.add(d);

        d = new BaseCategory(4, "Home Improvement");
        d.setChildren(data);
        return d;
    }
    
    public static void main(String[] args)
    {
        CategoryDataProviderImpl c = new CategoryDataProviderImpl();
        String t = "";
        try {
            t = c.toJson(c.getLevel2Data(4));
        } catch (IOException ex) {
             System.out.println("ex "+ex.getMessage());
        }
        System.out.println("\ngot\n"+t);
    }
    
    
}
