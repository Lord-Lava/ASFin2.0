package com.lava.asfin20.presentation.studentdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import com.lava.asfin20.R
import com.lava.asfin20.databinding.FragmentStudentDetailBinding
import com.lava.asfin20.domain.model.Student
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StudentDetailFragment : Fragment() {

    private val viewModel: StudentDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding: FragmentStudentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_student_detail, container, false)

        binding.student = viewModel.student

        binding.lifecycleOwner = this

        return binding.root
    }

}