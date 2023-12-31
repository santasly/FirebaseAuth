package com.example.firebaseauth.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.firebaseauth.navigation.ROUTE_HOME
import com.example.firebaseauth.navigation.ROUTE_LOGIN
import com.example.firebaseauth.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth

class AUthViewModel(var navController: NavHostController, var context:Context){
    var mAuth:FirebaseAuth

    init{
        mAuth= FirebaseAuth.getInstance()
    }
    fun signup(email:String,pass:String,confpass:String){
        if (email.isEmpty() || pass.isBlank() ||confpass.isBlank()){
            Toast.makeText(context,"please email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(context,"Register Successfully",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_HOME)

                }else{
                    Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_LOGIN)
                }
            }
        }
    }

    fun login(email:String,pass:String){

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
            if(it.isSuccessful){
                Toast.makeText(context,"Successfully logged in",Toast.LENGTH_LONG).show()
//                navController.navigate(ROUTE_REGISTER) to take you to another page

            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }

    }

    fun Logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

    fun isloggedin():Boolean{
        return mAuth.currentUser != null
    }
}