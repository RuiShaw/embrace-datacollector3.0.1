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
package com.streamsets.pipeline.stage.destination.hive.queryexecutor;

import com.streamsets.pipeline.api.ErrorCode;

public enum QueryExecErrors implements ErrorCode {
  QUERY_EXECUTOR_001("执行查询失败. 详情: {}"),
  QUERY_EXECUTOR_002("评估查询失败. 原因: {} "),
  QUERY_EXECUTOR_003("处理记录失败. 原因: {} "),
//  QUERY_EXECUTOR_001("Failed to execute queries. Details : {}"),
//  QUERY_EXECUTOR_002("Failed to evaluate queries. Reason: {} "),
//  QUERY_EXECUTOR_003("Failed to process record. Reason: {} "),
  ;

  private final String msg;

  QueryExecErrors(String msg) {
    this.msg = msg;
  }

  @Override
  public String getCode() {
    return name();
  }

  @Override
  public String getMessage() {
    return msg;
  }
}