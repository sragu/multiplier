java_library(
  name = "multiplier",
  srcs = glob(["Multiplier.java"])
)

java_test(
  name = "multiplier_test",
  srcs = glob(["MultiplierTest.java"]),
  test_class = "MultiplierTest",
  size = "small",
  deps = [
    ":multiplier",
    "//external:junit-jar",
  ],
)

java_binary(
  name = "multiplier_main",
  main_class = "Main",
  srcs = glob(["Main.java"]),
  deps = [
    ":multiplier",
  ],
)
