package com.ex.droidlist

//class TaskListAdapter(private val clickListener: (Task) -> Unit) :
//        ListAdapter<Task, TaskListAdapter.ViewHolder>(TaskDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return ViewHolder(inflater.inflate(R.layout.item_task_row, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(getItem(position), clickListener)
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bind(task: Task, clickListener: (Task) -> Unit) {
//            itemView.textView_title.text = task.title
////            itemView.setOnClickListener { clickListener(task) }
//        }
//    }
//
//}

//class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
//    override fun areItemsTheSame(p0: Task, p1: Task): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun areContentsTheSame(p0: Task, p1: Task): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun areItemsTheSame(oldItem: Task?, newItem: Task?): Boolean {
//        return oldItem?.id == newItem?.id
//    }
//
//    override fun areContentsTheSame(oldItem: Task?, newItem: Task?): Boolean {
//        return oldItem == newItem
//    }
//}