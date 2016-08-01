import XCTest
@testable import multiplier

class MultiplierTests: XCTestCase {
    func testMultiplication() {
        XCTAssertEqual(multiplier.multiply(3, 4), 12)
        XCTAssertEqual(multiplier.multiply(30, 4), 120)
        XCTAssertEqual(multiplier.multiply(3, 40), 120)
    }

    func testMultiplicationEdgeCases() {
        XCTAssertEqual(multiplier.multiply(0, 0), 0)
        XCTAssertEqual(multiplier.multiply(0, 5), 0)
        XCTAssertEqual(multiplier.multiply(43, 0), 0)
        XCTAssertEqual(multiplier.multiply(1, 1), 1)
    }

    static var allTests: [(String, (MultiplierTests) -> () throws -> Void)] {
        return [
            ("testMultiplication", testMultiplication),
            ("testMultiplicationEdgeCases", testMultiplicationEdgeCases)
        ]
    }
}
