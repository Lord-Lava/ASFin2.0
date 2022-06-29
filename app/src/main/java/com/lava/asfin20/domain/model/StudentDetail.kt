package com.lava.asfin20.domain.model

import com.lava.asfin20.data.remote.dto.Name

data class StudentDetail (
    val data: List<Name>,
    val nextPage: String
)