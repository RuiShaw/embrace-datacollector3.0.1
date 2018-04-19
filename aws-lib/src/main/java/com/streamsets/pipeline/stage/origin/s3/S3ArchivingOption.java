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
package com.streamsets.pipeline.stage.origin.s3;

import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Label;

@GenerateResourceBundle
public enum S3ArchivingOption implements Label {
  MOVE_TO_PREFIX("移动至其他前缀"),
  MOVE_TO_BUCKET("移动至其他桶"),
  COPY_TO_PREFIX("拷贝至其他前缀"),
  COPY_TO_BUCKET("拷贝至其他桶"),
//  MOVE_TO_PREFIX("Move into another prefix"),
//  MOVE_TO_BUCKET("Move into another bucket"),
//  COPY_TO_PREFIX("Copy into another prefix"),
//  COPY_TO_BUCKET("Copy into another bucket"),
  ;

  private final String label;

  S3ArchivingOption(String label) {
    this.label = label;
  }

  @Override
  public String getLabel() {
    return label;
  }

}