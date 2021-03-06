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
package com.streamsets.pipeline.stage.processor.jsonparser;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.ConfigGroups;
import com.streamsets.pipeline.api.FieldSelectorModel;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Processor;
import com.streamsets.pipeline.api.StageDef;
import com.streamsets.pipeline.configurablestage.DProcessor;

@StageDef(
    version = 1,
//    label = "JSON Parser",
//    description = "Parses a string field with JSON data",
//    icon = "json.png",
//    onlineHelpRefUrl = "index.html#Processors/JSONParser.html#task_kwz_lg2_zq"

    label = "JSON解析器",
    description = "解析内部包含JSON数据的字符串",
    icon = "json.png",
    onlineHelpRefUrl = "index.html#Processors/JSONParser.html#task_kwz_lg2_zq"
)
@ConfigGroups(Groups.class)
@GenerateResourceBundle
public class JsonParserDProcessor extends DProcessor {

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.MODEL,
      defaultValue = "",
//      label = "Field to Parse",
//      description = "String field that contains a JSON object",
//      displayPosition = 10,
//      group = "JSON"

      label = "解析字段",
      description = "包含JSON对象的字符串字段",
      displayPosition = 10,
      group = "JSON"
  )
  @FieldSelectorModel(singleValued = true)
  public String fieldPathToParse;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.BOOLEAN,
      defaultValue = "false",
//      label = "Ignore Control Characters",
//      description = "Use only if required as it impacts reading performance",
//      displayPosition = 20,
//      group = "JSON"

      label = "忽略控制字符",
      description = "只在必要时使用，因为它会影响读取效率",
      displayPosition = 20,
      group = "JSON"
  )
  public boolean removeCtrlChars;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      defaultValue = "",
//      label = "Target Field",
//      description="Name of the field to set the parsed JSON data to",
//      displayPosition = 30,
//      group = "JSON"

      label = "目标字段",
      description="将解析的JSON数据设置为的字段的名称",
      displayPosition = 30,
      group = "JSON"
  )
  public String parsedFieldPath;

  @Override
  protected Processor createProcessor() {
    return new JsonParserProcessor(fieldPathToParse, removeCtrlChars, parsedFieldPath);
  }
}
