import XCTest
@testable import multiplier

class multiplierTests: XCTestCase {
    func testMultiplication() {
        XCTAssertEqual(multiplier.multiply(a:3, b:4), 12)
        XCTAssertEqual(multiplier.multiply(a:30, b:4), 120)
        XCTAssertEqual(multiplier.multiply(a:3, b:40), 120)
    }

    func testMultiplicationEdgeCases() {
        XCTAssertEqual(multiplier.multiply(a:0, b:0), 0)
        XCTAssertEqual(multiplier.multiply(a:0, b:5), 0)
        XCTAssertEqual(multiplier.multiply(a:43, b:0), 0)
        XCTAssertEqual(multiplier.multiply(a:1, b:1), 1)
    }

    static var allTests: [(String, (multiplierTests) -> () throws -> Void)] {
        return [
            ("testMultiplication", testMultiplication),
            ("testMultiplicationEdgeCases", testMultiplicationEdgeCases)
        ]
    }
}
