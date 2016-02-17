package com.googlecode.wicket.jquery.ui.samples.pages.kendo.treeview;

import java.util.List;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.ui.samples.data.bean.TreeNode;
import com.googlecode.wicket.jquery.ui.samples.data.dao.BandsDAO;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeNodeFactory;
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

		this.add(new TreeView<TreeNode>("treeview", newTreeViewModel(), options) {

			private static final long serialVersionUID = 1L;

			@Override
			protected TreeNodeFactory<TreeNode> newTreeNodeFactory()
			{
				return new TreeNodeFactory<TreeNode>() {

					private static final long serialVersionUID = 1L;
					
					@Override
					protected long getId(TreeNode object)
					{
						return object.getId();
					}

					@Override
					protected String getText(TreeNode object)
					{
						return object.toString();
					}
				};
			}
		});
	}

	private static TreeViewModel<TreeNode> newTreeViewModel()
	{
		return new TreeViewModel<TreeNode>() {

			private static final long serialVersionUID = 1L;

			@Override
			protected List<TreeNode> load(long id)
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
