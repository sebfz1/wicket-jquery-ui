package com.googlecode.wicket.jquery.ui.form.autocomplete;

import java.util.List;

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

/**
 * This interface defines a way to use autocomplete based in other selection criteria not necessarily the index
 *
 * @param <T> The type of bean
 * @param <ID> The type of the ID generate
 */
public interface IAutoCompleteHandler<T, ID>
{
    /**
     * Returns a unique id for a choice with a given index.
     *
     * @param choice The choice
     * @param index The index
     *
     * @return a given ID
     */
    ID getId(T choice, int index);

    /**
     * Converts a client side "index" into an ID.
     *
     * @param index The index
     * @return the server side ID corresponding to the index.
     */
    ID indexToId(String index);

    /**
     * @param term The filtering term
     * @return A list of choices matching the term.
     */
    List<T> getChoices(String term);


    /**
     * Selects the choice for the given ID (if any still exists)
     *
     * @param id The ID
     * @return The selected choice.
     */
    T selectChoice(ID id);
}
