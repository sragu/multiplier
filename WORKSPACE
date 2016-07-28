maven_jar(
  name = "junit",
  artifact = "junit:junit:4.12",
)

bind(
  name = "junit-jar",
  actual = "@junit//jar"
)

git_repository(
    name = "io_bazel_rules_rust",
    remote = "https://github.com/bazelbuild/rules_rust.git",
    tag = "0.0.2",
)
load("@io_bazel_rules_rust//rust:rust.bzl", "rust_repositories")

rust_repositories()
