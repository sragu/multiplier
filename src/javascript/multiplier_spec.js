import { multiplier } from './multiplier'
import { expect } from 'chai'

describe('multiplier', function(){

it('should multiply', function(){
  var m = multiplier()
  var result = m.multiply(3,4)

  expect(result).to.equal(12)
})

})
