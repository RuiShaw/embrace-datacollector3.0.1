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
package com.streamsets.pipeline.stage.config.elasticsearch;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.lib.el.OffsetEL;
import com.streamsets.pipeline.lib.el.TimeEL;

public class ElasticsearchSourceConfig extends ElasticsearchConfig {

  @ConfigDef(
      required = false,
      type = ConfigDef.Type.STRING,
      label = "索引",
      description = "限定查询的索引(可选)",
//      label = "Index",
//      description = "Optional index to scope query",
      group = "ELASTIC_SEARCH",
      displayPosition = 50
  )
  public String index;

  @ConfigDef(
      required = false,
      type = ConfigDef.Type.STRING,
      label = "映射",
      description = "限定查询的映射(可选)",
//      description = "Optional type mapping to scope query",
      group = "ELASTIC_SEARCH",
      displayPosition = 60
  )
  public String mapping;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.BOOLEAN,
      label = "增量模式",
      description = "根据偏移字段增量获取数据，直到任务停止为止",
//      label = "Incremental Mode",
//      description = "Fetches data incrementally based on the offset field until the pipeline is stopped",
      defaultValue = "false",
      group = "ELASTIC_SEARCH",
      displayPosition = 70
  )
  public boolean isIncrementalMode = false;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.NUMBER,
      label = "查询间隔",
      description = "运行增量查询的时间间隔。",
//      label = "Query Interval",
//      description = "Interval at which to run the provided incremental query",
      defaultValue = "${1 * HOURS}",
      elDefs = TimeEL.class,
      dependsOn = "isIncrementalMode",
      triggeredByValue = "true",
      group = "ELASTIC_SEARCH",
      displayPosition = 80
  )
  public long queryInterval = 3600;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      label = "偏移量字段",
      description = "用于追踪结果偏移量的字段名。",
//      label = "Offset Field",
//      description = "Field name to use for tracking offset in the result.",
      defaultValue = "timestamp",
      dependsOn = "isIncrementalMode",
      triggeredByValue = "true",
      group = "ELASTIC_SEARCH",
      displayPosition = 90
  )
  public String offsetField = "timestamp";

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      label = "初始偏移量",
      description = "重置数据源后使用的初始偏移量。",
//      label = "Initial Offset",
//      description = "Initial value to use when Reset Origin is performed.",
      defaultValue = "now-1d/d",
      dependsOn = "isIncrementalMode",
      triggeredByValue = "true",
      group = "ELASTIC_SEARCH",
      displayPosition = 100
  )
  public String initialOffset = "now-1d/d";

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.TEXT,
      mode = ConfigDef.Mode.JSON,
      label = "查询",
//      label = "Query",
      defaultValue = "{\n  \"query\": {\n    \"match_all\": {}\n  }\n}",
      description = "执行的Elasticsearch查询",
//      description = "Elasticsearch query to run",
      elDefs = OffsetEL.class,
      group = "ELASTIC_SEARCH",
      displayPosition = 130
  )
  public String query = "{\n  \"query\": {\n    \"match_all\": {}\n  }\n}";

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      label = "滚动卷超时时间",
      description = "保持搜索上下文存活的最大时间",
//      label = "Scroll Timeout",
//      description = "Maximum amount of time to keep the search context alive",
      defaultValue = "1m",
      group = "ELASTIC_SEARCH",
      displayPosition = 140
  )
  public String cursorTimeout = "1m";

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.BOOLEAN,
      label = "任务结束时删除滚动卷",
      description = "任务结束时是否显式删除滚动卷，或者使其过期。",
//      label = "Delete Scroll on Pipeline Stop",
//      description = "Whether to explicitly delete the scroll on pipeline stop, or let it expire",
      defaultValue = "true",
      group = "ELASTIC_SEARCH",
      displayPosition = 150
  )
  public boolean deleteCursor = true;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.NUMBER,
      label = "最大批处理大小",
      description = "每次请求Elasticsearch的最大结果数",
//      label = "Max Batch Size",
//      description = "Maximum results to fetch per request from Elasticsearch",
      defaultValue = "1000",
      group = "ELASTIC_SEARCH",
      displayPosition = 160
  )
  public int maxBatchSize = 1000;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.NUMBER,
      defaultValue = "1",
      label = "切片数量",
      description = "每个滚动卷并行处理的片数",
//      label = "Number of Slices",
//      description = "Number of slices per scroll to process in parallel",
      min = 1,
      max = 200,
      group = "ELASTIC_SEARCH",
      displayPosition = 170
  )
  public int numSlices = 1;
}
