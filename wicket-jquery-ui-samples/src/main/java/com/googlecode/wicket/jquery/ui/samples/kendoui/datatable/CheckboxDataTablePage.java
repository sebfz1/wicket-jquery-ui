package com.googlecode.wicket.jquery.ui.samples.kendoui.datatable;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.util.lang.Generics;

import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;
import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.core.ajax.IJQueryAjaxAware;
import com.googlecode.wicket.jquery.core.ajax.JQueryAjaxBehavior;
import com.googlecode.wicket.jquery.ui.samples.data.bean.Product;
import com.googlecode.wicket.jquery.ui.samples.data.provider.ProductDataProvider;
import com.googlecode.wicket.kendo.ui.datatable.DataTable;
import com.googlecode.wicket.kendo.ui.datatable.button.CommandButton;
import com.googlecode.wicket.kendo.ui.datatable.checkbox.CheckboxBehavior;
import com.googlecode.wicket.kendo.ui.datatable.checkbox.CheckboxListener;
import com.googlecode.wicket.kendo.ui.datatable.checkbox.SelectRowOnClickBehavior;
import com.googlecode.wicket.kendo.ui.datatable.column.CheckboxColumn;
import com.googlecode.wicket.kendo.ui.datatable.column.CurrencyPropertyColumn;
import com.googlecode.wicket.kendo.ui.datatable.column.IColumn;
import com.googlecode.wicket.kendo.ui.datatable.column.IdPropertyColumn;
import com.googlecode.wicket.kendo.ui.datatable.column.PropertyColumn;
import com.googlecode.wicket.kendo.ui.form.button.AjaxButton;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;

public class CheckboxDataTablePage extends AbstractDataTablePage 
{
    private static final long serialVersionUID = 1L;
    
    private static final String tableId = "myTableId"; // this is used in the HTML as well
    
    public CheckboxDataTablePage() 
    {
        // FeedbackPanel //
        final KendoFeedbackPanel feedback = new KendoFeedbackPanel("feedback");
        this.add(feedback);

        // Form //
        final Form<?> form = new Form<Void>("form");
        this.add(form);

        // DataTable //
        Options options = new Options();
        options.set("height", 430);
        options.set("pageable", "{ pageSizes: [ 25, 50, 100 ] }");
        options.set("columnMenu", true);
        options.set("selectable", true);
        options.set("persistSelection", true); // keep the selection when changing pages

        final CheckboxDataTable<Product> table = new CheckboxDataTable<Product>("datatable", newColumnList(), newDataProvider(), 25, options, feedback);
        form.add(table);

        // Buttons //
        form.add(new AjaxButton("reload") 
        {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                table.reload(target, true);
            }
        });

        form.add(new AjaxButton("refresh") 
        {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                table.refresh(target);
            }
        });
    }
        
    // Override this method to add the SelectRowOnClick Behavior
    @Override
    protected void onInitialize() 
    {
        super.onInitialize();

        this.add(new SelectRowOnClickBehavior(tableId));
    }

    private static IDataProvider<Product> newDataProvider()
    {
        return new ProductDataProvider();
    }

    private static List<IColumn> newColumnList()
    {
        List<IColumn> columns = Generics.newArrayList();

        columns.add(new IdPropertyColumn("ID", "id", 50));
        columns.add(new PropertyColumn("Name", "name"));
        columns.add(new PropertyColumn("Description", "description"));
        columns.add(new CurrencyPropertyColumn("Price", "price", 70));
        columns.add(new PropertyColumn("Vendor", "vendor.name"));
        columns.add(new CheckboxColumn());

        return columns;
    }
    
    private class CheckboxDataTable<T> extends DataTable<T> implements CheckboxListener 
    {
        private static final long serialVersionUID = 1L;
        
        private final KendoFeedbackPanel feedback;
        
        public CheckboxDataTable(String id, List<IColumn> columns, IDataProvider<T> provider, final long rows, Options options, KendoFeedbackPanel feedback) 
        {
            super(id, columns, provider, rows, options);
            this.feedback = feedback;
        }
                
        @Override
        public void onColumnReorder(AjaxRequestTarget target, int oldIndex, int newIndex, JSONObject column)
        {
            final String message = String.format("reordered: old-index=%d, new-index=%d, column=%s", oldIndex, newIndex, column.optString("field"));

            feedback.info(message);
            feedback.refresh(target);
        }
        
        @Override
        public void onChange(AjaxRequestTarget target, JSONArray items)
        {
//            final List<Integer> ids = JsonUtils.toJSONList(items).stream().map(o -> o.getInt("id")).collect(Collectors.toList());
//            final String message = String.format("Selected: %s", ids);
//
//            feedback.info(message);
//            feedback.refresh(target);
        }
        
        @Override
        public void onChecked(AjaxRequestTarget target, String selectedRows) 
        {
            if (selectedRows == null) // TODO: remove this when you get it working!
            {    final String message = String.format("Error: selectedRows is NULL");
                
                feedback.info(message);
                feedback.refresh(target);
                return;
            }
            
            if (!selectedRows.equals("")) 
            {
                final String message = String.format("Selected rows: " + selectedRows);
    
                feedback.info(message);
                feedback.refresh(target);
            }
        }
        
        // Override this method so that we return a CheckboxBehavior
        @Override
        public JQueryBehavior newWidgetBehavior(String selector) 
        {
            return new CheckboxBehavior(selector, this.options, this.getModel(), this) 
            {
                private static final long serialVersionUID = 1L;

                @Override
                protected long getRowCount() 
                {
                    return CheckboxDataTable.this.getRowCount();
                }

                @Override
                protected CharSequence getProviderUrl()
                {
                    return CheckboxDataTable.this.getCallbackUrl();
                }

                @Override
                protected JQueryAjaxBehavior newCommandAjaxBehavior(IJQueryAjaxAware source, CommandButton button) 
                {
                    return this.newCommandAjaxBehavior(source, button);
                }
            };
        }
    }
}
