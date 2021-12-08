package com.arvind.demoappbottom.viewmodel.notification

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel
@Inject constructor(application: Application) :
    AndroidViewModel(application) {


}