open OUnit;;

let multiply () = assert_equal 63 (Multiplier.multiply 21 3);;

let multiply_edge_case () =
  assert_equal 0 (Multiplier.multiply 21 0);
  assert_equal 0 (Multiplier.multiply 0 432);
  assert_equal 243 (Multiplier.multiply 243 1);
  assert_equal 20 (Multiplier.multiply 1 20);;


let multiplier_tests =
  "multiplier">:::
    ["multiply">:: multiply; "multiply_edge_case">:: multiply_edge_case;]
;;

let _ =
  run_test_tt_main multiplier_tests
;;
