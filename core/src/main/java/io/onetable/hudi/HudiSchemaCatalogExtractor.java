/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.onetable.hudi;

import java.util.HashMap;
import java.util.Map;

import org.apache.hudi.common.table.HoodieTableMetaClient;

import io.onetable.model.OneTable;
import io.onetable.model.schema.OneSchema;
import io.onetable.model.schema.SchemaCatalog;
import io.onetable.model.schema.SchemaVersion;
import io.onetable.spi.extractor.SchemaCatalogExtractor;

/** Implementation of {@link SchemaCatalogExtractor} for Hudi. */
public class HudiSchemaCatalogExtractor implements SchemaCatalogExtractor<HoodieTableMetaClient> {
  @Override
  public SchemaCatalog catalog(HoodieTableMetaClient table) {
    // TODO implement this
    throw new UnsupportedOperationException("Schema catalog extractor not implemented for Hudi");
  }

  public static SchemaCatalog catalogWithTableSchema(OneTable table) {
    // does not support schema versions for now
    Map<SchemaVersion, OneSchema> schemas = new HashMap<>();
    SchemaVersion schemaVersion = new SchemaVersion(1, "");
    schemas.put(schemaVersion, table.getReadSchema());
    return SchemaCatalog.builder().schemas(schemas).build();
  }
}
