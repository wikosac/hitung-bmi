package org.d3if4401.hitungbmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if4401.hitungbmi.model.HasilBmi
import org.d3if4401.hitungbmi.model.KategoriBmi

class MainViewModel : ViewModel() {
    private val hasilBmi = MutableLiveData<HasilBmi?>()

    fun hitungBmi(berat: Float, tinggi: Float, isMale: Boolean) {
        val tinggiCm = tinggi / 100
        val bmi = berat / (tinggiCm * tinggiCm)
        val kategori = getKategori(bmi, isMale)
        hasilBmi.value = HasilBmi(bmi, kategori)
    }

    private fun getKategori(bmi: Float, isMale: Boolean): KategoriBmi {
        val kategori = if (isMale) {
            when {
                bmi < 20.5 -> KategoriBmi.KURUS
                bmi >= 27.0 -> KategoriBmi.GEMUK
                else -> KategoriBmi.IDEAL
            }
        } else {
            when {
                bmi < 18.5 -> KategoriBmi.KURUS
                bmi >= 25.0 -> KategoriBmi.GEMUK
                else -> KategoriBmi.IDEAL
            }
        }
        return kategori
    }

    fun getHasilBmi(): LiveData<HasilBmi?> = hasilBmi
}