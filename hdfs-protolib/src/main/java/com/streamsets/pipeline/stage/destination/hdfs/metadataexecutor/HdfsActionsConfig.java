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
package com.streamsets.pipeline.stage.destination.hdfs.metadataexecutor;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.Dependency;
import com.streamsets.pipeline.api.Stage;
import com.streamsets.pipeline.api.ValueChooserModel;
import com.streamsets.pipeline.lib.el.RecordEL;

import java.util.List;

/**
 * Various actions that can be performed on the given file.
 */
public class HdfsActionsConfig {

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.MODEL,
    defaultValue = "CHANGE_EXISTING_FILE",
    label = "任务",
    description = "执行的任务.",
//    label = "Task",
//    description = "Task that should be performed.",
    group = "TASKS",
    displayPosition = 90
  )
  @ValueChooserModel(TaskTypeChooserValues.class)
  public TaskType taskType = TaskType.CHANGE_EXISTING_FILE;

  @ConfigDef(
    required = false,
    type = ConfigDef.Type.STRING,
    defaultValue = "${record:value('/filepath')}",
    label = "文件路径",
    description = "执行元信息修改操作的文件的完整路径",
//    label = "File Path",
//    description = "Full path to the file on which the metadata operations should be executed.",
    displayPosition = 100,
    group = "TASKS",
    evaluation = ConfigDef.Evaluation.EXPLICIT,
    elDefs = {RecordEL.class}
  )
  public String filePath;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.BOOLEAN,
    defaultValue = "false",
    label = "移动文件",
    description = "将文件移动到其他目录. 文件名不变.",
//    label = "Move File",
//    description = "Moves the file to a different directory. The file name won't be changed.",
    displayPosition = 110,
    group = "TASKS",
    dependencies = {
      @Dependency(configName = "taskType", triggeredByValues = "CHANGE_EXISTING_FILE")
    }
  )
  public boolean shouldMoveFile;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.STRING,
    defaultValue = "/new/location/",
    label = "新路径",
    description = "文件移动的目标位置. 文件名不变",
//    label = "New Location",
//    description = "New location where the file should be moved to. File name will be preserved.",
    displayPosition = 115,
    group = "TASKS",
    dependsOn = "shouldMoveFile",
    triggeredByValue = "true",
    evaluation = ConfigDef.Evaluation.EXPLICIT,
    elDefs = {RecordEL.class}
  )
  public String newLocation;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.BOOLEAN,
    defaultValue = "false",
    label = "重命名",
    description = "对文件名重命名.",
//    label = "Rename",
//    description = "Renames the file to a different file name.",
    displayPosition = 120,
    group = "TASKS",
    dependencies = {
      @Dependency(configName = "taskType", triggeredByValues = "CHANGE_EXISTING_FILE")
    }
  )
  public boolean shouldRename;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.STRING,
    defaultValue = "differentName.txt",
    label = "新文件名",
    description = "新文件名",
//    label = "New name",
//    description = "New name for the file.",
    displayPosition = 125,
    group = "TASKS",
    dependsOn = "shouldRename",
    triggeredByValue = "true",
    evaluation = ConfigDef.Evaluation.EXPLICIT,
    elDefs = {RecordEL.class}
  )
  public String newName;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.BOOLEAN,
    defaultValue = "false",
    label = "设置所有者",
    description = "设置更改文件的所有者和组。",
//    label = "Set Ownership",
//    description = "Set to change owner and group of the file.",
    displayPosition = 130,
    group = "TASKS",
    dependencies = {
      @Dependency(configName = "taskType", triggeredByValues = {"CHANGE_EXISTING_FILE", "CREATE_EMPTY_FILE"})
    }
  )
  public boolean shouldChangeOwnership;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.STRING,
    defaultValue = "new_owner",
    label = "新所有者",
//    label = "New Owner",
    displayPosition = 135,
    group = "TASKS",
    dependsOn = "shouldChangeOwnership",
    triggeredByValue = "true",
    evaluation = ConfigDef.Evaluation.EXPLICIT,
    elDefs = {RecordEL.class}
  )
  public String newOwner;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.STRING,
    defaultValue = "new_group",
    label = "新拥有组",
//    label = "New Group",
    displayPosition = 140,
    group = "TASKS",
    dependsOn = "shouldChangeOwnership",
    triggeredByValue = "true",
    evaluation = ConfigDef.Evaluation.EXPLICIT,
    elDefs = {RecordEL.class}
  )
  public String newGroup;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.BOOLEAN,
    defaultValue = "false",
    label = "设置访问权限",
    description = "设置文件的访问权限",
//    label = "Set Permissions",
//    description = "Set to override files permissions.",
    displayPosition = 145,
    group = "TASKS",
    dependencies = {
      @Dependency(configName = "taskType", triggeredByValues = {"CHANGE_EXISTING_FILE", "CREATE_EMPTY_FILE"})
    }
  )
  public boolean shouldSetPermissions;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.STRING,
    defaultValue = "700",
    label = "新访问权限",
    description = "八进制或符号格式的访问权限",
//    label = "New Permissions",
//    description = "Permissions in either in octal or symbolic format.",
    displayPosition = 150,
    group = "TASKS",
    dependsOn = "shouldSetPermissions",
    triggeredByValue = "true",
    evaluation = ConfigDef.Evaluation.EXPLICIT,
    elDefs = {RecordEL.class}
  )
  public String newPermissions;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.BOOLEAN,
    defaultValue = "false",
    label = "设置扩展访问属性",
    description = "设置扩展访问属性",
//    label = "Set ACLs",
//    description = "Set to set extended access attributes.",
    displayPosition = 155,
    group = "TASKS",
    dependencies = {
      @Dependency(configName = "taskType", triggeredByValues = {"CHANGE_EXISTING_FILE", "CREATE_EMPTY_FILE"})
    }
  )
  public boolean shouldSetAcls;

  @ConfigDef(
    required = true,
    type = ConfigDef.Type.STRING,
    defaultValue = "user::rwx,user:foo:rw-,group::r--,other::---",
    label = "新扩展访问属性",
    description = "扩展访问属性，以“,”分割",
//    label = "New ACLs",
//    description = "List of ACLs separated by commas.",
    displayPosition = 160,
    group = "TASKS",
    dependsOn = "shouldSetAcls",
    triggeredByValue = "true",
    evaluation = ConfigDef.Evaluation.EXPLICIT,
    elDefs = {RecordEL.class}
  )
  public String newAcls;


  public void init(Stage.Context context, String prefix, List<Stage.ConfigIssue> issues) {
    // Setting permissions and ACLs does not make sense
    if(shouldSetPermissions && shouldSetAcls) {
      issues.add(
        context.createConfigIssue(
          Groups.TASKS.name(),
          null,
          HdfsMetadataErrors.HDFS_METADATA_006
        )
      );
    }
  }

  public void destroy() {
    // No-op currently
  }
}
