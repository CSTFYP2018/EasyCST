package bt.edu.cst.easycst;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Feedback extends AppCompatActivity {
    static boolean executed = true;
    // Creating EditText.
    private EditText feedback;
    Button submit;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String feedbackholder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "http://192.168.43.11:8000/api/getfeedback";

    Boolean CheckEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Assigning ID's to EditText.
        feedback = findViewById(R.id.feedback);
        // Assigning ID's to Button.
        submit = findViewById(R.id.submit);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(Feedback.this);
        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(Feedback.this);

        // Adding click listener to button.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEditTextIsEmptyOrNot();
                if (CheckEditText) {
                    MRegistration();
                } else {
                    Snackbar.make(view, "Your text box is empty!!!", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }
            }
        });

    }

    public void MRegistration() {
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, While we process your request...");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonobject = new JSONObject(response);
                            if (jsonobject.names().get(0).equals("message")) {
                                Toast.makeText(getApplicationContext(),""+jsonobject.getString("message"),Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplication(),Home.class));
                            }
                            else{
                                Toast.makeText(getApplicationContext(),""+jsonobject.getString("exist"),Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // Showing Echo Response Message Coming From Server.

                       // Toast.makeText(Feedback.this, ServerResponse, Toast.LENGTH_LONG).show();
                        //if (ServerResponse.equals("Registration Successful")) {
                        //startActivity(new Intent(Feedback.this, Home.class));
                        finish();
                        //}
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        //Toast.makeText(maintain.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                        Toast.makeText(Feedback.this, "Somthing is not Right Try again Later", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("feedback_message", feedbackholder);
                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Feedback.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }

    public void CheckEditTextIsEmptyOrNot() {

        // Getting values from EditText.
        feedbackholder = feedback.getText().toString().trim();

        Log.d("feedback_message", feedbackholder);

        CheckEditText = !TextUtils.isEmpty(feedbackholder);
    }
}

