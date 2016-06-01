package com.example.yojhan.ejemplologin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    public static Usuario getUserglobal() {
        return userglobal;
    }

    public static void setUserglobal(Usuario userglobal) {
        Home.userglobal = userglobal;
    }

    private static Usuario userglobal;
    private TextView tv_editname,tv_editlastname,tv_editusername,tv_editfechanac,tv_editpassword,tv_editid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv_editid = (TextView) findViewById(R.id.tv_editid);
        tv_editname = (TextView) findViewById(R.id.tv_editname);
        tv_editlastname = (TextView) findViewById(R.id.tv_editlastname);
        tv_editusername = (TextView) findViewById(R.id.tv_editusername);
        tv_editpassword = (TextView) findViewById(R.id.tv_editpassword);
        tv_editfechanac = (TextView) findViewById(R.id.tv_editfechanac);
        mostrarInformacion();
    }

    private void mostrarInformacion(){

        tv_editid.setText(""+userglobal.id);
        tv_editname.setText(userglobal.nombre);
        tv_editlastname.setText(userglobal.apellido);
        tv_editusername.setText(userglobal.username);
        tv_editpassword.setText(userglobal.password);
        tv_editfechanac.setText(userglobal.fechanac);
    }
}
