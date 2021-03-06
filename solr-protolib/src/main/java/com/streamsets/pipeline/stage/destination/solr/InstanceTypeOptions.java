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
package com.streamsets.pipeline.stage.destination.solr;

import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Label;

@GenerateResourceBundle
public enum InstanceTypeOptions implements Label {
  SINGLE_NODE("单节点", SolrInstanceType.SINGLE_NODE),
  SOLR_CLOUD("Solr云",  SolrInstanceType.SOLR_CLOUD),
//  SINGLE_NODE("Single Node", SolrInstanceType.SINGLE_NODE),
//  SOLR_CLOUD("SolrCloud",  SolrInstanceType.SOLR_CLOUD),
  ;


  private final String label;
  private SolrInstanceType instanceType;

  InstanceTypeOptions(String label, SolrInstanceType instanceType) {
    this.label = label;
    this.instanceType = instanceType;
  }

  @Override
  public String getLabel() {
    return label;
  }

  public SolrInstanceType getInstanceType() {
    return instanceType;
  }

}
