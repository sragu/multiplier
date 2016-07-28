function * peasantTables (a, b) {
  if (b > 0) {
    yield [a * 2, b / 2]
  }
}


export function multiplier () {
  return {
    multiply: function (a, b) {
      return a * b
    }
  }
}
