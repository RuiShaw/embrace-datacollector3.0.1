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
package com.streamsets.pipeline.stage.origin.mongodb;

import com.mongodb.ReadPreference;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Label;

@GenerateResourceBundle
public enum ReadPreferenceLabel implements Label {
  PRIMARY("主节点", ReadPreference.primary()),
  PRIMARY_PREFERRED("首选主节点", ReadPreference.primaryPreferred()),
  SECONDARY("从节点", ReadPreference.secondary()),
  SECONDARY_PREFERRED("首选从节点", ReadPreference.secondaryPreferred()),
  NEAREST("最邻近节点", ReadPreference.nearest()),
//  PRIMARY("Primary", ReadPreference.primary()),
//  PRIMARY_PREFERRED("Primary Preferred", ReadPreference.primaryPreferred()),
//  SECONDARY("Secondary", ReadPreference.secondary()),
//  SECONDARY_PREFERRED("Secondary Preferred", ReadPreference.secondaryPreferred()),
//  NEAREST("Nearest", ReadPreference.nearest()),
  ;

  private final String label;
  private final ReadPreference readPreference;

  ReadPreferenceLabel(String label, ReadPreference readPreference) {
    this.label = label;
    this.readPreference = readPreference;
  }

  @Override
  public String getLabel() {
    return label;
  }

  public ReadPreference getReadPreference() {
    return readPreference;
  }

}
