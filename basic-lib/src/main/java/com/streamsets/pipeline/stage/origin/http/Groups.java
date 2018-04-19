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
package com.streamsets.pipeline.stage.origin.http;

import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Label;

@GenerateResourceBundle
public enum Groups implements Label {
//  HTTP("HTTP"),
//  PAGINATION("Pagination"),
//  CREDENTIALS("Credentials"),
//  OAUTH2("OAuth 2"),
//  PROXY("Proxy"),
//  TLS("TLS"),
//  TIMEOUT("Timeout Handling"),
//  DATA_FORMAT("Data Format"),
//  LOGGING("Logging")

  HTTP("HTTP"),
  PAGINATION("分页"),
  CREDENTIALS("认证信息"),
  OAUTH2("OAuth2"),
  PROXY("代理"),
  TLS("TLS"),
  TIMEOUT("超时处理"),
  DATA_FORMAT("数据格式"),
  LOGGING("日志")
  ;

  private final String label;

  private Groups(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return this.label;
  }
}