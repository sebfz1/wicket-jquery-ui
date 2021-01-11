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
package com.googlecode.wicket.kendo.ui.datatable.column;

import com.googlecode.wicket.jquery.core.utils.BuilderUtils;
import com.googlecode.wicket.kendo.ui.datatable.DataTable;
import com.googlecode.wicket.kendo.ui.datatable.column.AbstractColumn;

/**
 * Provides a column of checkboxes for the a {@link DataTable}. 
 * Must be used with a {@link CheckboxBehavior} in order to work properly.
 * 
 * @author Haritos Hatzidimitriou
 */
public class CheckboxColumn extends AbstractColumn {

    private static final long serialVersionUID = 1L;
    
    private static final int DEFAULT_WIDTH = 43;

    /**
     * Constructor
     */
    public CheckboxColumn() {
        
        super("", DEFAULT_WIDTH);
    }
    
    /**
     * Constructor
     *
     * @param width the column width
     */
    public CheckboxColumn(int width) {
        
        super("", width);
    }
    
    @Override
    public String getAttributes() {
        
        return "{ \"class\" : \"checkbox-column\"}";
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(super.toString());
        result.append(", ");
        BuilderUtils.append(result, "selectable", true);
        return result.toString();
    }
}
