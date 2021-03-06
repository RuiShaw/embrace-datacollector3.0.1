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
package com.streamsets.datacollector.pipeline.executor.spark;

import com.streamsets.pipeline.api.Label;

public enum Groups implements Label {
  SPARK("Spark"),
  APPLICATION("应用程序"),
  CREDENTIALS("凭证"),
  SSL("SSL"),
  PROXY("代理"),
//  APPLICATION("Application"),
//  CREDENTIALS("Credentials"),
//  SSL("SSL"),
//  PROXY("Proxy"),
  ;

  private String label;

  Groups(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }
}
