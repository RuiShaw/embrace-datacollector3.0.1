/*
 * Copyright 2017 StreamSets Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.stage.common;

import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Label;

@GenerateResourceBundle
public enum MultipleValuesBehavior implements Label {
//  FIRST_ONLY("First value only"),
//  ALL_AS_LIST("All values as a list"),
//  SPLIT_INTO_MULTIPLE_RECORDS("Split into multiple records"),
  FIRST_ONLY("仅第一条数据"),
  ALL_AS_LIST("作为List集合"),
  SPLIT_INTO_MULTIPLE_RECORDS("拆分为多条记录"),
  ;

  public static final MultipleValuesBehavior DEFAULT = FIRST_ONLY;

  private final String label;

  MultipleValuesBehavior(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }
}
