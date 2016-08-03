
struct Entry {
    first: u64,
    second: u64,
}

struct PeasantTables {
    next: Entry,
}

impl Iterator for PeasantTables {
    type Item = Entry;
    fn next(&mut self) -> Option<Entry> {
        let current = Entry { ..self.next };

        self.next = Entry {
            first: current.first.saturating_mul(2),
            second: current.second / 2,
        };

        match current.second {
            0 => None,
            _ => Some(current),
        }
    }
}

pub fn multiply(a: u64, b: u64) -> Option<u64> {
    let tables = PeasantTables {
        next: Entry {
            first: a,
            second: b,
        },
    };

    return tables.filter(|e| e.second % 2 != 0)
        .map(|e| e.first)
        .fold(Some(0), |a, c| {
            println!("{:?}, {}, {}", a, c, std::u64::MAX);

            if a.is_none() || c == std::u64::MAX {
                None
            } else {
                a.unwrap().checked_add(c)
            }
        });
}

#[cfg(test)]
mod tests {
    use super::multiply;
    use std::u64::MAX;

    #[test]
    fn test_multiplier() {
        assert_eq!(multiply(3, 2), Some(6));
        assert_eq!(multiply(3, 4), Some(12));
        assert_eq!(multiply(3, 0), Some(0));
        assert_eq!(multiply(0, 44), Some(0));
        assert_eq!(multiply(300, 5), Some(1500));
        assert_eq!(multiply(MAX, 2), None)
    }
}
