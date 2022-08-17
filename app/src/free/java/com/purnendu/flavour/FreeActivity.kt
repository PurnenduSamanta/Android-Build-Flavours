package com.purnendu.flavour

import Common
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.purnendu.flavour.ui.theme.FlavourTheme

class FreeActivity : ComponentActivity() {

    var resultNo: Int = 0
    var isResultOk:Boolean=false
    var nth:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlavourTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    var no by remember { mutableStateOf("") }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Common()

                        Spacer(modifier = Modifier.height(10.dp))


                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = no, onValueChange = { no = it })

                        Button(onClick = {
                            if (no.isBlank())
                                return@Button
                            if (!no.isDigitsOnly())
                                return@Button
                            nth = no.toInt()
                            resultNo = nThEven(no.toInt())
                            no = ""
                            isResultOk = true
                        }) {
                            Text(text = "Calculate")

                        }
                        if (!isResultOk)
                            return@Column
                            Text(text = "$nth th even no is $resultNo")

                    }

                }
            }
        }
    }
}

