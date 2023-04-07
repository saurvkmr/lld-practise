package org.wolt.com.validator

interface IValidator<T> {
  fun isValid(data: T): Boolean
}