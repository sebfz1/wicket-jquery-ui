package com.googlecode.wicket.kendo.ui.widget.treeview;

import org.apache.wicket.Page;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.io.IClusterable;

public class TreeNode<T> implements IClusterable
{
	private static final long serialVersionUID = 1L;
	private static final long ROOT = 0;

	private static int sequence = 1;

	private final long uid;
	private final long pid;
	private final T wrapped;

	public TreeNode(T object)
	{
		this(ROOT, object);
	}

	public TreeNode(long parentId, T object)
	{
		this.uid = nextSequence();
		this.pid = parentId;
		this.wrapped = object;
	}

	public long getId()
	{
		return uid;
	}

	public long getParentId()
	{
		return this.pid;
	}

	public String getText()
	{
		return String.valueOf(this.wrapped);
	}

	/**
	 * Gets the next id-sequence. This is used to generate the markupId
	 *
	 * @return 0x00000000 to 0x7FFFFFFF
	 */
	private static synchronized int nextSequence()
	{
		return TreeNode.sequence++ % Integer.MAX_VALUE;
	}

	public static <T> TreeNode<T> of(T object)
	{
		return new TreeNode<T>(object);
	}
	
	// Children Classes //

	public static class UrlTreeNode<T> extends TreeNode<T>
	{
		private static final long serialVersionUID = 1L;
		private final CharSequence url;

		public UrlTreeNode(T object, CharSequence url)
		{
			super(object);

			this.url = url;
		}

		public UrlTreeNode(T object, Class<? extends Page> pageClass)
		{
			this(object, pageClass, new PageParameters());
		}

		public UrlTreeNode(T object, Class<? extends Page> pageClass, PageParameters parameters)
		{
			this(object, RequestCycle.get().urlFor(pageClass, parameters));
		}

		public UrlTreeNode(long parentId, T object)
		{
			this(parentId, object, (CharSequence) null);
		}

		public UrlTreeNode(long parentId, T object, CharSequence url)
		{
			super(parentId, object);

			this.url = url;
		}

		public UrlTreeNode(long parentId, T object, Class<? extends Page> pageClass)
		{
			this(parentId, object, pageClass, new PageParameters());
		}

		public UrlTreeNode(long parentId, T object, Class<? extends Page> pageClass, PageParameters parameters)
		{
			this(parentId, object, RequestCycle.get().urlFor(pageClass, parameters));
		}

		public CharSequence getUrl()
		{
			return this.url;
		}
	}
}
