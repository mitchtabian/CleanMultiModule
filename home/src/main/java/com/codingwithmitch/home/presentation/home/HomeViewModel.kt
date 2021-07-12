package com.codingwithmitch.home.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    @Named("homeString") val value: String,
): ViewModel() {

}













