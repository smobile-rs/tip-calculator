package com.smobile.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.smobile.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

  companion object {
    private const val BILL_DEFAULT_VALUE = 0.0
    private const val TIP_DEFAULT_VALUE = 15.0
  }

  private lateinit var binding: ActivityMainBinding

  private val updateTipCalculator: (CharSequence?, Int, Int, Int) -> Unit = { _, _, _, _ ->
    binding.tip = formatWithCurrency(calculateTip())
    binding.total = formatWithCurrency(calculateTotal())
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.billEditText.doOnTextChanged(updateTipCalculator)
    binding.tipEditText.doOnTextChanged(updateTipCalculator)

    setDefaultBillValue()
    setDefaultTipValue()
  }

  private fun setDefaultBillValue() = binding.billEditText.setText(BILL_DEFAULT_VALUE.toString())
  private fun setDefaultTipValue() = binding.tipEditText.setText(TIP_DEFAULT_VALUE.toString())

  private fun calculateTip(): Double {
    return getBill() * getTip() / 100.0
  }

  private fun calculateTotal(): Double {
    return getBill() + calculateTip()
  }

  private fun getBill() = binding.billEditText.text.extractDoubleValue()
  private fun getTip() = binding.tipEditText.text.extractDoubleValue()

  private fun formatWithCurrency(value: Double): String {
    val format = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 1
    format.currency = Currency.getInstance(Locale.getDefault())
    return format.format(value)
  }

}