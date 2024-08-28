package com.example.contactapp.presentation.Screen

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.contactapp.data.dao.ContactDao
import com.example.contactapp.data.table.Contact
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

@Preview(showSystemUi = true)
@Composable
fun AddEditContactScreen(dbObject: ContactDao, navController: NavHostController)
{
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var context=LocalContext.current

    Column(modifier= Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Add Contact", textAlign = TextAlign.Center)
        OutlinedTextField(value = name, maxLines = 1, onValueChange ={
            name=it
        }, placeholder = {
            Text(text = "Enter Name", textAlign = TextAlign.Center)
        } )
        OutlinedTextField(maxLines = 1,value = email, onValueChange ={
            email=it
        }, placeholder = {
            Text(text = "Enter Email", textAlign = TextAlign.Center)
        } )
        OutlinedTextField(maxLines = 1, value = phone, onValueChange ={
            phone=it
        } , placeholder = {
            Text(text = "Enter Phone Number", textAlign = TextAlign.Center)
        })
        Button(onClick = {
            if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                if(dbObject.isContactAlreadyExist(name=name,phone=phone).size>0)
                {
                    Toast.makeText(context,"With this Name Contact Is Already Exist",Toast.LENGTH_LONG).show()
                }
                else {
                    dbObject.saveUpdateContact(
                        Contact(
                            name = name,
                            email = email,
                            phone = phone
                        )
                    )
                    navController.navigateUp()
                }
            }
            else
            {
                Toast.makeText(context,"Invalid Email",Toast.LENGTH_LONG).show()
            }


        })
        {
            Text(text = "Save Contact")
        }
    }

}

private fun Unit.saveUpdateContact(contact: Contact) {

}
