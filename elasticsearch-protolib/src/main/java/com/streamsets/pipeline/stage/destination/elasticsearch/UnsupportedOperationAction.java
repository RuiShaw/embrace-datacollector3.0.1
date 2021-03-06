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
package com.streamsets.pipeline.stage.destination.elasticsearch;

import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Label;


@GenerateResourceBundle
public enum UnsupportedOperationAction implements Label {
  DISCARD("丢弃"),
  SEND_TO_ERROR("发送至错误处理节点"),
  USE_DEFAULT("使用默认操作"),
//  DISCARD("Discard"),
//  SEND_TO_ERROR("Send to Error"),
//  USE_DEFAULT("Use Default Operation"),
  ;

  private final String label;
  UnsupportedOperationAction(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

}
