package com.googlecode.wicket.jquery.ui.samples.data.bean;

import org.apache.wicket.util.io.IClusterable;

public abstract class TreeNode implements IClusterable
{
	private static final long serialVersionUID = 1L;
	private static int sequence = 0;

	private final long id;

	public TreeNode()
	{
		this(++sequence);
	}

	public TreeNode(long id)
	{
		this.id = id;
	}
	
	public long getId()
	{
		return id;
	}

	public static class Country extends TreeNode
	{
		private static final long serialVersionUID = 1L;

		private final String name;

		public Country(String name)
		{
			this.name = name;
		}

		public String getName()
		{
			return name;
		}

		@Override
		public String toString()
		{
			return this.getName();
		}
	}

	public static class Band extends TreeNode
	{
		private static final long serialVersionUID = 1L;

		private final String name;
		private final String desc;
		private final long countryId;

		public Band(long countryId, String name, String desc)
		{
			this.countryId = countryId;
			this.name = name;
			this.desc = desc;
		}
		
		public long getCountryId()
		{
			return this.countryId;
		}

		public String getName()
		{
			return this.name;
		}

		public String getDesc()
		{
			return this.desc;
		}
		
		@Override
		public String toString()
		{
			return this.getName();
		}
	}
}
