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
package com.streamsets.pipeline.stage.origin.udptokafka;

import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Label;

@GenerateResourceBundle
public enum Groups implements Label {
  KAFKA("Kafka"),
  UDP("UDP"),
  ADVANCED("高级"),
  DATA_FORMAT("数据格式"),
  NETFLOW_V9("NetFlow 9"),
//  KAFKA("Kafka"),
//  UDP("UDP"),
//  ADVANCED("Advanced"),
//  DATA_FORMAT("Data Format"),
//  NETFLOW_V9("NetFlow 9"),
  ;

  private final String label;

  Groups(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return this.label;
  }
}
