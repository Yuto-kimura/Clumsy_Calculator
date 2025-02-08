package careless.calculator

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

@Composable
fun AboutScreen(toAgreementScreen: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activity = LocalContext.current as Activity
    Column(modifier = modifier) {
        Button(onClick = {
            val intent = Intent(context, OssLicensesMenuActivity::class.java)
            activity.startActivity(intent)
        }) {
            Text(text = "ライセンス")
        }

        Button(onClick = {
            toAgreementScreen()
        }) {
            Text(text = "利用規約")
        }
    }
}
