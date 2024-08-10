package com.rifkydelta.suitmedia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // MutableLiveData untuk menyimpan input name
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get() = _name

    // MutableLiveData untuk menyimpan input palindrome
    private val _palindrome = MutableLiveData<String>()
    val palindrome: LiveData<String> get() = _palindrome

    // Fungsi untuk update name
    fun setName(input: String) {
        _name.value = input
    }

    // Fungsi untuk update palindrome
    fun setPalindrome(input: String) {
        _palindrome.value = input
    }
}
