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
package com.streamsets.pipeline.stage.common;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.credential.CredentialValue;

public class CredentialsConfig {

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.BOOLEAN,
    defaultValue = "true",
//    label = "Use Credentials",
    label = "是否使用凭据",
    displayPosition = 2000,
    group = "#0"
  )
  public boolean useCredentials = true;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.CREDENTIAL,
    dependsOn = "useCredentials",
    triggeredByValue = "true",
//    label = "Username",
    label = "用户名",
    displayPosition = 10,
    group = "CREDENTIALS"
  )
  public CredentialValue username = () -> "";

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.CREDENTIAL,
    dependsOn = "useCredentials",
    triggeredByValue = "true",
//    label = "Password",
    label = "密码",
    displayPosition = 20,
    group = "CREDENTIALS"
  )
  public CredentialValue password = () -> "";
}
