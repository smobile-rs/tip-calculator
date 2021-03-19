package com.smobile.tipcalculator

import android.text.Editable

fun Editable?.extractDoubleValue() = this?.toString().let {
  if (it.isNullOrEmpty()) {
    0.0
  } else {
    it.toDouble()
  }
}