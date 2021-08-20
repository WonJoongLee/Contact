package com.wonjoong.android.contact.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wonjoong.android.contact.R
import com.wonjoong.android.contact.data.Person

@Composable
fun DetailsScreen(person: Person) {
    // val getPerson = mPersonViewModel.getUserById(personId).observeAsState().value // Select Person with ID
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = person.name,
            color = Color.Black,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp, 0.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.blank_profile_pictrue),
            contentDescription = "Person Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(percent = 10))
        )
        InputItem(person = person, content = "name")
        InputItem(person = person, content = "relationship")
        InputItem(person = person, content = "age")
        InputItem(person = person, content = "company")
        InputItem(person = person, content = "hobby")
        InputItem(person = person, content = "personality")
        InputItem(person = person, content = "marriage")
        InputItem(person = person, content = "children")
        InputItem(person = person, content = "like")
        InputItem(person = person, content = "dont_like")
        InputItem(person = person, content = "etc")

    }
}

@Composable
fun InputItem(person: Person, content: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(0.dp, 8.dp)
    ) {
        Text(
            text = stringResource(id = propertyToStringValue(content)),
            modifier = Modifier
                .width(132.dp)
                .padding(12.dp, 0.dp),
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp),
            text = contentToStringValue(person, content),
            fontSize = 18.sp
        )
    }
}

fun contentToStringValue(person: Person, text: String) = when (text) {
    "name" -> person.name
    "relationship" -> person.relationship
    "age" -> person.age.toString()
    "company" -> person.company
    "hobby" -> person.hobby
    "personality" -> person.personality
    "marriage" -> person.marriage
    "children" -> person.children
    "like" -> person.like
    "dont_like" -> person.dont_like
    else -> person.etc
}

fun propertyToStringValue(text: String) = when (text) {
    "name" -> R.string.name
    "relationship" -> R.string.relationship
    "age" -> R.string.age
    "company" -> R.string.company
    "hobby" -> R.string.hobby
    "personality" -> R.string.hobby
    "marriage" -> R.string.marriage
    "children" -> R.string.children
    "like" -> R.string.like
    "dont_like" -> R.string.dont_like
    else -> R.string.etc
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    //DetailsScreen(personId = 1)
}