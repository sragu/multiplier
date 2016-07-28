package(default_visibility = ["//visibility:private"])

load(
    "@io_bazel_rules_rust//rust:rust.bzl",
    "rust_library",
    "rust_test",
    "rust_binary",
)

rust_library(
    name = "multiplier",
    srcs = [
        "multiplier.rs",
    ],
)

rust_test(
    name = "multiplier_test",
    deps = [":multiplier"],
    size = "small",
)

rust_binary(
    name = "multiplier_main",
    srcs = ["main.rs"],
    deps = [":multiplier"],
)
