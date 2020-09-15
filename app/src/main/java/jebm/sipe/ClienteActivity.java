package jebm.sipe;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class ClienteActivity extends ActionBarActivity {

    private DataBaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        manager = new DataBaseManager(this);
        llenartipodocumento();
        llenarciudad();
    }

    private void llenartipodocumento() {
        Spinner sp = (Spinner) this.findViewById(R.id.spnTipoDocu);
        Cursor cur = manager.ObtenerTipodocu();
        ArrayList<EntiTipoDocu> TipoDocu = new ArrayList<EntiTipoDocu>();
        EntiTipoDocu obj;
        while (cur.moveToNext()){
            obj = new EntiTipoDocu();
            obj.setcodtipodocu(cur.getString(0)+"-"+cur.getString(1));
            obj.setNomtipodocu(cur.getString(0)+"-"+cur.getString(1));
            TipoDocu.add(obj);
        }
        ArrayAdapter<EntiTipoDocu> adaptador = new ArrayAdapter<EntiTipoDocu>(this, android.R.layout.simple_spinner_item, TipoDocu);
        sp.setAdapter(adaptador);
        //startManagingCursor(cur);
    }

    private void llenarciudad() {
        Spinner sp = (Spinner) this.findViewById(R.id.spnCiudad);
        Cursor cur = manager.Obtenerciudad();
        ArrayList<EntiCiudad> ciudad = new ArrayList<EntiCiudad>();
        EntiCiudad obj;
        while (cur.moveToNext()){
            obj = new EntiCiudad();
            obj.setCodciudad(cur.getString(0) + "-" + cur.getString(1) + "-" + cur.getString(2));
            obj.setNomciudad(cur.getString(0) + "-" + cur.getString(1) + "-" + cur.getString(2) + "-" + cur.getString(3));
            ciudad.add(obj);
        }
        ArrayAdapter<EntiCiudad> adaptador = new ArrayAdapter<EntiCiudad>(this, android.R.layout.simple_spinner_item, ciudad);
        sp.setAdapter(adaptador);
        //startManagingCursor(cur);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cliente, menu);
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


    public void btnGuardar_OnClick(View view) {
        try {
            Spinner spinner1 = (Spinner) findViewById(R.id.spnTipoDocu);
            String tipodocu = spinner1.getSelectedItem().toString();
            EditText miEditText = (EditText) findViewById(R.id.editTextDocume);
            String documento = miEditText.getText().toString();
            miEditText = (EditText) findViewById(R.id.editTextNombre1);
            String nombre1 = miEditText.getText().toString();
            miEditText = (EditText) findViewById(R.id.editTextNombre2);
            String nombre2 = miEditText.getText().toString();
            miEditText = (EditText) findViewById(R.id.editTextApellido1);
            String Apellido1 = miEditText.getText().toString();
            miEditText = (EditText) findViewById(R.id.editTextApellido2);
            String Apellido2 = miEditText.getText().toString();
            miEditText = (EditText) findViewById(R.id.editTextDireccion);
            String direcc = miEditText.getText().toString();
            miEditText = (EditText) findViewById(R.id.editTextTelefono);
            String telefo = miEditText.getText().toString();
            spinner1 = (Spinner) findViewById(R.id.spnCiudad);
            String ciudad = spinner1.getSelectedItem().toString();
            String[] arrayCiudad = ciudad.split("-");
            String[] arrayTipoDocu = tipodocu.split("-");
            DataBaseManager obj = new DataBaseManager(this);
            String msg = "Cliente guardado con exito localmente!";
            String SQL = "INSERT INTO Cliente VALUES('" + arrayTipoDocu[0] + "-" + documento + "','" + nombre1 + "','" + nombre2 + "','" + Apellido1 + "','" + Apellido2 + "','" + direcc + "','" + telefo + "','"
                    + arrayCiudad[0] + "','" + arrayCiudad[1] + "','" + arrayCiudad[2] + "');";
            obj.crearcliente(SQL);
            mensaje(msg);
        }
        catch (Exception  ex){
            mensaje(ex.getMessage());
        }

    }


public void mensaje(String msg){
    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
}

}
