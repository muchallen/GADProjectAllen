package com.example.gadprojectallen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gadprojectallen.R
import com.example.gadprojectallen.models.Learner
import com.example.gadprojectallen.models.Skill

class LeanersAdapter(val c: FragmentActivity?, val learners: ArrayList<Learner>?) : RecyclerView.Adapter<LeanersAdapter.MyHolder2>() {



    class MyHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView =itemView.findViewById(R.id.txtName);
        var country: TextView = itemView.findViewById(R.id.txtCountry)
    }

    override fun getItemCount(): Int {
        if(learners==null){
            return 0;
        }else{
            return learners?.size!!}
    }



    override fun onBindViewHolder(holder: MyHolder2, position: Int) {
        holder.name.setText(learners?.get(position)?.name)
        holder.country.setText(learners?.get(position)?.hours.toString()+" Learning hours,"+learners?.get(position)?.country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder2 {
        var view:View = LayoutInflater.from(c).inflate(R.layout.itemlearners,parent,false)
        return LeanersAdapter.MyHolder2(view);
    }
}