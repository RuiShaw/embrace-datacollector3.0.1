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
package com.streamsets.pipeline.stage.processor.fieldflattener;

import com.streamsets.pipeline.api.Label;

public enum CollisionFieldAction implements Label {
//  TO_ERROR("Send record to error lane"),
//  OVERRIDE("Override with new value"),
//  DISCARD("Discard new value"),

  TO_ERROR("发送到错误通道"),
  OVERRIDE("用新值覆盖"),
  DISCARD("丢弃新值"),
  ;

  String label;

  CollisionFieldAction(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }
}
