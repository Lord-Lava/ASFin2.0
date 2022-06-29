package com.lava.asfin20.presentation.studentdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.lava.asfin20.domain.model.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudentDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    val student = savedStateHandle.get<Student>("student")
}