package com.example.tchafa.candidature

Column(
Modifier
.fillMaxSize()
.background(White))
{
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(painter = painterResource(R.drawable.back_arrow),
                contentDescription = "back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { navController.popBackStack() })
            Image(painter = painterResource(R.drawable.plus),
                contentDescription = "sort",
                modifier = Modifier
                    .padding(start = 20.dp)
                    .rotate(90f)
                    .clickable { navController.navigate(Screen.NeedHome.route) }
                    .size(30.dp))
        }

        Text(text = "My Publications", color = TextBlue, fontSize = 35.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace)
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 10.dp,),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    )
    {

        TextField(
            value = search,
            onValueChange = { newText -> search = newText },
            modifier = Modifier
                .padding(bottom = 25.dp, top = 30.dp, end = 20.dp, start = 20.dp)
                .height(46.dp)
                .width(screenWidth - 40.dp)
                .border(1.dp, color = LightBlack, shape = RoundedCornerShape(10.dp)),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search"
                )
            },
            label = { Text(text = "Search", color = LightBlack, fontSize = 12.sp) },
            textStyle = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily.Monospace
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.Black
            )
        )
    }
    LazyColumn(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        itemsIndexed(needList) { index, item ->
            Column(
                Modifier
                    .width(screenWidth - 40.dp)
                    .padding(vertical = 0.dp, horizontal = 0.dp)) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(White)
                        .border(1.dp, color = LightBlack, shape = RoundedCornerShape(8.dp)),) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 0.dp, start = 38.dp)){
                        Image(painter = painterResource(id = R.drawable.no_image), contentDescription ="no image", modifier = Modifier.size(30.dp) )
                        needList[index]?.Title?.let{
                            Text(text = it, fontSize = 30.sp, color = TextBlue,modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        needList[index]?.salaire?.let {
                            Text(text = it, fontSize = 27.sp, color = Black)
                            Text(text = "FCFA", fontSize = 20.sp, color = Black,modifier = Modifier.padding(start = 3.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(7.dp))
                    Row{
                        Row(verticalAlignment = Alignment.Bottom){
                            Row(
                                Modifier
                                    .width(screenWidth - 70.dp)
                                    .padding(start = 15.dp), horizontalArrangement = Arrangement.Center)
                            {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(id = R.drawable.sector),
                                        contentDescription = "sector",
                                        modifier = Modifier.size(12.dp)
                                    )
                                    needList[index]?.Secteur?.let{
                                        Text(
                                            text = it,
                                            color = TextBlack,
                                            modifier = Modifier.padding(start = 4.dp, end = 20.dp),
                                            fontSize = 15.sp
                                        )
                                    }
                                }
                                Row() {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Image(
                                            painter = painterResource(id = R.drawable.localisation),
                                            contentDescription = "sector",
                                            modifier = Modifier
                                                .size(12.dp)
                                                .padding(start = 0.dp)
                                        )
                                        needList[index]?.Localisation?.let{
                                            Text(
                                                text = it,
                                                color = TextBlack,
                                                modifier = Modifier.padding(start = 4.dp),
                                                fontSize = 15.sp



                                            )
                                        }
                                    }

                                }
                            }
                        }
                    }

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp), horizontalArrangement = Arrangement.Center){
                        Button(onClick = {                                Identifiant = null
                            Identifiant = needList[index]?.id
                            if (Identifiant != null) {
                                Identifiant = needList[index]?.id
                                navController.navigate(route = Screen.PublicationDetail.route)
                            } },
                            modifier = Modifier
                                .padding(end = 40.dp)
                                .width(100.dp)
                                .height(30.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                            ,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = LightGray
                            )
                        ) {
                            Image(painter = painterResource(id = R.drawable.details), contentDescription = "details ")
                        }
                        Button(onClick = {
                            Identifiant = null
                            Identifiant = needList[index]?.id
                            if (Identifiant != null) {
                                deleteDataFromFirebase(Identifiant, context)
                                Identifiant = null
                                deleteDataFromFirebase(Identifiant,context)
                            }
                        },
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                            ,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Red
                            )
                        ) {
                            Text(text = "Delete", color = White)
                        }

                        Button(onClick = {},
                            modifier = Modifier
                                .width(100.dp)
                                .height(30.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                            ,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = ComponentBlue
                            )
                        ) {
                            Text(text = "Candidates", color = White)
                        }
                    }
                }
            }
        }
    }
}