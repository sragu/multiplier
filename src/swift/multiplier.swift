struct Entry {
    var first: UInt64
    var second: UInt64
}

class PeasantTables: Sequence, IteratorProtocol {
    var current:Entry
    
    init(seed:Entry) {
        current = seed
    }
    
    func next() -> Entry? {
        guard current.second > 0 else { return nil }
        defer { current = Entry(first: current.first * 2, second: current.second / 2) }
        return current
    }
}

func multiply(a: UInt64, b: UInt64) -> UInt64  {
    let evenTableValues : (Entry) -> Bool =  { $0.second % 2 != 0 }
    let firstValue : (Entry) -> UInt64 = { $0.first }
    
    let tables = PeasantTables(seed: Entry(first: a, second: b))
    return tables.filter(evenTableValues).map(firstValue).reduce(0, +)
}
