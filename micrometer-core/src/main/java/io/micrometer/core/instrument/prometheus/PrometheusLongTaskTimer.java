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
package io.micrometer.core.instrument.prometheus;

import io.micrometer.core.instrument.LongTaskTimer;
import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.util.MeterId;

import java.util.List;

public class PrometheusLongTaskTimer implements LongTaskTimer {
    private final MeterId id;
    private final CustomPrometheusLongTaskTimer.Child timer;

    PrometheusLongTaskTimer(MeterId id, CustomPrometheusLongTaskTimer.Child timer) {
        this.id = id;
        this.timer = timer;
    }

    @Override
    public long start() {
        return timer.start();
    }

    @Override
    public long stop(long task) {
        return timer.stop(task);
    }

    @Override
    public long duration(long task) {
        return timer.duration(task);
    }

    @Override
    public long duration() {
        return timer.duration();
    }

    @Override
    public int activeTasks() {
        return timer.activeTasks();
    }

    @Override
    public String getName() {
        return id.getName();
    }

    @Override
    public Iterable<Tag> getTags() {
        return id.getTags();
    }

    @Override
    public List<Measurement> measure() {
        return timer.measure();
    }
}
