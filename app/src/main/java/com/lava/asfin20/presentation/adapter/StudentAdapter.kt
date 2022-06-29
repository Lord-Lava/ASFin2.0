package com.lava.asfin20.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lava.asfin20.databinding.ItemStudentBinding
import com.lava.asfin20.domain.model.Student

class StudentAdapter(
    private val clickListener: StudentListener,
) : ListAdapter<Student, RecyclerView.ViewHolder>(StudentDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val studentItem = getItem(position)
                holder.bind(studentItem, clickListener)
            }
        }
    }

    class ViewHolder private constructor(
        private val binding: ItemStudentBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Student, clickListener: StudentListener) {
            binding.student = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemStudentBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class StudentDiffCallBack : DiffUtil.ItemCallback<Student>() {
    override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem.serialnumber == newItem.serialnumber
    }

    override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem == newItem
    }
}

class StudentListener(
    val clickListener: (student: Student, score: String) -> Unit,
) {
    fun onClick(student: Student, score: String) = clickListener(student, score)
}