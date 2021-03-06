/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.airavata.mft.resource.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.airavata.mft.resource.service.ResourceServiceGrpc;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceServiceClient {

    private static Map<String, Map<Integer, ResourceServiceGrpc.ResourceServiceBlockingStub>> stubCache = new ConcurrentHashMap<>();

    public static ResourceServiceGrpc.ResourceServiceBlockingStub buildClient(String hostName, int port) {

        if (stubCache.containsKey(hostName)) {
            if (stubCache.get(hostName).containsKey(port)) {
                return stubCache.get(hostName).get(port);
            }
        }

        ManagedChannel channel = ManagedChannelBuilder.forAddress(hostName, port).usePlaintext().build();
        ResourceServiceGrpc.ResourceServiceBlockingStub stub = ResourceServiceGrpc.newBlockingStub(channel);
        stubCache.put(hostName, Collections.singletonMap(port, stub));
        return stub;
    }
}
