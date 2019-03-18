package bt.edu.cst.easycst;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import bt.edu.cst.easycst.ModuleDatabaseContract;
import bt.edu.cst.easycst.ModuleDatabaseContract.ModuleDatabase;
import bt.edu.cst.easycst.ModuleDatabaseHelper;

public class AddModule extends AppCompatActivity {
    ModuleDatabaseHelper dbHelper;
    String mcodes, mnames, mtutors;
    EditText mcode, mname, mtutor;
    SQLiteDatabase db;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module);

        dbHelper = new ModuleDatabaseHelper(this);

        db = dbHelper.getWritableDatabase();

        mcode = (EditText) findViewById(R.id.mcode);
        mname = (EditText) findViewById(R.id.mname);
        mtutor = (EditText) findViewById(R.id.mtutor);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcodes = mcode.getText().toString();
                mnames = mname.getText().toString();
                mtutors = mtutor.getText().toString();
                int attendance = 0;
                if (mcodes.equals("") || mnames.equals("") || mtutors.equals("")) {
                    //Snackbar.make(view, "Please fill all fields", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    ScrollView coordinatorLayout=(ScrollView) findViewById(R.id.content);
                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "Please fill all fields", Snackbar.LENGTH_LONG);
                    View h = snackbar.getView();
                    h.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                    ScrollView.LayoutParams params=(ScrollView.LayoutParams)h.getLayoutParams();
                    params.gravity = Gravity.TOP;
                    h.setLayoutParams(params);
                    snackbar.show();
                }
                else {
                    ContentValues values = new ContentValues();
                    values.put(ModuleDatabase.COLUMN_NAME_COL1, mcodes);
                    values.put(ModuleDatabase.COLUMN_NAME_COL2, mnames);
                    values.put(ModuleDatabase.COLUMN_NAME_COL3, mtutors);
                    values.put(ModuleDatabase.COLUMN_NAME_COL4, attendance);

                    long rowId = db.insert(ModuleDatabaseContract.ModuleDatabase.TABLE_NAME, null, values);
                    if (rowId != -1) {
                        Toast.makeText(AddModule.this, "Module Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddModule.this, Attendance.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(AddModule.this, "Somthing went wrong try again or contact developers for help ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}