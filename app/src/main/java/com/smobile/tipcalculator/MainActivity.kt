package com.smobile.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

  companion object {
    private const val BILL_DEFAULT_VALUE = 0.0
    private const val TIP_DEFAULT_VALUE = 15.0
  }

  //TODO: Uncomment line below after you integrate view binding and add layout tag in activity_main
  //private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    setDefaultBillValue()
    setDefaultTipValue()
  }

  private fun setDefaultBillValue() {
    //TODO: Uncomment line below after you initialize binding variable
    //binding.billEditText.setText(BILL_DEFAULT_VALUE.toString())
  }

  private fun setDefaultTipValue() {
    //TODO: Uncomment line below after you initialize binding variable
    //binding.tipEditText.setText(TIP_DEFAULT_VALUE.toString())
  }

  private fun calculateTip(): Double {
    return getBill() * getTip() / 100.0
  }

  private fun calculateTotal(): Double {
    return getBill() + calculateTip()
  }


  private fun getBill(): Double {
    //TODO: Uncomment line below and remove line 'return 0.0' after you initialize binding variable
    //return binding.billEditText.text.extractDoubleValue()
    return 0.0
  }

  private fun getTip(): Double {
    //TODO: Uncomment line below and remove line 'return 0.0' after you initialize binding variable
    //return binding.tipEditText.text.extractDoubleValue()
    return 0.0
  }

  private fun formatWithCurrency(value: Double): String {
    val format = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 1
    format.currency = Currency.getInstance(Locale.getDefault())
    return format.format(value)
  }

}