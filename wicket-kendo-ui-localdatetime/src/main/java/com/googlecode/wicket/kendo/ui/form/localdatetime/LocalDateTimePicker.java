/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.kendo.ui.form.localdatetime;

import java.util.Locale;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.AbstractTextComponent.ITextFormatProvider;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.string.Strings;
import org.apache.wicket.validation.ValidationError;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * Provides a datetime-picker based on a {@link LocalDatePicker} and a {@link LocalTimePicker}
 *
 * @author Sebastien Briquet - sebfz1
 */
public class LocalDateTimePicker extends FormComponentPanel<LocalDateTime> implements ITextFormatProvider
{
	private static final long serialVersionUID = 1L;
	private static final String ERROR_NOT_INITIALIZED = "Internal timePicker is not initialized (#onInitialize() has not yet been called).";

	LocalDatePicker datePicker;
	LocalTimePicker timePicker;

	private final String datePattern;
	private final String timePattern;

	private IConverter<LocalDateTime> converter;

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 */
	public LocalDateTimePicker(String id)
	{
		this(id, LocalDatePicker.DEFAULT_PATTERN, LocalTimePicker.DEFAULT_PATTERN);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param datePattern the SimpleDateFormat pattern for the date
	 * @param timePattern the SimpleDateFormat pattern for the time
	 */
	public LocalDateTimePicker(String id, String datePattern, String timePattern)
	{
		super(id);

		this.datePattern = datePattern;
		this.timePattern = timePattern;
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param date the initial date
	 */
	public LocalDateTimePicker(String id, IModel<LocalDateTime> date)
	{
		this(id, date, LocalDatePicker.DEFAULT_PATTERN, LocalTimePicker.DEFAULT_PATTERN);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup id
	 * @param date the initial date
	 * @param datePattern the SimpleDateFormat pattern for the date
	 * @param timePattern the SimpleDateFormat pattern for the time
	 */
	public LocalDateTimePicker(String id, IModel<LocalDateTime> date, String datePattern, String timePattern)
	{
		super(id, date);

		this.datePattern = datePattern;
		this.timePattern = timePattern;
	}

	// Methods //
	@Override
	protected void convertInput()
	{
		try
		{
			LocalDate date = datePicker.getConvertedInput();
			LocalTime time = timePicker.getConvertedInput();
			this.setConvertedInput(LocalDateTime.of(date,  time == null ? LocalTime.MIDNIGHT : time));
		}
		catch (ConversionException e)
		{
			ValidationError error = new ValidationError();
			error.addKey("LocalDateTimePicker.ConversionError"); // wicket6
			error.setVariable("date", this.datePicker.getInput());
			error.setVariable("time", this.timePicker.getInput());

			this.error(error);
		}
	}

	/**
	 * Gets a formated value of input(s)<br/>
	 * This method is designed to provide the 'value' argument of {@link IConverter#convertToObject(String, Locale)}
	 *
	 * @param dateInput the date input
	 * @param timeInput the time input
	 * @return a formated value
	 */
	protected String formatInput(String dateInput, String timeInput)
	{
		if (!this.isTimePickerEnabled())
		{
			return dateInput;
		}

		return String.format("%s %s", dateInput, timeInput);
	}

	// Properties //
	@Override
	@SuppressWarnings("unchecked")
	public <C> IConverter<C> getConverter(Class<C> type)
	{
		if (LocalDateTime.class.isAssignableFrom(type))
		{
			if (this.converter == null)
			{
				this.converter = this.newDateConverter();
			}

			return (IConverter<C>) this.converter;
		}

		return super.getConverter(type);
	}

	/**
	 * Gets the date pattern in use
	 *
	 * @return the pattern
	 */
	public final String getDatePattern()
	{
		return this.datePicker.getTextFormat(); // let throw a NPE if #getDatePattern() is called before #onConfigure()
	}

	/**
	 * Gets the time pattern in use
	 *
	 * @return the pattern
	 */
	public final String getTimePattern()
	{
		return this.timePicker.getTextFormat(); // let throw a NPE if #getTimePattern() is called before #onConfigure()
	}

	/**
	 * Indicates whether the time-picker is enabled.<br/>
	 * This method is marked final because an override will not change the time-picker 'enable' flag
	 *
	 * @return the enabled flag
	 */
	public final boolean isTimePickerEnabled()
	{
		if (this.timePicker != null)
		{
			return this.timePicker.isEnabled();
		}

		throw new WicketRuntimeException(ERROR_NOT_INITIALIZED);
	}

	/**
	 * Sets the time-picker enabled flag
	 *
	 * @param enabled the enabled flag
	 */
	public final void setTimePickerEnabled(boolean enabled)
	{
		if (this.timePicker != null)
		{
			this.timePicker.setEnabled(enabled);
		}
		else
		{
			throw new WicketRuntimeException(ERROR_NOT_INITIALIZED); // fixes #61
		}
	}

	/**
	 * Sets the time-picker enabled flag
	 *
	 * @param target the {@link AjaxRequestTarget}
	 * @param enabled the enabled flag
	 */
	public final void setTimePickerEnabled(AjaxRequestTarget target, boolean enabled)
	{
		this.setTimePickerEnabled(enabled);

		target.add(this.timePicker);
	}

	/**
	 * Returns the date-time pattern.
	 *
	 * @see org.apache.wicket.markup.html.form.AbstractTextComponent.ITextFormatProvider#getTextFormat()
	 */
	@Override
	public final String getTextFormat()
	{
		if (!this.isTimePickerEnabled())
		{
			return this.getDatePattern();
		}

		return String.format("%s %s", this.getDatePattern(), this.getTimePattern());
	}

	/**
	 * Gets a string representation of the model object, given the date-time pattern in use.
	 *
	 * @return the model object as string
	 */
	public String getModelObjectAsString()
	{
		LocalDateTime date = this.getModelObject();

		if (date != null)
		{
			return date.format(DateTimeFormatter.ofPattern(this.getTextFormat()));
		}

		return "";
	}

	// Events //
	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.datePicker = this.newDatePicker("datepicker", new PropertyModel<LocalDate>(getModel(), "date"), this.datePattern);
		this.timePicker = this.newTimePicker("timepicker", new PropertyModel<LocalTime>(getModel(), "time"), this.timePattern);

		this.add(this.datePicker);
		this.add(this.timePicker);
	}

	// Factories //
	/**
	 * Gets a new date converter.
	 *
	 * @return the converter
	 */
	private IConverter<LocalDateTime> newDateConverter()
	{
		return new IConverter<LocalDateTime>() {
			private static final long serialVersionUID = 1L;

			@Override
			public LocalDateTime convertToObject(String value, Locale locale) throws ConversionException {
				return Strings.isEmpty(value) ? null : LocalDateTime.parse(value, DateTimeFormatter.ofPattern(getTextFormat()));
			}

			@Override
			public String convertToString(LocalDateTime date, Locale locale) {
				return date == null ? null : date.format(DateTimeFormatter.ofPattern(getTextFormat()));
			}
		};
	}

	/**
	 * Gets a new {@link LocalDatePicker}
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param datePattern the date pattern to be used
	 *
	 * @return the {@link LocalDatePicker}
	 */
	protected LocalDatePicker newDatePicker(String id, IModel<LocalDate> model, String datePattern)
	{
		return new LocalDatePicker(id, model, datePattern);
	}

	/**
	 * Gets a new {@link LocalTimePicker}
	 *
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param timePattern the date pattern to be used
	 *
	 * @return the {@link LocalTimePicker}
	 */
	protected LocalTimePicker newTimePicker(String id, IModel<LocalTime> model, String timePattern)
	{
		return new LocalTimePicker(id, model, timePattern);
	}
}
