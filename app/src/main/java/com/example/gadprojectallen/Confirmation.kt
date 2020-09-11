package com.example.gadprojectallen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.gadprojectallen.R
import com.example.gadprojectallen.`interface`.GAD
import com.example.gadprojectallen.models.Submit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Confirmation(val submit:Submit) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: View = inflater.inflate(R.layout.sure, container, false);
        val yes: Button = v.findViewById(R.id.yes);
        val cancel: Button = v.findViewById(R.id.cancelbtn);

        yes.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                postData(submit)
            }

        })
        cancel.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                getFragmentManager()?.popBackStack();
            }

        })

        return v;
    }

    private fun postData(data: Submit) {
    //https://github.com/muchallen/GADProjectAllen.git
        var retrofit = Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var submitInterface: GAD = retrofit.create(GAD::class.java);
        var submitCall: Call<Submit> = submitInterface.submitData(data.firstName,data.lastName,data.email,data.github)

        submitCall.enqueue(object : Callback<Submit> {


            override fun onFailure(call: Call<Submit>, t: Throwable) {
                val fm = fragmentManager;
                val fragment: Fragment = Failed();
                val ft: FragmentTransaction? = fm?.beginTransaction();
                ft?.replace(R.id.submitLayout,fragment);
                ft?.addToBackStack(null)
                ft?.commit();
            }
            override fun onResponse(call: Call<Submit>, response: Response<Submit>) {
                if(!response.isSuccessful){
                    val fm = fragmentManager;
                    val fragment: Fragment = Failed();
                    val ft: FragmentTransaction? = fm?.beginTransaction();
                    ft?.replace(R.id.submitLayout,fragment);
                    ft?.addToBackStack(null)
                    ft?.commit();
                    return
                }else {
                    val fm = fragmentManager;
                    val fragment: Fragment = Success();
                    val ft: FragmentTransaction? = fm?.beginTransaction();
                    ft?.replace(R.id.submitLayout, fragment);
                    ft?.addToBackStack(null)
                    ft?.commit();
                    return
                }
            }

        });

    }


}