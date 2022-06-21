package com.ruthwikkk.githubapi.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ruthwikkk.githubapi.R
import com.ruthwikkk.githubapi.data.model.PullRequest
import com.ruthwikkk.githubapi.databinding.ListCellPullRequestBinding

class PullRequestAdapter: PagingDataAdapter<PullRequest, PullRequestAdapter.ViewHolder>(ElementComparator) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            (holder as ViewHolder).bind(position, it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_cell_pull_request, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding: ListCellPullRequestBinding by bindings(itemView)

        fun bind(position: Int, item: PullRequest?) {
            if (item == null)
                return

            binding.tvName.text = item.name
            binding.tvUserName.text = item.user?.login
            Glide.with(itemView.context).load(item.user?.imageUrl).into(binding.ivUser)
            binding.tvDate.text = DateTimeUtils.timeStampToPrettyTime(item.closedAt)

        }
    }

    object ElementComparator : DiffUtil.ItemCallback<PullRequest>() {
        override fun areItemsTheSame(oldItem: PullRequest, newItem: PullRequest) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: PullRequest, newItem: PullRequest) =
            oldItem == newItem
    }
}

inline fun <reified T : ViewDataBinding> bindings(view: View): Lazy<T> =
    lazy {
        requireNotNull(DataBindingUtil.bind<T>(view)) { "Cannot find the matched view to layout." }
    }