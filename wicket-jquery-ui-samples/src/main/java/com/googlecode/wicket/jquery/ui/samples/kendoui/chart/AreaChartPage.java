package com.googlecode.wicket.jquery.ui.samples.kendoui.chart;

import java.util.List;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.util.io.IClusterable;
import org.apache.wicket.util.lang.Generics;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.core.utils.ListUtils;
import com.googlecode.wicket.kendo.ui.dataviz.chart.Chart;
import com.googlecode.wicket.kendo.ui.dataviz.chart.series.AreaSeries;
import com.googlecode.wicket.kendo.ui.dataviz.chart.series.Series;

public class AreaChartPage extends AbstractChartPage // NOSONAR
{
	private static final long serialVersionUID = 1L;

	public AreaChartPage()
	{
		// Chart //
		this.add(new MyChart("chart"));
	}

	// statics //

	static List<MyArea> randomAreas()
	{
		List<MyArea> data = Generics.newArrayList();

		Double value1 = null;
		Double value2 = null;

		for (int i = 0; i < 10; i++)
		{
			// smooth variation
			value1 = value1 != null ? value1 + ListUtils.random(-10, 10) : ListUtils.random(25, 50);
			value2 = value2 != null ? value2 + ListUtils.random(-10, 10) : ListUtils.random(25, 50);

			data.add(new MyArea("#" + i, value1, value2));
		}

		return data;
	}

	// classes //

	static class MyChart extends Chart<MyArea> // NOSONAR
	{
		private static final long serialVersionUID = 1L;

		public MyChart(String id)
		{
			super(id, newModel(), newSeries(), newOptions());
		}

		static IModel<List<MyArea>> newModel()
		{
			return new LoadableDetachableModel<List<MyArea>>() {

				private static final long serialVersionUID = 1L;

				@Override
				protected List<MyArea> load()
				{
					return randomAreas();
				}
			};
		}

		static List<Series> newSeries()
		{
			List<Series> series = Generics.newArrayList();
			series.add(new AreaSeries(MyArea.SERIES_1, MyArea.VALUES_1));
			series.add(new AreaSeries(MyArea.SERIES_2, MyArea.VALUES_2));

			return series;
		}

		static Options newOptions()
		{
			Options options = new Options();
			options.set("title", "{ text: 'Sample Area Chart' }");
			options.set("legend", "{ position: 'top' }");
			options.set("tooltip", "{ visible: true, template: '#= series.name #: #= kendo.toString(value, \"n0\") #' }");
			options.set("categoryAxis", "{ field: 'category' }"); // MyLines#category field

			return options;
		}
	}

	public static class MyArea implements IClusterable
	{
		private static final long serialVersionUID = 1L;
		public static final String SERIES_1 = "area 1";
		public static final String SERIES_2 = "area 2";
		public static final String VALUES_1 = "value1"; // the value property
		public static final String VALUES_2 = "value2"; // the value property

		private final String category;
		private final Double value1;
		private final Double value2;

		public MyArea(String category, Double value1, Double value2)
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
