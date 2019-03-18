package bt.edu.cst.easycst;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView maintain = (ImageView) findViewById(R.id.maintain);
        TextView mai = (TextView) findViewById(R.id.mai);
        TextView tim = (TextView) findViewById(R.id.tim);
        TextView rat = (TextView) findViewById(R.id.rat);
        TextView fee = (TextView) findViewById(R.id.fee);
        TextView att = (TextView) findViewById(R.id.att);
        TextView ass = (TextView) findViewById(R.id.ass);
        TextView abo = (TextView) findViewById(R.id.abo);
        TextView sha = (TextView) findViewById(R.id.sha);
        TextView hel = (TextView) findViewById(R.id.hel);
        ImageView about = (ImageView) findViewById(R.id.about);
        ImageView feedback = (ImageView) findViewById(R.id.feedback);
        ImageView attendance = (ImageView) findViewById(R.id.attendance);
        ImageView rate = (ImageView) findViewById(R.id.rate);
        ImageView share = (ImageView) findViewById(R.id.share);
        ImageView football = (ImageView) findViewById(R.id.football);
        ImageView help = (ImageView) findViewById(R.id.help);
        ImageView timetable = (ImageView) findViewById(R.id.timetable);

        ////////////////////////////////////////
        maintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, maintain.class);
                startActivity(intent);
            }
        });
        mai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, maintain.class);
                startActivity(intent);
            }
        });

        ////////////////////////////////////////////////////////////
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, TimeTable.class);
                startActivity(intent);
            }
        });
        tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, TimeTable.class);
                startActivity(intent);
            }
        });
////////////////////////////////////////
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=PackageName")));
            }
        });
        rat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, register.class);
                startActivity(intent);
            }
        });
        /////////////////////////////
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Feedback.class);
                startActivity(intent);
            }
        });
        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Feedback.class);
                startActivity(intent);
            }
        });
        //////////////////

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Attendance.class);
                startActivity(intent);
            }
        });
        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Attendance.class);
                startActivity(intent);
            }
        });
        //////////////////

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, About.class);
                startActivity(intent);
            }
        });
        abo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, About.class);
                startActivity(intent);
            }
        });
        ////////////////

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Easy CST");
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
            }
        });
        sha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Easy CST");
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
            }
        });
        ///////////
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, HomeworksActivity.class);
                startActivity(intent);
            }
        });
        ass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, HomeworksActivity.class);
                startActivity(intent);
            }
        });
////////////////
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Help.class);
                startActivity(intent);
            }
        });
        hel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Help.class);
                startActivity(intent);
            }
        });

    }
}
