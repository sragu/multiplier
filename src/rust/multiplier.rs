pub fn multiply(a: i64, b: i64) -> i64 {
    a * b
}

#[cfg(test)]
mod tests {
    use super::multiply;

    #[test]
    fn test_multiplier() {
        assert_eq!(12, multiply(3, 4));
        assert_eq!(0, multiply(3, 0));
        assert_eq!(0, multiply(0, 44));
        assert_eq!(1500, multiply(300, 5));
    }
}
