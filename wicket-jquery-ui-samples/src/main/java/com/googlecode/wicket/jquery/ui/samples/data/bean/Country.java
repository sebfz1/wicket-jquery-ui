package com.googlecode.wicket.jquery.ui.samples.data.bean;

import org.apache.wicket.util.io.IClusterable;

public class Country implements IClusterable
{
	private static final long serialVersionUID = 1L;

	private final String id;
	private final String name;

	public Country(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}
}
