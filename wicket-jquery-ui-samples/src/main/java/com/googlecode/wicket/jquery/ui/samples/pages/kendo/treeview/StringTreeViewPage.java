package com.googlecode.wicket.jquery.ui.samples.pages.kendo.treeview;

import java.util.Arrays;
import java.util.List;

import com.googlecode.wicket.jquery.core.Options;
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

		this.add(new TreeView<String>("treeview", newTreeViewModel(), options) {

			private static final long serialVersionUID = 1L;

			// @Override
			// protected void onConfigure(TreeViewDataSource dataSource)
			// {
			// super.onConfigure(dataSource);
			//
			// }
			//
			//// newSchemaOptions()
			//
			// @Override
			// protected TreeViewNodeFactory<String> newTreeViewNodeFactory()
			// {
			// return new TreeViewNodeFactory();
			// }
		});
	}

	private static TreeViewModel<String> newTreeViewModel()
	{
		return new TreeViewModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			protected List<String> load(String id)
			{
				System.out.println("id: " + id); // TODO remove
				return Arrays.asList("1", "2", "3");
			}
		};
	}
}
