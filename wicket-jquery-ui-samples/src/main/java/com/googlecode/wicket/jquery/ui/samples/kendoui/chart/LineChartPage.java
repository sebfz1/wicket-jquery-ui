package com.googlecode.wicket.jquery.ui.samples.kendoui.chart;

import java.util.List;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.util.io.IClusterable;
import org.apache.wicket.util.lang.Generics;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.core.utils.ListUtils;
import com.googlecode.wicket.kendo.ui.dataviz.chart.Chart;
import com.googlecode.wicket.kendo.ui.dataviz.chart.series.LineSeries;
import com.googlecode.wicket.kendo.ui.dataviz.chart.series.Series;

public class LineChartPage extends AbstractChartPage // NOSONAR
{
	private static final long serialVersionUID = 1L;

	public LineChartPage()
	{
		// Chart //
		this.add(new MyChart("chart"));
	}

	// statics //

	static List<MyLine> randomLines()
	{
		List<MyLine> data = Generics.newArrayList();

		Double value1 = null;
		Double value2 = null;

		for (int i = 1; i <= 25; i++)
		{
			// smooth lines
			value1 = value1 != null ? value1 + ListUtils.random(-5, 10) : ListUtils.random(25, 75);
			value2 = value2 != null ? value2 + ListUtils.random(-5, 10) : ListUtils.random(25, 75);

			data.add(new MyLine("#" + i, value1, value2));
		}

		return data;
	}

	// classes //

	static class MyChart extends Chart<MyLine> // NOSONAR
	{
		private static final long serialVersionUID = 1L;

		public MyChart(String id)
		{
			super(id, newModel(), newSeries(), newOptions());
		}

		static IModel<List<MyLine>> newModel()
		{
			return new LoadableDetachableModel<List<MyLine>>() {

				private static final long serialVersionUID = 1L;

				@Override
				protected List<MyLine> load()
				{
					return randomLines();
				}
			};
		}

		static List<Series> newSeries()
		{
			List<Series> series = Generics.newArrayList();
			series.add(new LineSeries(MyLine.SERIES_1, MyLine.VALUES_1));
			series.add(new LineSeries(MyLine.SERIES_2, MyLine.VALUES_2));

			return series;
		}

		static Options newOptions()
		{
			Options options = new Options();
			options.set("title", "{ text: 'Sample Line Chart' }");
			options.set("legend", "{ position: 'top' }");
			options.set("tooltip", "{ visible: true, template: '#= series.name #: #= kendo.toString(value, \"n0\") #' }");
			options.set("categoryAxis", "{ field: 'category' }"); // MyLines#category field

			return options;
		}
	}

	public static class MyLine implements IClusterable
	{
		private static final long serialVersionUID = 1L;
		public static final String SERIES_1 = "line 1";
		public static final String SERIES_2 = "line 2";
		public static final String VALUES_1 = "value1"; // the value property
		public static final String VALUES_2 = "value2"; // the value property

		private final String category;
		private final Double value1;
		private final Double value2;

		public MyLine(String category, Double value1, Double value2)
		{
			this.category = category;
			this.value1 = value1;
			this.value2 = value2;
		}

		public String getCategory()
		{
			return this.category;
		}

		public Double getValue1()
		{
			return this.value1;
		}

		public Double getValue2()
		{
			return this.value2;
		}
	}
}
