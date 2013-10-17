/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.wicket.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;


/**
 *
 * @author dhenton
 */
@Service
public class SlowServiceImpl implements ISlowService {

    private static final int DELAY = 2;

    @Override
    public String slowServiceCall(String info) {
        String myInfo = "Slow " + info;

        final CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await(DELAY, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
        }


        return myInfo;
    }
}
