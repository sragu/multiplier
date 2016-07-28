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

      const isEven = e => e.second % 2 === 0
      const getFirst = e => e.first
      const rejectEntriesWithEvenValues = _.curryRight(_.reject)(isEven)
      const sumFirstColumn =  _.flow([_.curryRight(_.map)(getFirst), _.sum])

      return _.flow([rejectEntriesWithEvenValues, sumFirstColumn])(entries)
    }
  }
}
