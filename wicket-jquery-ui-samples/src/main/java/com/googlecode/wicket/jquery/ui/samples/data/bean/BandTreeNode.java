package com.googlecode.wicket.jquery.ui.samples.data.bean;

import com.googlecode.wicket.kendo.ui.widget.treeview.TreeNode;

public class BandTreeNode extends TreeNode<Band>
{
	private static final long serialVersionUID = 1L;

	public BandTreeNode(long countryId, Band band)
	{
		super(countryId, band);
	}

	@Override
	public String getText()
	{
		return this.getObject().getName();
	}

	@Override
	public boolean hasChildren()
	{
		return false;
	}
}
