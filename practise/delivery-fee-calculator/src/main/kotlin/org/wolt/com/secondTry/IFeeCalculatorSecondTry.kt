package org.wolt.com.secondTry

interface IFeeCalculatorSecondTry<T> {
  fun calculate(details: T): T
}