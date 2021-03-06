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
package com.streamsets.pipeline.stage.processor.fieldmerger;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.FieldSelectorModel;

public class FieldMergerConfig {

  /**
   * Parameter-less constructor required.
   */
  public FieldMergerConfig() {}

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.MODEL,
//      defaultValue="",
//      label = "From Field",
//      description = "The field in the incoming record to merge.",
//      displayPosition = 10

      defaultValue="",
      label = "原字段",
      description = "传入记录中的字段进行融合",
      displayPosition = 10
  )
  @FieldSelectorModel(singleValued = true)
  public String fromField;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
//      defaultValue="",
//      label = "To Field",
//      description="The field to merge into.",
//      displayPosition = 20
      defaultValue="",
      label = "目标字段",
      description="融合到的字段",
      displayPosition = 20
  )
  public String toField;
}
