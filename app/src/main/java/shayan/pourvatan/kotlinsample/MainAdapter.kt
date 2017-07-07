package shayan.pourvatan.kotlinsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by shayan on 7/6/17.
 */
class MainAdapter(context: Context, var stringList: MutableList<String>?) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemCount(): Int {
        return stringList?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(layoutInflater.inflate(R.layout.row_adapter, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.onBind()
    }


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.row_tv) as TextView

        fun onBind() {
            textView.text = stringList?.get(adapterPosition)
        }
    }

}




















