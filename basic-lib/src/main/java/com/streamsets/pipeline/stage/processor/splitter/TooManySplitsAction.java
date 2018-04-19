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
package com.streamsets.pipeline.stage.processor.splitter;

import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Label;

@GenerateResourceBundle
public enum TooManySplitsAction implements Label {
//  TO_LAST_FIELD("Put Remaining Text in Last Field"),
//  TO_LIST("Store Remaining Splits as List")

  TO_LAST_FIELD("将剩余文本存放在最后一个字段中"),
  TO_LIST("将剩余拆分保存为List集合")
  ;

  private final String label;

  TooManySplitsAction(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

}