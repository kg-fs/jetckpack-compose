package com.cursoapp.myproyectoandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cursoapp.myproyectoandroid.ui.theme.MyProyectoAndroidTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyProyectoAndroidTheme {
                DrawerEjemplo()
            }
        }
    }
}

// ---- VIDEO 3: Botones ----

@Composable
fun MisBotones(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = {}) { Text("Button") }
        FilledTonalButton(onClick = {}) { Text("Filled Tonal Button") }
        ElevatedButton(onClick = {}) { Text("Elevated Button") }
        OutlinedButton(onClick = {}) { Text("Outlined Button") }
        TextButton(onClick = {}) { Text("Text Button") }
        Button(onClick = {}) {
            Icon(Icons.Default.Favorite, contentDescription = null)
            Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
            Text("Icon Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MisBotonesPreview() {
    MyProyectoAndroidTheme { MisBotones() }
}

// ---- VIDEO 4: Floating Action Buttons ----

@Composable
fun MisFAB(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SmallFloatingActionButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Default.Add, contentDescription = "Small FAB")
        }
        FloatingActionButton(onClick = {}, shape = CircleShape) {
            Icon(Icons.Default.Add, contentDescription = "FAB")
        }
        LargeFloatingActionButton(onClick = {}, shape = CircleShape) {
            Icon(Icons.Default.Add, contentDescription = "Large FAB")
        }
        ExtendedFloatingActionButton(
            onClick = {},
            icon = { Icon(Icons.Default.Add, contentDescription = null) },
            text = { Text("Botón extendido") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MisFABPreview() {
    MyProyectoAndroidTheme { MisFAB() }
}

// ---- VIDEO 5: Diálogos ----

@Composable
fun MiDialogo(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Mostrar Diálogo")
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Título del diálogo") },
                text = { Text("¿Deseas confirmar esta acción?") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) { Text("Confirmar") }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) { Text("Cancelar") }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MiDialogoPreview() {
    MyProyectoAndroidTheme { MiDialogo() }
}

// ---- VIDEO 6: Cards ----

@Composable
fun CardEjemplo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Text(text = "Card simple", modifier = Modifier.padding(16.dp))
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E88E5)),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Tarjeta de crédito", color = Color.White, fontWeight = FontWeight.Bold)
                        Text("12/26", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "**** **** **** 1234",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(Icons.Default.Favorite, contentDescription = null, tint = Color.White)
                        Icon(Icons.Default.Share, contentDescription = null, tint = Color.White)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
                color = Color(0xFFFFD700),
                shape = CircleShape,
                shadowElevation = 4.dp
            ) {
                Text(
                    "VISA",
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardEjemploPreview() {
    MyProyectoAndroidTheme { CardEjemplo() }
}

// ---- VIDEO 7: Listados ----

val mensajes = List(50) { "Mensaje número ${it + 1}" }

@Composable
fun EfficientList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(mensajes) { mensaje ->
            Text(
                text = mensaje,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun GridList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(mensajes) { mensaje ->
            Card(modifier = Modifier.padding(4.dp)) {
                Text(text = mensaje, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EfficientListPreview() {
    MyProyectoAndroidTheme { EfficientList() }
}

// ---- VIDEO 8: Snackbar ----

@Composable
fun SnackbarEjemplo() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Elemento eliminado",
                            actionLabel = "Deshacer"
                        )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                Log.d("MyApp", "Acción ejecutada: Deshacer")
                            }
                            SnackbarResult.Dismissed -> {
                                Log.e("MyApp", "Snackbar cerrado")
                            }
                        }
                    }
                }
            ) {
                Text("Mostrar Snackbar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SnackbarEjemploPreview() {
    MyProyectoAndroidTheme { SnackbarEjemplo() }
}

// ---- VIDEO 10: Modal Bottom Sheet ----

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetEjemplo() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hola desde la pantalla principal",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { showBottomSheet = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Abrir Modal")
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            BottomSheetContent(
                onClose = {
                    coroutineScope.launch {
                        sheetState.hide()
                    }.invokeOnCompletion {
                        showBottomSheet = false
                    }
                }
            )
        }
    }
}

@Composable
fun BottomSheetContent(onClose: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contenido del Bottom Sheet",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Aquí puedes colocar lo que quieras.")
        Text(text = "Botones, listas, formularios, etc.")
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onClose,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cerrar")
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetEjemploPreview() {
    MyProyectoAndroidTheme { BottomSheetEjemplo() }
}

// ---- VIDEO 11: Navigation Drawer ----

val menuItems = listOf("Inicio", "Perfil", "Configuración", "Ayuda", "Cerrar sesión")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerEjemplo() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var selectedItem by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Mi Aplicación",
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.headlineMedium
                )
                HorizontalDivider()
                Spacer(modifier = Modifier.height(8.dp))

                menuItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(text = item) },
                        selected = index == selectedItem,
                        onClick = {
                            selectedItem = index
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = menuItems[selectedItem]) },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menú"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Sección: ${menuItems[selectedItem]}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerEjemploPreview() {
    MyProyectoAndroidTheme { DrawerEjemplo() }
}