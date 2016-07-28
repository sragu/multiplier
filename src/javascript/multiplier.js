import _ from 'lodash'
export function multiplier () {
  function entry (a, b) {
    return {
      'first': a,
      'second': b
    }
  }

  /** Generator for peasantTables */
  function * peasantTables (a, b) {
    yield entry(a, b)

    while (b > 0) {
      yield entry(a = a * 2, b = Math.floor(b / 2))
    }
  }

  return {
    multiply: function (a, b) {
      let entries = Array.from(peasantTables(a, b))

      let skipEvenValues = e => e.second % 2 !== 0
      let resultValue = e => e.first

      return _(entries).filter(skipEvenValues).map(resultValue).sum()
    }
  }
}
