extern crate multiplier;

use multiplier::multiply;

fn main() {
    println!("3x4 is: {} ", multiply(10, 11).unwrap_or(-1))
}
