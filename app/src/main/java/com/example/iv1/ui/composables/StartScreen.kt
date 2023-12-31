package com.example.iv1.ui.composables

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iv1.R
import com.example.iv1.data.AuthViewModel
import com.example.iv1.ui.components.Button1
import com.example.iv1.ui.theme.lightBlue
import com.google.firebase.auth.FirebaseAuth

@Composable
fun StartScreen(
//    onIRCalcButtonClicked: () -> Unit,
//    onCompatibilityCheckButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current

    val authModel = AuthViewModel()

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = lightBlue)
        .fillMaxHeight(0.3f)
    )
    {
        Spacer(modifier = Modifier.height(100.dp))
    }

    LazyColumn() {
        items(1) {

                Box(
                    modifier = modifier
                        .padding(top = 50.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(310.dp)
                            .height(150.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color.White)
                            .border(width = 1.dp, color = Color.Gray, shape = CircleShape),
                        painter = painterResource(id = R.drawable.neonate_img1),
                        contentScale = ContentScale.FillWidth,
                        contentDescription = "Circular image"
                    )
                }
            Column(
                modifier = modifier
                    .padding(top = 30.dp)
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(
                    text = "Welcome to NeoCheck",
                    color = Color.DarkGray,
                    fontFamily = FontFamily.Serif,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = MaterialTheme.typography.h6.fontSize
                )

                Spacer(modifier = Modifier.height(20.dp))

//                Button1(
//                    text = "Check Compatibility",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(70.dp)
//                        .padding(
//                            horizontal = 16.dp,
//                            vertical = 8.dp
//                        ),
//                    onClick = { onCompatibilityCheckButtonClicked() }
//                )
//                Spacer(modifier = Modifier.height(5.dp))
//
//                Button1(
//                    text = "IR Calculator",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(70.dp)
//                        .padding(
//                            horizontal = 16.dp,
//                            vertical = 8.dp
//                        ),
//                    onClick = { onIRCalcButtonClicked() }
//                )

                Text(
                    text = "User Id: ",
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = MaterialTheme.typography.h6.fontSize
                )

                Text(
                    text = FirebaseAuth.getInstance().currentUser?.email.toString(),
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = MaterialTheme.typography.h6.fontSize
                )

                Spacer(modifier = Modifier.height(10.dp))

                Spacer(modifier = Modifier.height(5.dp))

                Button1(
                    text = "Sign Out",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(
                            horizontal = 30.dp,
                            vertical = 6.dp
                        ),
                    onClick = {
                        authModel.logoutUser(context, context as? Activity)
                    }
                )
            }
        }
        
    }
}