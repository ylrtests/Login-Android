package com.example.yojhan.ejemplologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class login extends AppCompatActivity implements View.OnClickListener, AsyncResponse {

    EditText et_user,et_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_user = (EditText) findViewById(R.id.et_user);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("username",et_user.getText().toString());
        postData.put("password",et_password.getText().toString());

        PostResponseAsyncTask task = new PostResponseAsyncTask(this,postData);
        task.execute("http://healthcaretracking.comeze.com/pruebalogin.php");
    }

    @Override
    public void processFinish(String s) {
        Usuario user = checkUser(s);

        if(user == null){
            Toast.makeText(this,"Verifique usuario y contraseña", Toast.LENGTH_LONG).show();
        }
        else{
            Home.setUserglobal(user);
            Intent i = new Intent(this,Home.class);
            startActivity(i);
            finish();

        }
    }

    private Usuario checkUser(String s){
        Usuario user = null;
        try {
            JSONObject jsonObject = new JSONObject(s);
            if(jsonObject.length() >= 0){
                String username = jsonObject.getString("username");
                String password = jsonObject.getString("password");
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String fechanac = jsonObject.getString("fechanac");
                int id = jsonObject.getInt("id");

                user = new Usuario(id,nombre,apellido,username,password,fechanac);
            }
        } catch (JSONException e) {
            return user;
        }

        return user;
    }
}
