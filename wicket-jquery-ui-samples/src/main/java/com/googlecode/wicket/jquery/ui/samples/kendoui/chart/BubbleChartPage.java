package com.googlecode.wicket.jquery.ui.samples.kendoui.chart;

import java.util.List;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.util.io.IClusterable;
import org.apache.wicket.util.lang.Generics;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.core.utils.ListUtils;
import com.googlecode.wicket.kendo.ui.dataviz.chart.Chart;
import com.googlecode.wicket.kendo.ui.dataviz.chart.series.BubbleSeries;
import com.googlecode.wicket.kendo.ui.dataviz.chart.series.Series;

public class BubbleChartPage extends AbstractChartPage // NOSONAR
{
	private static final long serialVersionUID = 1L;

	public BubbleChartPage()
	{
		// Chart //
		this.add(new MyChart("chart"));
	}

	// statics //

	static List<MyBubble> randomAreas()
	{
		List<MyBubble> data = Generics.newArrayList();

		for (int i = 0; i < 25; i++)
		{
			int x = ListUtils.random(1000);
			int y = ListUtils.random(10000);
			int size = ListUtils.random(100000);

			data.add(new MyBubble("category #" + i, x, y, size));
		}

		return data;
	}

	// classes //

	static class MyChart extends Chart<MyBubble> // NOSONAR
	{
		private static final long serialVersionUID = 1L;

		public MyChart(String id)
		{
			super(id, newModel(), newSeries(), newOptions());
		}

		static IModel<List<MyBubble>> newModel()
		{
			return new LoadableDetachableModel<List<MyBubble>>() {

				private static final long serialVersionUID = 1L;

				@Override
				protected List<MyBubble> load()
				{
					return randomAreas();
				}
			};
		}

		static List<Series> newSeries()
		{
			List<Series> series = Generics.newArrayList();
			series.add(new BubbleSeries(MyBubble.FIELD_CATEGORY, MyBubble.FIELD_X, MyBubble.FIELD_Y, MyBubble.FIELD_SIZE));

			return series;
		}

		static Options newOptions()
		{
			Options options = new Options();
			options.set("title", "{ text: 'Sample Area Chart' }");
			options.set("tooltip", "{ visible: true, format: '{3}: {2:n0}' }");

			return options;
		}
	}

	public static class MyBubble implements IClusterable
	{
		private static final long serialVersionUID = 1L;
		public static final String FIELD_X = "x"; // xField
		public static final String FIELD_Y = "y"; // yField
		public static final String FIELD_SIZE = "size"; // sizeField
		public static final String FIELD_CATEGORY = "category"; // category

		private final int x;
		private final int y;
		private final int size;
		private final String category;

		public MyBubble(String category, int x, int y, int size)
		{
			this.x = x;
			this.y = y;
			this.size = size;
			this.category = category;
		}

		public int getX()
		{
			return x;
		}

		public int getY()
		{
			return y;
		}

		public int getSize()
		{
			return size;
		}

		public String getCategory()
		{
			return this.category;
		}
	}
}
