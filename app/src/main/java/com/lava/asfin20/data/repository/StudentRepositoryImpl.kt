package com.lava.asfin20.data.repository

import com.lava.asfin20.data.remote.services.AspireApi
import com.lava.asfin20.domain.repository.StudentRepository
import com.lava.asfin20.util.safeApiCall
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val api: AspireApi,
) : StudentRepository {

    override suspend fun getStudentsDetails(pageNumber: String) =
        safeApiCall { api.getStudentDetails(pageNumber) }
}