package com.lava.asfin20.util

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.lava.asfin20.domain.model.Student

@BindingAdapter("name")
fun AppCompatTextView.setStudentName(item: Student?) {
    item?.let {
        text = item.name
    }
}

@BindingAdapter("serialnumber")
fun AppCompatTextView.setStudentSerialNumber(item: Student?) {
    item?.let {
        text = item.serialnumber.toString()
    }
}

@BindingAdapter("score")
fun AppCompatTextView.setStudentScore(item: Student?) {
    item?.let {
        text = item.score.toString()
    }
}

