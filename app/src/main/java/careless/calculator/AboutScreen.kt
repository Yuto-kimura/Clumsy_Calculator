package careless.calculator

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(goBackTop: () -> Unit, toAgreementScreen: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activity = LocalContext.current as Activity

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ライセンスと利用規約") },
                navigationIcon = {
                    IconButton(onClick = goBackTop) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "TOP画面に戻る"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            TextButton(onClick = {
                val intent = Intent(context, OssLicensesMenuActivity::class.java)
                activity.startActivity(intent)
            }) {
                Text(
                    text = "ライセンス",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp
                )
            }

            TextButton(onClick = {
                toAgreementScreen()
            }) {
                Text(
                    text = "利用規約",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp
                )
            }
        }
    }
}
