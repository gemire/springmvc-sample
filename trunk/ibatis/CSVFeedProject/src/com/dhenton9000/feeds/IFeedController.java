/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.feeds;

/**
 * An interface that represents a FeedController. These is the main
 * boss class for generating feeds. 
 * @author Don
 */
public interface IFeedController {

    public void createFeed() throws FeedException;
    public String getFullFileLocation();
    public String getDescription();
}
