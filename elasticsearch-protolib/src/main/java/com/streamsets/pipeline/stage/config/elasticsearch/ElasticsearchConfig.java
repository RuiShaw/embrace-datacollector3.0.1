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
import com.streamsets.pipeline.api.ConfigDefBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElasticsearchConfig {
  public static final String DEFAULT_HTTP_URI = "hostname:port";

  @ConfigDefBean
  public SecurityConfig securityConfig = new SecurityConfig();

  @ConfigDef(
      required = false,
      type = ConfigDef.Type.LIST,
      label = "集群地址",
      defaultValue = "[\"" + DEFAULT_HTTP_URI + "\"]",
      description = "Elasticsearch的HTTP连接地址.",
//      label = "Cluster HTTP URIs",
//      defaultValue = "[\"" + DEFAULT_HTTP_URI + "\"]",
//      description = "Elasticsearch HTTP Endpoints.",
      displayPosition = 10,
      group = "ELASTIC_SEARCH"
  )
  public List<String> httpUris;

  @ConfigDef(
      required = false,
      type = ConfigDef.Type.MAP,
      label = "HTTP参数",
      description = "HTTP参数",
//      label = "Additional HTTP Params",
//      description = "Additional HTTP Params.",
      displayPosition = 20,
      group = "ELASTIC_SEARCH"
  )
  public Map<String, String> params = new HashMap<>();

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.BOOLEAN,
      label = "检测新增节点",
      defaultValue = "false",
      description = "自动发现集群新增节点。如果数据收集器与集群不在同一个局域网，请不要使用。",
//      label = "Detect Additional Nodes in Cluster",
//      defaultValue = "false",
//      description = "Select to automatically discover additional Elasticsearch nodes in the cluster. " +
//          "Do not use if the Data Collector is on a different network from the cluster.",
      displayPosition = 30,
      group = "ELASTIC_SEARCH"
  )
  public boolean clientSniff = false;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.BOOLEAN,
      label = "启用安全",
//      label = "Use Security",
      defaultValue = "false",
      description = "Use Security",
      displayPosition = 40,
      group = "ELASTIC_SEARCH"
  )
  public boolean useSecurity = false;

  // Display position in SecurityConfig starts where this stops. This is because this config is also available
  // on error stage where there is only one tab an hence all configs are sequential.
}
