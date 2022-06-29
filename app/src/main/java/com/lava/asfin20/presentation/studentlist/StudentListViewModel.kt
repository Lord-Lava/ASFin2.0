package com.lava.asfin20.presentation.studentlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lava.asfin20.data.remote.dto.StudentDetailDto
import com.lava.asfin20.domain.model.Student
import com.lava.asfin20.domain.model.StudentDetail
import com.lava.asfin20.domain.repository.StudentRepository
import com.lava.asfin20.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentListViewModel @Inject constructor(
    private val repository: StudentRepository,
) : ViewModel() {

    var pageNumber = "0"

    private val _response = MutableLiveData<Resource<StudentDetailDto>>()
    val response = _response as LiveData<Resource<StudentDetailDto>>

    var studentList : ArrayList<Student> = ArrayList()

    private val _navigateToStudentDetailFragment = MutableLiveData<Student>()
    val navigateToStudentDetailFragment = _navigateToStudentDetailFragment as LiveData<Student>

    init {
        if (studentList.isEmpty()) getStudentsResponse(pageNumber)
    }

    fun getStudentsResponse(pageNumber: String) {
        viewModelScope.launch {
            _response.value = Resource.Loading
            _response.value = repository.getStudentsDetails(pageNumber)
        }
    }

    fun updateStudentList(studentDetails: StudentDetail) {
        val students: ArrayList<Student> = ArrayList()
        studentDetails.data.let { list ->
            list.forEach {
                students.add(Student(it.serialnumber, it.name))
            }
        }
        studentList.addAll(students)
    }

    fun onStudentClicked(student: Student) {
        _navigateToStudentDetailFragment.value = student
    }

    fun onStudentDetailNavigated() {
        _navigateToStudentDetailFragment.value = null
    }
}