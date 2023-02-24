package com.saiprasanth.myproject.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saiprasanth.myproject.R

@Preview(showBackground = true, showSystemUi = true)
@Composable

fun LoginScreen(){

    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }




    Box(
        modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.login_bg),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .blur(6.dp),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp)
                .alpha(0.06f)
                .clip(CutCornerShape(10.dp))
                .background(MaterialTheme.colors.secondary)
        )

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            LoginHeader()


            LoginFields(
                username, password, onUserNameChange ={
                    username = it
                },
                onPasswordChange = {
                    password = it
                },
                onForgotPasswordClick = {

                }
            )
            LoginFooter(onLoginClick = {

            },
            onSignUpClick = {

            }
                )
        }
    }

}

@Composable
fun LoginHeader(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Welcome",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(text = "Login in to Continue",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold)
    }

}

@Composable
fun LoginFields(
    username: String,
    password: String,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick : () -> Unit
) {

    Column {
        Field(
            value = username,
            onValueChange = onUserNameChange,
            placeholder = "Enter your email address",
            label = "Username",
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = " Email")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Field(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = "Enter Your password",
            label = "Password",
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Go)
        )
        TextButton(onClick = onForgotPasswordClick, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Forgot Password")
        }
    }


}

@Composable
fun LoginFooter(
    onLoginClick : () -> Unit,
    onSignUpClick : () -> Unit
){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = onLoginClick, modifier = Modifier.fillMaxSize()) {
            Text(text = "Login In")
        }
        TextButton(onClick = onSignUpClick) {
            Text(text = "Don't have an account, click here")
        }
    }
}

@Composable
fun Field(value : String,
          onValueChange : (String) -> Unit,
          placeholder : String,
          label : String,
          visualTransformation : VisualTransformation = VisualTransformation.None,
          keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
          leadingIcon : @Composable (() ->Unit)? = null,
          trialingIcon : @Composable (() ->Unit)? = null,
          ){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trialingIcon
    )

}