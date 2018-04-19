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
package com.streamsets.pipeline.stage.processor.parser;

import com.streamsets.pipeline.api.ErrorCode;
import com.streamsets.pipeline.api.GenerateResourceBundle;

@GenerateResourceBundle
public enum Errors implements ErrorCode {
  DATAPARSER_01("无法解析字段'{}'(以{}类型)，记录：'{}': {}"),
  DATAPARSER_02("无法解析字段'{}'(以{}类型)，记录：'{}'. 因其类型为{}. 支持的类型包括STRING和BYTE_ARRAY."),
  DATAPARSER_03("{}解析字段'{}'(以{}类型)，记录：'{}': {}"),
  DATAPARSER_04("解析整个文件字段'{}'发生IOException异常，记录：'{}': {}"),
  DATAPARSER_05("输入字段'{}'在记录'{}'中不存在; 无法当作{}类型解析"),
//  DATAPARSER_01("Cannot parse the field '{}' as type {} for record '{}': {}"),
//  DATAPARSER_02("Cannot parse the field '{}' as type {} for record '{}' since its type is {}.  Supported types are STRING" +
//      " and BYTE_ARRAY."),
//  DATAPARSER_03("{} parsing the field '{}' as type {} for record '{}': {}"),
//  DATAPARSER_04("IOException attempting to parse whole file field '{}' for record '{}': {}"),
//  DATAPARSER_05("Input field '{}' does not exist in record '{}'; cannot parse as type {}"),
  ;


  private final String msg;
  Errors(String msg) {
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
