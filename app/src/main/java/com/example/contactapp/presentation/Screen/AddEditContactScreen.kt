package com.example.contactapp.presentation.Screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
    Column(modifier= Modifier.fillMaxSize())
    {
        OutlinedTextField(value = name, onValueChange ={
            name=it
        } )
        OutlinedTextField(value = email, onValueChange ={
            email=it
        } )
        OutlinedTextField(value = phone, onValueChange ={
            phone=it
        } )
        Button(onClick = {
            if(dbObject.isContactAlreadyExist(name).size>0)
            {
                Toast.makeText(context,"With this Name Contact Is Already Exist",Toast.LENGTH_SHORT).show()
            }
            else {
                dbObject.saveUpdateContact(
                    Contact(
                        name = name,
                        email = email,
                        phone = phone
                    )
                )
            }
            navController.navigateUp()
        })
        {
            Text(text = "Save Contact")
        }
    }

}

private fun Unit.saveUpdateContact(contact: Contact) {

}
