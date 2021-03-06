/**
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
package com.streamsets.pipeline.stage.origin.multikafka;

import com.streamsets.pipeline.api.Label;

public enum Deserializer implements Label {
  STRING("字符串", "org.apache.kafka.common.serialization.StringDeserializer", "org.apache.kafka.common.serialization.StringDeserializer"),
  DEFAULT("默认", "org.apache.kafka.common.serialization.ByteArrayDeserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer"),
  CONFLUENT("Confluent", "io.confluent.kafka.serializers.KafkaAvroDeserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
//  STRING("String", "org.apache.kafka.common.serialization.StringDeserializer", "org.apache.kafka.common.serialization.StringDeserializer"),
//  DEFAULT("Default", "org.apache.kafka.common.serialization.ByteArrayDeserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer"),
//  CONFLUENT("Confluent", "io.confluent.kafka.serializers.KafkaAvroDeserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");

  private final String label;
  private final String keyClass;
  private final String valueClass;

  Deserializer(String label, String keyClass, String valueClass) {
    this.label = label;
    this.keyClass = keyClass;
    this.valueClass = valueClass;
  }

  @Override
  public String getLabel() {
    return label;
  }

  public String getKeyClass() {
    return keyClass;
  }

  public String getValueClass() {
    return valueClass;
  }
}