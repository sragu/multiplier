export function multiplier () {

  /** Generator for peasantTables */
  function * peasantTables (a, b) {
    yield [a, b]

    while (b > 0) {
      yield [a = a * 2, b = Math.floor(b / 2)]
    }
  }

  function valueOfEntry (first, second) {
    return (second % 2 === 0) ? 0 : first
  }

  return {
    multiply: function (a, b) {
      var result = 0
      for (let [first, second] of peasantTables(a, b)) {
        // console.log([first, second])
        result += valueOfEntry(first, second)
      }
      return result
    }
  }
}
