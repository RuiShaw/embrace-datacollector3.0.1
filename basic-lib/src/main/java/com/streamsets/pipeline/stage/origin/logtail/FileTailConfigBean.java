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
package com.streamsets.pipeline.stage.origin.logtail;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.ConfigDefBean;
import com.streamsets.pipeline.api.ListBeanModel;
import com.streamsets.pipeline.api.ValueChooserModel;
import com.streamsets.pipeline.config.DataFormat;
import com.streamsets.pipeline.config.PostProcessingOptions;
import com.streamsets.pipeline.config.PostProcessingOptionsChooserValues;
import com.streamsets.pipeline.stage.origin.lib.DataParserFormatConfig;

import java.util.List;

public class FileTailConfigBean {

  @ConfigDefBean(groups = "FILES")
  public DataParserFormatConfig dataFormatConfig = new DataParserFormatConfig();

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.MODEL,
      label = "数据格式",
      description = "文件内容数据格式(注意：含有异常栈信息的Log, Log4j文件不予处理)",
//      label = "Data Format",
//      description = "The data format in the files (IMPORTANT: if Log, Log4j files with stack traces are not handled)",
      displayPosition = 1,
      group = "DATA_FORMAT"
  )
  @ValueChooserModel(DataFormatChooserValues.class)
  public DataFormat dataFormat;

  @ConfigDef(
      required = false,
      type = ConfigDef.Type.STRING,
      label = "多行模式",
      defaultValue = "",
      description = "多行文本正则表达式模式，用于检测含有多行元素的文本文件和日志文件的主干行。请谨慎使用以免影响读性能",
//      label = "Pattern for Multiline",
//      defaultValue = "",
//      description = "RegEx pattern to detect main lines for Text and Log files with multi-line elements. " +
//          "Use only if required as it impacts reading performance",
      displayPosition = 15,
      group = "DATA_FORMAT",
      dependsOn = "dataFormat",
      triggeredByValue = { "TEXT", "LOG" }
  )
  public String multiLineMainPattern;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.NUMBER,
      defaultValue = "1000",
      label = "最大批量大小",
      description = "批量处理中，每批次的最大行数",
//      label = "Maximum Batch Size",
//      description = "Max number of lines that will be sent in a single batch",
      displayPosition = 40,
      group = "FILES",
      min = 0,
      max = Integer.MAX_VALUE
  )
  public int batchSize;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.NUMBER,
      defaultValue = "5",
      label = "批处理等待时间(s)",
      description = "发送批处理前等待的最大时间",
//      label = "Batch Wait Time (secs)",
//      description = " Maximum amount of time to wait to fill a batch before sending it",
      displayPosition = 50,
      group = "FILES",
      min = 1,
      max = Integer.MAX_VALUE
  )
  public int maxWaitTimeSecs;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.MODEL,
      label = "文件",
      description = "",
//      label = "File to Tail",
//      description = "",
      displayPosition  = 60,
      group = "FILES",
      elDefs = PatternEL.class
  )
  @ListBeanModel
  public List<FileInfo> fileInfos;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.BOOLEAN,
      label = "允许延迟目录",
      description = "启用从延迟目录读取，若勾选，数据源则不验证此目录",
//      label = "Allow Late Directories",
//      description = "Enables reading from late-arriving directories." +
//          " When enabled, the origin does not validate configured paths.",
      displayPosition = 70,
      group = "FILES",
      defaultValue = "false"
  )
  public boolean allowLateDirectories = false;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.MODEL,
      defaultValue = "NONE",
      label = "后置处理",
      description = "文件处理完成后执行的操作",
//      label = "File Post Processing",
//      description = "Action to take after processing a file",
      displayPosition = 110,
      group = "POST_PROCESSING"
  )
  @ValueChooserModel(PostProcessingOptionsChooserValues.class)
  public PostProcessingOptions postProcessing;

  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      label = "归档目录",
      description = "归档文件处理完成后存放的目录",
//      label = "Archive Directory",
//      description = "Directory to archive files after they have been processed",
      displayPosition = 200,
      group = "POST_PROCESSING",
      dependsOn = "postProcessing",
      triggeredByValue = "ARCHIVE"
  )
  public String archiveDir;
}
