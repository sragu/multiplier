maven_jar(
  name = "junit",
  artifact = "junit:junit:4.12",
)

bind(
  name = "junit-jar",
  actual = "@junit//jar"
)

http_archive(
    name = "io_bazel_rules_rust",
    sha256 = "615639cfd5459fec4b8a5751112be808ab25ba647c4c1953d29bb554ef865da7",
    strip_prefix = "rules_rust-0.0.6",
    urls = [
        "http://bazel-mirror.storage.googleapis.com/github.com/bazelbuild/rules_rust/archive/0.0.6.tar.gz",
        "https://github.com/bazelbuild/rules_rust/archive/0.0.6.tar.gz",
    ],
)

load("@io_bazel_rules_rust//rust:repositories.bzl", "rust_repositories")

rust_repositories()

git_repository(
    name = "bazel_skylib",
    remote = "https://github.com/bazelbuild/bazel-skylib.git",
    tag = "0.3.1",
)

git_repository(
    name = "build_bazel_rules_apple",
    remote = "https://github.com/bazelbuild/rules_apple.git",
    tag = "0.5.0",
)
