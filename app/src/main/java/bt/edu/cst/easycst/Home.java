package bt.edu.cst.easycst;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    static boolean executed=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView maintain = findViewById(R.id.maintain);
        TextView mai = findViewById(R.id.mai);
        TextView tim = findViewById(R.id.tim);
        TextView rat = findViewById(R.id.rat);
        TextView fee = findViewById(R.id.fee);
        TextView att = findViewById(R.id.att);
        TextView ass = findViewById(R.id.ass);
        TextView abo = findViewById(R.id.abo);
        TextView sha = findViewById(R.id.sha);
        TextView hel = findViewById(R.id.hel);
        ImageView about = findViewById(R.id.about);
        ImageView feedback = findViewById(R.id.feedback);
        ImageView attendance = findViewById(R.id.attendance);
        ImageView rate = findViewById(R.id.rate);
        ImageView share = findViewById(R.id.share);
        ImageView football = findViewById(R.id.football);
        ImageView help = findViewById(R.id.help);
        ImageView timetable = findViewById(R.id.timetable);

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
                final String appPackageName = getPackageName();
                startActivity(new Intent(Intent.ACTION_VIEW,  Uri.parse("market://details?id=" + appPackageName)));
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
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
            }
        });/*
        hel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Help.class);
                startActivity(intent);
            }
        });
       if (executed) {
            TapTargetView.showFor(this,                 // `this` is an Activity
                    TapTarget.forView(findViewById(R.id.attendance), "Attendance Tracking", "You can manage and track your attendance here.")
                            .tintTarget(true)                   // Whether to tint the target view's color
                            .transparentTarget(true)           // Specify whether the target is transparent (displays the content underneath)
                            //.icon(R.drawable.about)                     // Specify a custom drawable to draw as the target
                            .targetRadius(50),                  // Specify the target radius (in dp)
                    new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);      // This call is optional
                            view.dismiss(true);
                        }
                    });
            executed=false;
        }*/

    }
}
