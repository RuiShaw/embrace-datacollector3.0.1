/*
 * ```Copyright 2017 StreamSets Inc.
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
 * limitations under the License.```
 */
package com.streamsets.pipeline.stage.destination.mqtt;

import com.streamsets.pipeline.api.ErrorStage;
import com.streamsets.pipeline.api.ExecutionMode;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.HideConfigs;
import com.streamsets.pipeline.api.StageDef;
import com.streamsets.pipeline.api.Target;
import com.streamsets.pipeline.config.DataFormat;

@StageDef(
    version = 2,
    label = "保存至MQTT",
    description = "将错误记录保存至MQTT服务器",
//    label = "Write to MQTT",
//    description = "Writes error records to MQTT broker",
    icon = "mqtt.png",
    execution = {
        ExecutionMode.STANDALONE,
        ExecutionMode.CLUSTER_BATCH,
        ExecutionMode.CLUSTER_YARN_STREAMING,
        ExecutionMode.CLUSTER_MESOS_STREAMING,
        ExecutionMode.EDGE
    },
    onlineHelpRefUrl = "index.html#Pipeline_Configuration/ErrorHandling.html#concept_kgc_l4y_5r",
    upgrader = MqttClientTargetUpgrader.class
)
@HideConfigs(
    preconditions = true,
    onErrorRecord = true,
    value = {
        "commonConf.tlsConfig.keyStoreFilePath",
        "commonConf.tlsConfig.keyStoreType",
        "commonConf.tlsConfig.keyStorePassword",
        "commonConf.tlsConfig.keyStoreAlgorithm",
        "publisherConf.dataFormat"
    })
@ErrorStage
@GenerateResourceBundle
public class ToErrorMqttClientDTarget extends MqttClientDTarget {
  @Override
  protected Target createTarget() {
    publisherConf.dataFormat = DataFormat.SDC_JSON;
    return new MqttClientTarget(commonConf, publisherConf);
  }
}
