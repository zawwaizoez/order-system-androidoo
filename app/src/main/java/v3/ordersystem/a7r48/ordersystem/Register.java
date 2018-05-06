package v3.ordersystem.a7r48.ordersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class Register extends AppCompatActivity {


    private Toolbar mToolbar;
    private Button btnRegister;
    private EditText name,email,password,confirmPassword;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mToolbar =(Toolbar)findViewById(R.id.register_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnRegister =(Button)findViewById(R.id.btnRegister);
        name =(EditText)findViewById(R.id.etName);
        email =(EditText)findViewById(R.id.etEmail);
        password =(EditText)findViewById(R.id.etPassword);
        confirmPassword=(EditText)findViewById(R.id.etConfirmPassword);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                Toast.makeText(Register.this,refreshedToken,Toast.LENGTH_LONG).show();

            }
        });

    }
}
