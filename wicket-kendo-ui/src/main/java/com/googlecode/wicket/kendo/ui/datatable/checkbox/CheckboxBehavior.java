/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.kendo.ui.datatable.checkbox;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

import com.googlecode.wicket.jquery.core.JQueryEvent;
import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.core.ajax.JQueryAjaxBehavior;
import com.googlecode.wicket.kendo.ui.ajax.OnCheckedAjaxBehavior;
import com.googlecode.wicket.kendo.ui.datatable.DataTableBehavior;
import com.googlecode.wicket.kendo.ui.datatable.column.IColumn;

/**
 * Extension of the default behavior to support the checkbox 'onChecked' event
 * 
 * @author Haritos Hatzidimitriou
 */
public abstract class CheckboxBehavior extends DataTableBehavior {
    
    private static final long serialVersionUID = 1L;
    
    private static final String ON_CHANGE_EVENT = "change";
    
    private final JQueryAjaxBehavior onCheckedAjaxBehavior;
    private final CheckboxListener listener;
    
    /**
     * Constructor
     *
     * @param selector the html selector (ie: "#myId")
     * @param columns the list of {@link IColumn}
     * @param listener the {@link CheckboxListeners}
     */
    public CheckboxBehavior(String selector, IModel<List<IColumn>> columns, CheckboxListener listener) {
        
        this(selector, new Options(), columns, listener);
    }
    
    /**
     * Constructor
     * 
     * @param selector the html selector (ie: "#myId")
     * @param options the {@link Options}
     * @param columns the list of {@link IColumn}
     * @param listener the {@link CheckboxListener}
     */
    public CheckboxBehavior(String selector, Options options, IModel<List<IColumn>> columns, CheckboxListener listener) {
     
        super(selector, options, columns, listener);
        
        this.listener = listener;
        this.onCheckedAjaxBehavior = new OnCheckedAjaxBehavior(this);
    }

    @Override
    public void onConfigure(Component component) {
        
        super.onConfigure(component);

        this.setOption(ON_CHANGE_EVENT, this.onCheckedAjaxBehavior.getCallbackFunction());
    }
    
    @Override
    public void bind(Component component) {
        
        super.bind(component);
        
        component.add(this.onCheckedAjaxBehavior);
    }
        
    @Override
    public void onAjax(AjaxRequestTarget target, JQueryEvent event) {
        
        if (event instanceof CheckboxEvent) {
            CheckboxEvent e = (CheckboxEvent) event;
            this.listener.onChecked(target, e.getSelectedLines());
        } else {
            super.onAjax(target, event);
        }
    }
}
