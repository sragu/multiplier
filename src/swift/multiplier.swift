struct Entry {
    let first: UInt64
    let second: UInt64
}

class PeasantTables: Sequence, IteratorProtocol {
    var current: Entry

    init(seed: Entry) {
        current = seed
    }

    func next() -> Entry? {
        guard current.second > 0 else { return nil }
        defer { current = Entry(first: current.first * 2, second: current.second / 2) }
        return current
    }
}

func multiply(_ one: UInt64, _ another: UInt64) -> UInt64 {
    let skipEvenTables: (Entry) -> Bool = { $0.second % 2 != 0 }
    let collectFirst: (Entry) -> UInt64 = { $0.first }

    let tables = PeasantTables(seed: Entry(first: one, second: another))
    return tables.filter(skipEvenTables).map(collectFirst).reduce(0, +)
}
