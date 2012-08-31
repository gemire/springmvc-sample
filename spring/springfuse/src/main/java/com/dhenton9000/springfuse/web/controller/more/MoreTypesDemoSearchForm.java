/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/controller/SearchForm.e.vm.java
 */
package com.dhenton9000.springfuse.web.controller.more;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dhenton9000.springfuse.dao.support.DateRange;
import com.dhenton9000.springfuse.web.util.DateRangeUtil;
import com.dhenton9000.springfuse.domain.more.MoreTypesDemo;
import com.dhenton9000.springfuse.web.util.SearchForm;
import com.dhenton9000.springfuse.web.util.NullRestriction;

public class MoreTypesDemoSearchForm extends SearchForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private MoreTypesDemo moreTypesDemo = new MoreTypesDemo();

    /**
     * The MoreTypesDemo instance used as an example.
     */
    public MoreTypesDemo getMoreTypesDemo() {
        return moreTypesDemo;
    }

    //------------------------
    // support for date ranges
    //------------------------    
    private DateRangeUtil dateJavaTemporalDateRange = new DateRangeUtil("dateJavaTemporalDate");
    private DateRangeUtil dateJavaTemporalTimestampRange = new DateRangeUtil("dateJavaTemporalTimestamp");
    private DateRangeUtil dateJodaRange = new DateRangeUtil("dateJoda");
    private DateRangeUtil dateTimeJodaRange = new DateRangeUtil("dateTimeJoda");

    /**
     * The {@link DateRangeUtil} for the dateJavaTemporalDate attribute.
     */
    public DateRangeUtil getDateJavaTemporalDateRange() {
        return dateJavaTemporalDateRange;
    }

    /**
     * The {@link DateRangeUtil} for the dateJavaTemporalTimestamp attribute.
     */
    public DateRangeUtil getDateJavaTemporalTimestampRange() {
        return dateJavaTemporalTimestampRange;
    }

    /**
     * The {@link DateRangeUtil} for the dateJoda attribute.
     */
    public DateRangeUtil getDateJodaRange() {
        return dateJodaRange;
    }

    /**
     * The {@link DateRangeUtil} for the dateTimeJoda attribute.
     */
    public DateRangeUtil getDateTimeJodaRange() {
        return dateTimeJodaRange;
    }

    @Override
    protected List<DateRange> getDateRanges() {
        List<DateRange> result = new ArrayList<DateRange>();
        result.add(getDateJavaTemporalDateRange());
        result.add(getDateJavaTemporalTimestampRange());
        result.add(getDateJodaRange());
        result.add(getDateTimeJodaRange());
        return result;
    }

    @Override
    public List<NullRestriction> getNullRestrictions() {
        List<NullRestriction> result = new ArrayList<NullRestriction>();
        return result;
    }
}