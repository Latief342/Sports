package com.example.sports

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onNavigateToCatalog: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.sports),
            contentDescription = "Sports",
            modifier = Modifier
                .width(250.dp)
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Katalog Olahraga",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3F51B5)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Cari tahu siapa atlet top dunia dan berapa penghasilan mereka.",
            fontSize = 16.sp,
            color = Color(0xFF666666),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onNavigateToCatalog,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
        ) {
            Text("Masuk ke Katalog", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    viewModel: AthleteViewModel,
    onAthleteClick: (Athlete) -> Unit
) {
    val athletes by viewModel.athletes.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    var selectedAthleteForSheet by remember { mutableStateOf<Athlete?>(null) }
    val sheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCFCFF))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color(0xFFBACEEB))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.width(24.dp))
            Text(
                text = "Katalog Top Atlet",
                color = Color(0xFF304163),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.Build,
                contentDescription = "Menu",
                tint = Color(0xFF304163)
            )
        }

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.searchAthletes(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp),
            placeholder = { Text("Cari atlet...", color = Color.Gray) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray) },
            shape = RoundedCornerShape(25.dp),
            // PERBAIKAN: Menggunakan OutlinedTextFieldDefaults.colors untuk Material 3 terbaru
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                unfocusedBorderColor = Color.LightGray,
                focusedBorderColor = Color(0xFF3F51B5)
            )
        )

        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(athletes) { athlete ->
                AthleteItem(
                    athlete = athlete,
                    onClick = { selectedAthleteForSheet = athlete }
                )
            }
        }
    }

    if (selectedAthleteForSheet != null) {
        ModalBottomSheet(
            onDismissRequest = { selectedAthleteForSheet = null },
            sheetState = sheetState,
            containerColor = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text("Preview Atlet", fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                Text(selectedAthleteForSheet!!.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Cabang Olahraga: ${selectedAthleteForSheet!!.sport}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        val athleteToPass = selectedAthleteForSheet
                        selectedAthleteForSheet = null
                        if (athleteToPass != null) {
                            onAthleteClick(athleteToPass)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0), contentColor = Color.Black)
                ) {
                    Text("LIHAT DETAIL LENGKAP")
                }
            }
        }
    }
}

@Composable
fun AthleteItem(athlete: Athlete, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEAEAF4)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = athlete.imageRes),
                contentDescription = athlete.name,
                modifier = Modifier
                    .size(65.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = athlete.name, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF333333))
                Text(text = athlete.sport, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3A5A98))
                Text(text = athlete.earnings, fontSize = 12.sp, color = Color(0xFF666666))
            }
            Icon(
                imageVector = Icons.Default.Build,
                contentDescription = "Options",
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun DetailScreen(athlete: Athlete, onBackClick: () -> Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFF3F51B5)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                // PERBAIKAN: Menggunakan AutoMirrored untuk dukungan bahasa RTL
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Text(
                text = "Detail Atlet",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = athlete.imageRes),
                contentDescription = athlete.name,
                modifier = Modifier
                    .size(250.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = athlete.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Cabang Olahraga", fontWeight = FontWeight.Bold, color = Color(0xFF333333))
                Text(athlete.sport, color = Color(0xFF666666))
            }

            // PERBAIKAN: Menggunakan HorizontalDivider pengganti Divider lama
            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFFE0E0E0))

            Text(
                text = athlete.earnings,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )

            // PERBAIKAN: Menggunakan HorizontalDivider
            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFFE0E0E0))

            Text(
                text = athlete.description,
                color = Color(0xFF555555),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val shareText = "Cek info atlet ini!\nNama: ${athlete.name}\nOlahraga: ${athlete.sport}\nPenghasilan: ${athlete.earnings}"
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, shareText)
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    context.startActivity(shareIntent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
            ) {
                Text("Share Info Atlet", color = Color.White)
            }
        }
    }
}