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
package com.streamsets.pipeline.lib.jdbc.multithread;

import com.streamsets.pipeline.api.Label;

public enum BatchTableStrategy implements Label {
	SWITCH_TABLES("Switch 表"),
	PROCESS_ALL_AVAILABLE_ROWS_FROM_TABLE("从表中处理所有可用的行"),
  ;

  private final String label;

  BatchTableStrategy(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
  }
}