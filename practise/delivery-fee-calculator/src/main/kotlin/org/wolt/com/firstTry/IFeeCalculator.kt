package org.wolt.com.firstTry

interface IFeeCalculator<T> {
  fun calculate(details: T): Number
}