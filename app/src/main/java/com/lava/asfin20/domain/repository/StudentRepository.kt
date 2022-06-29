package com.lava.asfin20.domain.repository

import com.lava.asfin20.data.remote.dto.StudentDetailDto
import com.lava.asfin20.util.Resource

interface StudentRepository {
    suspend fun getStudentsDetails(pageNumber: String): Resource<StudentDetailDto>
}