package com.wonjoong.android.contact.ui.person

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wonjoong.android.contact.R

@Composable
fun AddPerson() {
    val personInputList = getPersonInputList()
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.blank_profile_pictrue),
            contentDescription = "Person Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(percent = 10))
        )
        personInputList.values.forEach {
            InputItem(content = stringResource(id = it))
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text(
                "Complete",
                color = Color.Black,
            )
        }
    }
}

private fun getPersonInputList(): LinkedHashMap<String, Int> {
    val personInputList = LinkedHashMap<String, Int>()
    personInputList["name"] = R.string.name
    personInputList["age"] = R.string.age
    personInputList["company"] = R.string.company
    personInputList["hobby"] = R.string.hobby
    personInputList["personality"] = R.string.personality
    personInputList["marriage"] = R.string.marriage
    personInputList["children"] = R.string.children
    personInputList["like"] = R.string.like
    personInputList["dont_like"] = R.string.dont_like
    return personInputList
}

@Composable
fun InputItem(content: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(0.dp, 8.dp)
    ) {
        var inputName by remember { mutableStateOf("") }
        Text(
            text = content,
            modifier = Modifier
                .width(96.dp)
                .padding(12.dp, 0.dp),
        )
        TextField(
            value = inputName,
            onValueChange = { inputName = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp)
        )
    }
}