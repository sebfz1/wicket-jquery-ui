package com.googlecode.wicket.jquery.ui.samples.pages.kendo.treeview;

import java.util.List;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.ui.samples.data.dao.BandsDAO;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeNode;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeView;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeViewModel;

public class CustomTreeViewPage extends AbstractTreeViewPage
{
	private static final long serialVersionUID = 1L;

	public CustomTreeViewPage()
	{
		Options options = new Options();
		options.set("animation", false);
		options.set("select", "function(e) { e.preventDefault(); }");

		this.add(new TreeView<String>("treeview", newTreeViewModel(), options));
	}

	private static TreeViewModel<String> newTreeViewModel()
	{
		return new TreeViewModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			protected List<? extends TreeNode<String>> load(long id)
			{
				if (id != 0)
				{
					return BandsDAO.bands(id);
				}

				return BandsDAO.countries();
			}
		};
	}
}
