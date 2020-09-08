package com.example.gadprojectallen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SubMenu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.gadprojectallen.`interface`.GAD
import com.example.gadprojectallen.models.Submit
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SubmissionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class SubmissionFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_submission, container, false)

        val back: Button = view.findViewById(R.id.back);
        val submit: Button = view.findViewById(R.id.submit)

        val firstName: TextInputEditText = view.findViewById(R.id.name)
        val lastName: TextInputEditText = view.findViewById(R.id.lastName)
        val email: TextInputEditText = view.findViewById(R.id.EmailAddress)
        val github: TextInputEditText = view.findViewById(R.id.github)

        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                getFragmentManager()?.popBackStack();

            }

        })

        submit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(firstName.text.isNullOrEmpty()||lastName.text.isNullOrEmpty()||email.text.isNullOrEmpty()||github.text.isNullOrEmpty()){
                    Toast.makeText(getActivity(), "Complete All Fields",Toast.LENGTH_LONG).show()
                    return
                }else{
                    postData(Submit(firstName.text.toString(),lastName.text.toString(),email.text.toString(),github.text.toString()))
                }


            }
        })

        return view
    }

    private fun postData(data:Submit) {

        var retrofit = Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var submitInterface: GAD = retrofit.create(GAD::class.java);
        var submitCall: Call<Submit> = submitInterface.submitData(data)

        submitCall.enqueue(object : Callback<Submit>{
            override fun onFailure(call: Call<Submit>, t: Throwable) {
               Toast.makeText(getActivity(), " General Failure "+t.message, Toast.LENGTH_LONG).show();
            }
            override fun onResponse(call: Call<Submit>, response: Response<Submit>) {
                if(!response.isSuccessful){
                    Toast.makeText(getActivity(), " failed "+response.message() ,Toast.LENGTH_LONG).show()
                }else
                Toast.makeText(getActivity(), " Success " + response.code() ,Toast.LENGTH_LONG).show()
            }

        });

    }

}