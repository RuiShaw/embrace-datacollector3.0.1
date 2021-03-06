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
package com.streamsets.pipeline.stage.origin.redis;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.ConfigDefBean;
import com.streamsets.pipeline.api.ValueChooserModel;
import com.streamsets.pipeline.config.DataFormat;
import com.streamsets.pipeline.stage.origin.lib.DataParserFormatConfig;

import java.util.List;

public class RedisOriginConfigBean {

  public static final String DATA_FROMAT_CONFIG_BEAN_PREFIX = "dataFormatConfig.";

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      label = "地址",
      description = "格式：redis://[:password@]host:port[/[database]]",
//      label = "URI",
//      description = "Use format redis://[:password@]host:port[/[database]]",
      group = "REDIS",
      displayPosition = 10
  )
  public String uri = "redis://:password@localhost:6379/0";

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.NUMBER,
      label = "连接超时时间(s)",
      description = "连接超时时间(s)",
//      label = "Connection Timeout (sec)",
//      description = "Connection timeout (sec)",
      defaultValue = "60",
      min = 1,
      group = "REDIS",
      displayPosition = 20
  )
  public int connectionTimeout;

  @ConfigDef(
      required = false,
      type = ConfigDef.Type.LIST,
      label = "渠道",
      description = "订阅频道",
//      label = "Channels",
//      description = "Channels to subscribe to",
      group = "REDIS",
      displayPosition = 40
  )
  public List<String> subscriptionChannels;

  @ConfigDef(
      required = false,
      type = ConfigDef.Type.LIST,
      label = "匹配模式",
      description = "订阅渠道名称的匹配模式",
//      label = "Pattern",
//      description = "Subscribes to channels with names that match the pattern",
      group = "REDIS",
      displayPosition = 50
  )
  public List<String> subscriptionPatterns;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.MODEL,
      label = "数据格式",
      description = "数据格式",
//      label = "Data Format",
//      description = "Format of data",
      displayPosition = 1,
      group = "DATA_FORMAT"
  )
  @ValueChooserModel(DataFormatChooserValues.class)
  public DataFormat dataFormat;

  @ConfigDefBean(groups = "REDIS")
  public DataParserFormatConfig dataFormatConfig = new DataParserFormatConfig();

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.NUMBER,
      label = "批处理等待时间(ms)",
      defaultValue = "2000",
      description = "提交事务的最大等待时间",
//      label = "Batch Wait Time (ms)",
//      defaultValue = "2000",
//      description = "Maximum time to wait for data before sending a partial or empty batch",
      group = "REDIS",
      min = 1,
      max = Integer.MAX_VALUE,
      displayPosition = 1000
  )
  public int maxWaitTime = 2000;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.NUMBER,
      defaultValue = "1000",
      label = "最大批处理记录数",
      description = "每批次中记录的最大数",
//      label = "Max Batch Size (records)",
//      description = "Max number of records per batch",
      group = "REDIS",
      min = 1,
      max = Integer.MAX_VALUE,
      displayPosition = 1001
  )
  public int maxBatchSize = 1000;
}
