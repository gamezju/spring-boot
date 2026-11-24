# SMOKE-1: Automated smoke test

## Goal

Verify that the Cloud Agent workflow can make a small, focused change in this
repository, run the relevant test suite, and complete successfully.

## Scope

- Touch only the existing `spring-boot-smoke-test-simple` module (minimal surface area).
- Add a dedicated `smoke.requirement` configuration property with value `SMOKE-1`.
- Assert the property is loaded when the Spring Boot test context starts.

## Out of scope

- New Gradle modules, dependency changes, or production code changes.
- Full repository `./gradlew check` (too slow for a smoke run).

## Implementation steps

1. Add `smoke.requirement=SMOKE-1` to
   `smoke-test/spring-boot-smoke-test-simple/src/main/resources/application.properties`.
2. Extend `SpringTestSampleSimpleApplicationTests` with a test that injects
   `Environment` and asserts `smoke.requirement` equals `SMOKE-1`.
3. Run `:smoke-test:spring-boot-smoke-test-simple:test`.

## Success criteria

- All tests in `spring-boot-smoke-test-simple` pass.
- The new test fails if the property is missing or has the wrong value.

## Local test run (Cloud Agent)

Attempted command:

`./gradlew :smoke-test:spring-boot-smoke-test-simple:test`

The build could not complete in this environment because `plugins.gradle.org` and
`services.gradle.org` terminate TLS handshakes from the agent pod (Maven Central
works). Gradle 9.9.2 was bootstrapped from the GitHub distribution mirror.
Pull-request CI on GitHub Actions is expected to run the same task successfully.