package v3.ordersystem.a7r48.ordersystem;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     final Context context = this;
     final String url = "http://13.250.157.151:3001/login";
    RequestQueue queue;
    private Toolbar mToolbar;
    private Button btnCreateAccount,btnLogin;
    private TextView tvForgotPassword;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         queue = Volley.newRequestQueue(this);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        tvForgotPassword=(TextView)findViewById(R.id.tvForgotPassword);
        mToolbar =(Toolbar)findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Login To Your Account");

        btnCreateAccount =(Button)findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCreateAccount:
                Intent i = new Intent(MainActivity.this,Register.class);
                startActivity(i);
                finish();
                String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                Toast.makeText(MainActivity.this,refreshedToken,Toast.LENGTH_LONG).show();
                break;

            case R.id.tvForgotPassword:

                myForgotPasswordmethod();
                break;
            case R.id.btnLogin:
               // customExitDialog();
                customLogin();

                break;



        }
    }

     private void customLogin()
    {
        Map<String,String> params = new HashMap<String,String>();

        params.put("user_name","userA");
        params.put("password","imuserA");
        params.put("email","aa@user.ff");
        params.put("marchant_id","1");
        params.put("type","ios");
        params.put("pn_token","123456789tyuioop");

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(params),
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                        Toast.makeText(MainActivity.this,response.toString()+"this is success",Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                        Toast.makeText(MainActivity.this,error.toString()+"this is error",Toast.LENGTH_LONG).show();
                    }
                }
        )


        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");

                return headers;
            }

            public String getBodyContentType(){
                return "application/x-www-form-urlencoded;charset=UTF-8";
            }

        };
        queue.add(postRequest);
        Volley.newRequestQueue(MainActivity.this).add(postRequest);

    };




    private void myForgotPasswordmethod() {
      //  Toast.makeText(this,"h",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder mBuilder= new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.forgot_dialog,null);
        EditText mFEmail = (EditText)mView.findViewById(R.id.etFEmail);
        Button btnFCancel =(Button)mView.findViewById(R.id.btnFCancel);
        Button btnFSubmit =(Button)mView.findViewById(R.id.btnFSubmit);
        btnFCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),"Your Email is-" ,Toast.LENGTH_LONG).show();
                //dismissDialog(1);

               // customExitDialog();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

    }


        private void customExitDialog() {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);

            // set title
            alertDialogBuilder.setTitle("Add New Name");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Click yes to exit!")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, close
                            // curent activity
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });
    }
}
