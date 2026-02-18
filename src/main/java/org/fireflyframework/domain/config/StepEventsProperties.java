/*
 * Copyright 2024-2026 Firefly Software Solutions Inc
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

package org.fireflyframework.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration properties for SAGA Step Events.
 * <p>
 * Step Events from lib-transactional-engine are published through fireflyframework-eda's
 * EventPublisher infrastructure via the StepEventPublisherBridge. This allows step
 * events to leverage all EDA features including multi-platform support, resilience
 * patterns, metrics, and health checks.
 */
@Validated
@ConfigurationProperties(prefix = "firefly.domain.stepevents")
@Data
public class StepEventsProperties {

    /**
     * Whether Step Events are enabled.
     * <p>
     * When enabled, the StepEventPublisherBridge will be configured to publish
     * step events through the EDA infrastructure.
     * <p>
     * Default: true
     */
    private boolean enabled = true;

    /**
     * The default topic/destination for step events.
     * <p>
     * This topic will be used when a step event doesn't specify its own topic.
     * The actual messaging platform (Kafka, RabbitMQ, etc.) is determined by
     * the fireflyframework-eda configuration.
     * <p>
     * Default: "domain-layer"
     */
    private String topic = "domain-layer";
}
