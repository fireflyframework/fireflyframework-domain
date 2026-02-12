# Firefly Framework - Domain

[![CI](https://github.com/fireflyframework/fireflyframework-domain/actions/workflows/ci.yml/badge.svg)](https://github.com/fireflyframework/fireflyframework-domain/actions/workflows/ci.yml)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21%2B-orange.svg)](https://openjdk.org)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)](https://spring.io/projects/spring-boot)

> Domain-driven design library enabling DDD patterns with reactive programming, CQRS, and SAGA orchestration support.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Quick Start](#quick-start)
- [Configuration](#configuration)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license)

## Overview

Firefly Framework Domain provides the foundational building blocks for domain-driven design (DDD) in reactive Spring Boot microservices. It serves as the bridge layer that connects the core framework infrastructure with business domain implementations.

The module includes auto-configuration for JSON structured logging and step event bridge configuration for the transactional engine. It enables domain services to participate in SAGA orchestrations and CQRS command/query flows while maintaining clean separation between domain logic and infrastructure concerns.

This library is typically used in domain-layer microservices that implement business logic following DDD patterns and need integration with the framework's transactional engine and event-driven architecture.

## Features

- Domain-driven design building blocks for reactive microservices
- JSON structured logging auto-configuration
- Step event publisher bridge for transactional engine integration
- Configurable step event properties
- Clean separation between domain and infrastructure layers
- Reactive programming support with Project Reactor

## Requirements

- Java 21+
- Spring Boot 3.x
- Maven 3.9+

## Installation

```xml
<dependency>
    <groupId>org.fireflyframework</groupId>
    <artifactId>fireflyframework-domain</artifactId>
    <version>26.02.03</version>
</dependency>
```

## Quick Start

```java
@Service
public class AccountDomainService {

    private final StepEventPublisherBridge stepEvents;

    public AccountDomainService(StepEventPublisherBridge stepEvents) {
        this.stepEvents = stepEvents;
    }

    public Mono<Account> createAccount(CreateAccountRequest request) {
        return validateRequest(request)
            .flatMap(this::persistAccount)
            .flatMap(account -> stepEvents.publish("account-created", account)
                .thenReturn(account));
    }
}
```

## Configuration

```yaml
firefly:
  domain:
    json-logging:
      enabled: true
    step-events:
      enabled: true
```

## Documentation

No additional documentation available for this project.

## Contributing

Contributions are welcome. Please read the [CONTRIBUTING.md](CONTRIBUTING.md) guide for details on our code of conduct, development process, and how to submit pull requests.

## License

Copyright 2024-2026 Firefly Software Solutions Inc.

Licensed under the Apache License, Version 2.0. See [LICENSE](LICENSE) for details.
