# Quarkus Isolated Projects Issue Reproducer

Simple multi-project Gradle build demonstrating Quarkus plugin incompatibility with Gradle's Isolated Projects feature.

## Problem

When enabling Gradle 9.7+ `org.gradle.isolated-projects=true`, the Quarkus Gradle plugin fails with cross-project access violations and `ConcurrentModificationException`.

## How to Reproduce

```bash
# Default build (works)
./gradlew help

# With isolated projects (fails)
./gradlew -Dorg.gradle.isolated-projects=true help
```

Expected: Both succeed
Actual: Second command fails with cross-project access violations

## Build Structure

```
.
├── shared-lib/          # Shared Kotlin library
│   └── build.gradle.kts
├── quarkus-app/         # Quarkus application
│   └── build.gradle.kts
├── settings.gradle.kts  # Multi-project configuration
└── build.gradle.kts     # Root build
```

## Error Messages

```
- Plugin 'io.quarkus': Project ':quarkus-app' cannot access 'Project.gradle' functionality on another project ':'
- java.util.ConcurrentModificationException when creating domain objects in configuration container
```

## Environment

- **Gradle**: 9.7.0
- **Quarkus**: 3.39.0 (or later)
- **Java**: 25+
- **Kotlin**: 2.4.0

## Related

- Gradle Isolated Projects: https://docs.gradle.org/9.7.0/userguide/isolated_projects.html
- Issue filed with Quarkus: https://github.com/quarkusio/quarkus/issues/56145
