/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.onetable.hudi.sync;

import java.io.Serializable;
import java.util.Properties;

import org.apache.hudi.common.config.ConfigProperty;
import org.apache.hudi.sync.common.HoodieSyncConfig;

public class OneTableSyncConfig extends HoodieSyncConfig implements Serializable {

  public static final ConfigProperty<String> ONE_TABLE_FORMATS =
      ConfigProperty.key("hoodie.onetable.formats.to.sync")
          .defaultValue("DELTA,ICEBERG")
          .withDocumentation("Comma separated list of formats to sync.");

  public static final ConfigProperty<Integer> ONE_TABLE_TARGET_METADATA_RETENTION_HOURS =
      ConfigProperty.key("hoodie.onetable.target.metadata.retention.hr")
          .defaultValue(24 * 7)
          .withDocumentation("Retention in hours for metadata in target table.");

  public OneTableSyncConfig(Properties props) {
    super(props);
  }
}
