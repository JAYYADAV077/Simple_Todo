package com.example.simple_todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodoUi(modifier: Modifier = Modifier,viewModel: ViewModel) {

    val list by viewModel.list.observeAsState()
    var input by remember { mutableStateOf("") }


    Column (modifier = Modifier.fillMaxSize()){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp), horizontalArrangement = Arrangement.SpaceEvenly) {




            OutlinedTextField(value = input, onValueChange = {input = it}, modifier = Modifier.weight(1f))
            Button({viewModel.addTodo(input)
            input = ""}) {
                Text("Add")
            }
        }

      list?.let {
          LazyColumn { itemsIndexed(it){ index: Int, item: Data -> NotesUi(item = item) } }
      }
    }

}

@Composable
fun NotesUi(item: Data) {
    Card (modifier = Modifier.fillMaxWidth().padding(10.dp), elevation = CardDefaults.cardElevation(4.dp)){
        Column (modifier = Modifier.padding(25.dp)){
            Text(text = item.name, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }


    }


}

