package com.googlecode.wicket.kendo.ui.datatable.checkbox;

import com.googlecode.wicket.kendo.ui.datatable.behavior.DataBoundBehavior;

/**
 * Check the checkbox when clicking the row. Table ID must be provided or it should equal 'dataTable'.
 * 
 * @author Haritos Hatzidimitriou
 */
public class SelectRowOnClickBehavior extends DataBoundBehavior {

    private static final long serialVersionUID = 1L;
    
    private final String tableID;
    
    /**
     * Constructor
     */
    public SelectRowOnClickBehavior() { 
        
        this.tableID = "dataTable";
    }
    
    /**
     * Constructor 
     * 
     * @param tableID the table ID
     */
    public SelectRowOnClickBehavior(String tableID) { 
        
        this.tableID = tableID;
    }
    
    @Override
    protected String getDataBoundCallback() {

        return "function(e) { "+

               "    function onKendoClick(e) {" +
               "        if ($(e.target).hasClass('k-checkbox-label') || $(e.target).hasClass('k-button')) {" +
               "             return;" +
               "        }" +
               "        var row = $(e.target).closest('tr');" +
               "        var checkbox = $(row).find('.k-checkbox');" +
               "        checkbox.click();" +
               "    };"+
               
               "    var grid = jQuery('#" + tableID + "').data('kendoGrid');" +
               "    var rows = grid.tbody.find(\"[role='row']\");"  + 
               "    rows.unbind('click');" + 
               "    rows.on('click', onKendoClick)" +
               "}";
    }
}
