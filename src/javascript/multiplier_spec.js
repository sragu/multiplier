import 'babel-polyfill'

/* global describe, it */
import { multiplier } from './multiplier'
import { expect } from 'chai'

describe('multiplier', () => {
  it('should multiply', () => {
    var m = multiplier()
    var result = m.multiply(3, 4)

    expect(result).to.equal(12)
  })
})

describe('multiply()', () => {
  var tests = [
    {
      args: [30, 3],
      expected: 90
    },
    {
      args: [0, 21],
      expected: 0
    },
    {
      args: [100, 0],
      expected: 0
    }, {
      args: [300, 30],
      expected: 9000
    }
  ]

  var m = multiplier()

  tests.forEach(function (test) {
    it('correctly muliplies ' + test.args + ' to ' + test.expected, () => {
      var res = m.multiply.apply(null, test.args)
      expect(res).to.equal(test.expected)
    })
  })
})
