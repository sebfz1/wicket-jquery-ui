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
package com.googlecode.wicket.kendo.ui.dataviz.chart.series;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.ajax.json.JSONString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a {@value #TYPE} series object
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
public class BubbleSeries extends Series implements JSONString
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BubbleSeries.class);
	private static final String TYPE = "bubble";

	private final String xField;
	private final String yField;
	private final String sizeField;
	private final String categoryField;

	/**
	 * Constructor
	 * 
	 * @param categoryField the high field
	 * @param xField the open field
	 * @param yField the close field
	 * @param sizeField the low field
	 */
	public BubbleSeries(String categoryField, String xField, String yField, String sizeField)
	{
		super(null, TYPE);

		this.xField = xField;
		this.yField = yField;
		this.sizeField = sizeField;
		this.categoryField = categoryField;
	}

	/**
	 * Gets the 'size' field
	 * 
	 * @return the 'size' field
	 */
	public String getSizeField()
	{
		return this.sizeField;
	}

	/**
	 * Gets the 'size' field
	 * 
	 * @return the 'size' field
	 */
	public String getCategoryField()
	{
		return this.categoryField;
	}

	/**
	 * Return the JSON representation of this object<br>
	 * This needs to be done manually because of the xField and yField that are not properly converted (camel case issue)
	 * 
	 * @return the JSON string
	 */
	@Override
	public String toJSONString()
	{
		JSONObject object = new JSONObject(this);

		try
		{
			object.put("xField", this.xField);
			object.put("yField", this.yField);
		}
		catch (JSONException e)
		{
			log.error(e.getMessage(), e);
		}

		return object.toString();
	}
}
