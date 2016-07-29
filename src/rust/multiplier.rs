struct Entry {
    first: i64,
    second: i64,
}

struct PeasantTables {
    next: Entry,
}

impl Iterator for PeasantTables {
    type Item = Entry;
    fn next(&mut self) -> Option<Entry> {
        let current = Entry { ..self.next };

        self.next = Entry {
            first: current.first * 2,
            second: current.second / 2,
        };

        match current.second {
            0 => None,
            _ => Some(current),
        }
    }
}

pub fn multiply(a: i64, b: i64) -> i64 {
    let tables = PeasantTables {
        next: Entry {
            first: a,
            second: b,
        },
    };

    tables.filter(|e| e.second % 2 != 0).map(|e| e.first).fold(0, std::ops::Add::add)
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
