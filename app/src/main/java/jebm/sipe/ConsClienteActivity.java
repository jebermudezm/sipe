package jebm.sipe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class ConsClienteActivity extends ActionBarActivity {

    private DataBaseManager manager;
    private SimpleCursorAdapter adapter;
    private EntidadItem[] arraycli;
    private ListView lv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cons_cliente);
        registrarEventos();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cons_cliente, menu);
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


    public void btnBuscar_onClick(View view) {

        BuscarCliente2();

    }

    private void BuscarCliente2() {
        DataBaseManager manager = new DataBaseManager(getApplicationContext());
        EditText miEditText = (EditText) findViewById(R.id.editTextBuscarCli);
        String parametro = miEditText.getText().toString();
        Cursor cur = manager.ObtenerCliente(parametro);
        arraycli = new EntidadItem[cur.getCount()];
        EntidadItem objitem;
        int i = 0;
        while (cur.moveToNext()){
            objitem = new EntidadItem();
            objitem.setItem1(cur.getString(0));
            objitem.setitem2(cur.getString(1));
            arraycli[i] = objitem;
            i++;
        }
        ListView li = (ListView) findViewById(R.id.lvClientes);
        //Adaptador
        AdaptadorItemCli adaptador = new AdaptadorItemCli(this, arraycli);
        li.setAdapter(adaptador);
    }


    public void btnAddClente_onClick(View view) {
        Intent j = new Intent(this, ClienteActivity.class);
        startActivity(j);
    }
    private void registrarEventos() {

        lv1 = (ListView) findViewById(R.id.lvClientes);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tit = (TextView) view.findViewById(R.id.LblTitulo);
                String titulo = tit.getText().toString();
                TextView stit = (TextView) view.findViewById(R.id.LblSubTitulo);
                String subtitulo = stit.getText().toString();
                mensaje(titulo+"-"+subtitulo);
            }
        });
    }

    private void mensaje(String smensaje){
        // muestra un mensaje
        Toast.makeText(getApplicationContext(), smensaje, Toast.LENGTH_SHORT).show();
    }

    class AdaptadorItemCli extends ArrayAdapter<EntidadItem> {

        public AdaptadorItemCli(Context context, EntidadItem[] datos) {
            super(context, R.layout.listitem_titular, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(arraycli[position].getItem1());

            TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(arraycli[position].getpitem2());

            return(item);
        }
    }

}
