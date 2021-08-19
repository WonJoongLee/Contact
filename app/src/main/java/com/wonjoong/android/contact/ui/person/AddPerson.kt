package com.wonjoong.android.contact.ui.person

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
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
        val eachInputText = remember {
            mutableStateListOf(
                "", // name
                "", // relationship
                "", // age
                "", // company
                "", // hobby
                "", // personality
                "", // marriage
                "", // children
                "", // like
                "", // dontlike
                "", // etc
            )
        }

        Image(
            painter = painterResource(id = R.drawable.blank_profile_pictrue),
            contentDescription = "Person Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(percent = 10))
        )

        personInputList.values.forEachIndexed { index, data ->
            InputItem(data, eachInputText, index)
        }

        // Button
        Button(
            onClick = {
                repeat(10) {
                    Log.e("temp", eachInputText[it])
                }
            },
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

private fun getPersonInputList(): LinkedHashMap<String, InputPersonData> {
    val personInputList = LinkedHashMap<String, InputPersonData>()
    personInputList["name"] = InputPersonData(R.string.name, "Enter his/her name")
    personInputList["relationship"] = InputPersonData(R.string.relationship, "Enter his/her age")
    personInputList["age"] = InputPersonData(R.string.age, "Enter his/her age")
    personInputList["company"] = InputPersonData(R.string.company, "Enter his/her name")
    personInputList["hobby"] = InputPersonData(R.string.hobby, "Enter his/her name")
    personInputList["personality"] = InputPersonData(R.string.personality, "Enter his/her name")
    personInputList["marriage"] = InputPersonData(R.string.marriage, "Enter his/her name")
    personInputList["children"] = InputPersonData(R.string.children, "Enter the name")
    personInputList["like"] = InputPersonData(R.string.like, "Enter the name")
    personInputList["dont_like"] = InputPersonData(R.string.dont_like, "Enter the name")
    personInputList["etc"] = InputPersonData(R.string.etc, "Enter the name")
    return personInputList
}

@Composable
fun InputItem(
    content: InputPersonData,
    inputTextCategory: SnapshotStateList<String>,
    index: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(0.dp, 8.dp)
    ) {
        Text(
            text = stringResource(id = content.stringId),
            modifier = Modifier
                .width(104.dp)
                .padding(12.dp, 0.dp),
        )
        TextField(
            value = inputTextCategory[index],
            label = {
                Text(stringResource(id = content.stringId))
            },
            onValueChange = { inputTextCategory[index] = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Gray,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black
            )
        )
    }
}