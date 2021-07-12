
package com.codingwithmitch.account.presentation.account

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class AccountViewModel
@Inject
constructor(
    @Named("accountString") val value: String,
): ViewModel(){

}