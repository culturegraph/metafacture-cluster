/*
 *  Copyright 2013 Deutsche Nationalbibliothek
 *
 *  Licensed under the Apache License, Version 2.0 the "License";
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.culturegraph.mf.cluster.util;

import java.io.IOException;
import java.util.UUID;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public final class MapReduceUtil {
	private MapReduceUtil() {
		// no instances
	}

	public static String makeTmp(final Configuration configuration) throws IOException {
		final String temporary = "tmp/" + UUID.randomUUID() + "/";
		final Path tmp = new Path(temporary);
		final FileSystem fileSystem = tmp.getFileSystem(configuration);
		fileSystem.mkdirs(tmp);
		fileSystem.deleteOnExit(tmp);
		return temporary;
	}
}
