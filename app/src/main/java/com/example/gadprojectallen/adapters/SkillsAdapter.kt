package com.example.gadprojectallen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gadprojectallen.R
import com.example.gadprojectallen.models.Skill

class SkillsAdapter(val c: FragmentActivity?, val skills: ArrayList<Skill>?) : RecyclerView.Adapter<SkillsAdapter.MyHolder>() {



    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name:TextView =itemView.findViewById(R.id.txtName);
        var country:TextView = itemView.findViewById(R.id.txtCountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view:View = LayoutInflater.from(c).inflate(R.layout.item,parent,false)
        return MyHolder(view);
    }



    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.setText(skills?.get(position)?.name)
        holder.country.setText(skills?.get(position)?.score.toString()+" skill IQ Score,"+skills?.get(position)?.country)
    }

    override fun getItemCount(): Int {
        if(skills==null){
            return 0;
        }else{
       return skills?.size!!}
    }
}