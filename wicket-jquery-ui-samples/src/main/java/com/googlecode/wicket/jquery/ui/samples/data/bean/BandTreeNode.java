package com.googlecode.wicket.jquery.ui.samples.data.bean;

import com.googlecode.wicket.kendo.ui.widget.treeview.TreeNode;

public class BandTreeNode extends TreeNode<String>
{
	private static final long serialVersionUID = 1L;

	public BandTreeNode(long countryId, String name, String description)
	{
		super(countryId, name);
		
		//TODO description
	}
}
