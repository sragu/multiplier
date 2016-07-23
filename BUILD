java_library(
  name = "multiply",
  srcs = glob(["src/Multiplier.java"])
)

java_test(
  name = "multiply-test",
  srcs = glob(["src/MultiplierTest.java"]),
  test_class = "MultiplierTest",
  size = "small",
  deps = [
    ":multiply",
    "//external:junit-jar",
  ],
)

java_binary(
  name = "multiply-main",
  main_class = "Main",
  srcs = glob(["src/Main.java"]),
  deps = [
    ":multiply",
  ],
)
