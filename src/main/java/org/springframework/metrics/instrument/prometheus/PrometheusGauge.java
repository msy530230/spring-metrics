/**
 * Copyright 2017 Pivotal Software, Inc.
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
package org.springframework.metrics.instrument.prometheus;

import org.springframework.metrics.instrument.Gauge;

public class PrometheusGauge implements Gauge {
    private final String name;
    private io.prometheus.client.Gauge.Child gauge;

    public PrometheusGauge(String name, io.prometheus.client.Gauge.Child gauge) {
        this.name = name;
        this.gauge = gauge;
    }

    @Override
    public double value() {
        return gauge.get();
    }

    @Override
    public String getName() {
        return name;
    }
}
