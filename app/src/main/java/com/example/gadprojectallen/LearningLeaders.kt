package com.example.gadprojectallen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gadprojectallen.`interface`.GAD
import com.example.gadprojectallen.adapters.LeanersAdapter
import com.example.gadprojectallen.adapters.SkillsAdapter
import com.example.gadprojectallen.models.Learner
import com.example.gadprojectallen.models.Learners
import com.example.gadprojectallen.models.Skill
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LearningLeaders : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v:View = inflater.inflate(R.layout.fragment_learning_leaders, container, false);


        populateSkills(v);



        return v;
    }

    private fun populateSkills(view:View) {


        var retrofit = Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var skillsInterface: GAD = retrofit.create(GAD::class.java);
        var skillsCall: Call<Learners> = skillsInterface.getLearners();



        skillsCall.enqueue(object: Callback<Learners> {
            override fun onFailure(call: Call<Learners>, t: Throwable) {
                Toast.makeText(getActivity(),t.message, Toast.LENGTH_LONG).show();
            }

            override fun onResponse(call: Call<Learners>, response: Response<Learners>) {
                if(!response.isSuccessful){
                    Toast.makeText(getActivity(),"Failed Please Retry", Toast.LENGTH_SHORT).show();
                }else
                {
                    response.body()
                    var topLearners:ArrayList<Learner>? = response.body();
                    var recycler: RecyclerView = view.findViewById(R.id.rvitems);

                    var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(getActivity(),
                        LinearLayoutManager.VERTICAL,false);
                    recycler.setLayoutManager(layoutManager);
                    var adapter = LeanersAdapter(getActivity(),topLearners)
                    recycler.setAdapter(adapter)
                    Toast.makeText(getActivity(), topLearners?.get(1)?.toString(), Toast.LENGTH_SHORT).show();
                }
            }

        })

    }

}