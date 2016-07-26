java_library(
  name = "multiply",
  srcs = glob(["Multiplier.java"])
)

java_test(
  name = "multiply-test",
  srcs = glob(["MultiplierTest.java"]),
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
  srcs = glob(["Main.java"]),
  deps = [
    ":multiply",
  ],
)
