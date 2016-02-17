package com.googlecode.wicket.jquery.ui.samples.pages.kendo.treeview;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeView;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeViewModel;
import com.googlecode.wicket.kendo.ui.widget.treeview.TreeViewNodeFactory;

public class CustomTreeViewPage extends AbstractTreeViewPage
{
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CustomTreeViewPage.class);

	public CustomTreeViewPage()
	{
		Options options = new Options();
		options.set("animation", false);
		options.set("select", "function(e) { e.preventDefault(); }");

		this.add(new TreeView<Object>("treeview", newTreeViewModel(), options) {

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
			@Override
			protected TreeViewNodeFactory<Object> newTreeViewNodeFactory()
			{
				return new TreeViewNodeFactory<Object>() {

					private static final long serialVersionUID = 1L;
					
					@Override
					public JSONObject toJson(int index, Object object)
					{
						try
						{
							JSONObject json = new JSONObject();

							if (object != null)
							{
								json.put(ID_FIELD, object.hashCode());
								json.put(TEXT_FIELD, object.toString());
							}

							return json;
						}
						catch (JSONException e)
						{
							LOG.error(e.getMessage(), e);
						}

						return null;
					}
				};
			}
		});
	}

	private static TreeViewModel<Object> newTreeViewModel()
	{
		return new TreeViewModel<Object>() {

			private static final long serialVersionUID = 1L;

			@Override
			protected List<Object> load(String id)
			{
				System.out.println("id: " + id); // TODO remove
				return Arrays.asList("1", "2", "3");
			}
		};
	}
}
