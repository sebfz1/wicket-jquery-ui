package com.googlecode.wicket.jquery.ui.samples.pages.kendo.treeview;

import java.util.List;

import org.apache.wicket.util.lang.Generics;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeNode;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeView;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeViewModel;

public class StringTreeViewPage extends AbstractTreeViewPage
{
	private static final long serialVersionUID = 1L;

	public StringTreeViewPage()
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
				List<TreeNode<String>> list = Generics.newArrayList();
				list.add(TreeNode.of("1"));
				list.add(TreeNode.of("2"));
				list.add(TreeNode.of("3"));
				
				return list;
			}
		};
	}
}
