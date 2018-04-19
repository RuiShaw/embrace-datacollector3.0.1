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
package com.streamsets.pipeline.stage.origin.jdbc.cdc.oracle;

import com.streamsets.pipeline.api.Label;

public enum DictionaryValues implements Label {
	  DICT_FROM_ONLINE_CATALOG("在线目录"),
	  DICT_FROM_REDO_LOGS("重做日志")
  ;

  private final String label;

  DictionaryValues(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return this.label;
  }
}