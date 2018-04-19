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
package com.streamsets.pipeline.stage.processor.kv.redis;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.FieldSelectorModel;
import com.streamsets.pipeline.api.ValueChooserModel;
import com.streamsets.pipeline.lib.el.RecordEL;
import com.streamsets.pipeline.lib.el.StringEL;
import com.streamsets.pipeline.lib.redis.DataType;
import com.streamsets.pipeline.lib.redis.DataTypeChooserValues;

public class RedisLookupParameterConfig {
  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      label = "主键表达式",
      description = "定义用于查找的主键EL表达式",
//      label = "Key Expression",
//      description = "An EL expression defining the key to use for a lookup.",
      elDefs = {StringEL.class, RecordEL.class},
      evaluation = ConfigDef.Evaluation.EXPLICIT,
      displayPosition = 10,
      group = "#0"
  )
  public String keyExpr;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.MODEL,
      label = "输出字段",
//      label = "Output Field",
      displayPosition = 20,
      group = "#0"
  )
  @FieldSelectorModel(singleValued = true)
  public String outputFieldPath;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.MODEL,
      defaultValue = "STRING",
      label = "数据类型",
//      label = "Data Type",
      displayPosition = 20,
      group = "#0"
  )
  @ValueChooserModel(DataTypeChooserValues.class)
  public DataType dataType = DataType.STRING;
}
