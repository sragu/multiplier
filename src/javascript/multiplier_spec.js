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
