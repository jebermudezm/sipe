package jebm.sipe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sign_in_button_OnClick(View view) {
        DataBaseManager manager = new DataBaseManager(this);
        EditText etuser = (EditText) findViewById(R.id.Usuario);
        String user = etuser.getText().toString();
        EditText etpwr = (EditText) findViewById(R.id.password);
        String pwr = etpwr.getText().toString();
        if (user.equals("") && pwr.equals(""))
            mensajeok("El usuario y la clave son campos requeridos.","Usuario");
        else {
            Cursor cur = manager.Obtenerconfiguracion(user, pwr);
            if (cur.getCount() > 0) {
                while (cur.moveToNext()) {
                    Variables.sNombre = cur.getString(0).toString();
                    Variables.stiempo = Integer.parseInt(cur.getString(1).toString());
                    Variables.sServicio = cur.getString(2).toString();
                }
                //Bundle usuario = new Bundle();
                //usuario.putString("key_usr",Variables.sNombre);
                Intent i = new Intent(LoginActivity.this, MenuppalActivity.class);
                startActivity(i);
            } else
                mensajeok("Usuario y contraseña invalidos, intente nuevamente", "Login");
        }

    }
    public void mensajeok(String msg,String tit){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle(tit);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.setIcon(android.R.drawable.ic_dialog_alert);
        dlgAlert.create().show();
    }

}
