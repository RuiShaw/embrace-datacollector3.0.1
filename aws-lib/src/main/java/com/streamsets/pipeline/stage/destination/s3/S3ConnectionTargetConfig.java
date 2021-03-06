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
package com.streamsets.pipeline.stage.destination.s3;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.lib.el.RecordEL;
import com.streamsets.pipeline.lib.el.TimeEL;
import com.streamsets.pipeline.lib.el.TimeNowEL;
import com.streamsets.pipeline.stage.common.s3.S3ConnectionBaseConfig;

public class S3ConnectionTargetConfig extends S3ConnectionBaseConfig {

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.STRING,
    label = "桶",
    description = "桶表达式，用于标识每个记录的桶。",
//    label = "Bucket",
//    description = "Expression that will identify bucket for each record.",
    displayPosition = 20,
    evaluation = ConfigDef.Evaluation.EXPLICIT,
    elDefs = { RecordEL.class, TimeEL.class, TimeNowEL.class },
    group = "#0"
  )
  public String bucketTemplate;

}
