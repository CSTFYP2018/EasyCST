package bt.edu.cst.easycst;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView version = (TextView) findViewById(R.id.version);

        TextView tek = (TextView) findViewById(R.id.tek);
        tek.setText(Html.fromHtml("<a href=\"mailto:teknathaofficial@gmail.com\">Tek Nath Acharya</a>"));
        tek.setMovementMethod(LinkMovementMethod.getInstance());

        TextView kf = (TextView) findViewById(R.id.kd);
        kf.setText(Html.fromHtml("<a href=\"mailto:karmadorgey@gmail.com\">Karma Dorji</a>"));
        kf.setMovementMethod(LinkMovementMethod.getInstance());

        TextView de = (TextView) findViewById(R.id.de);
        de.setText(Html.fromHtml("<a href=\"mailto:deepikasbr@gmail.com\">Deepika Suberi</a>"));
        de.setMovementMethod(LinkMovementMethod.getInstance());

        TextView kt = (TextView) findViewById(R.id.kt);
        kt.setText(Html.fromHtml("<a href=\"mailto:kartse100@gmail.com\">Karma Tshewang</a>"));
        kt.setMovementMethod(LinkMovementMethod.getInstance());

        TextView pr = (TextView) findViewById(R.id.pr);
        pr.setText(Html.fromHtml("<a href=\"mailto:parshuram.cst@rub.edu.bt\">Parshu Ram Dhungyel (Guide)</a>"));
        pr.setMovementMethod(LinkMovementMethod.getInstance());

        TextView lic = (TextView) findViewById(R.id.lic);
        lic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(About.this, Libused.class);
                startActivity(intent);
            }
        });

        PackageManager manager = this.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(this.getPackageName(), PackageManager.GET_ACTIVITIES);
            version.setText("App version : "+info.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
