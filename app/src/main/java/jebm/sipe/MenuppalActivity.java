package jebm.sipe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MenuppalActivity extends Activity {

    TextView textviewUsuario;

    String[] titulomenu = new String[]{
            "Sincronizar","Clientes", "Productos", "Preventa", "Cartera","Entrega", "Salir"
    };
    String[] subtitulomenu = new String[]{
            "Envío y recepción de datos",
            "Consultar y registrar nuevos clientes",
            "Consultar productos",
            "Toma de pedidos",
            "Registro de facturas pendientes por cobrar",
            "Entrega de pedidos",
            "Salir del sistema"
    };

    int[] imagenmenu = new int[]{
            R.drawable.sincronizar48,
            R.drawable.usuario48,
            R.drawable.productos48,
            R.drawable.shopcarticon48,
            R.drawable.cartera48,
            R.drawable.cartera48,
            R.drawable.exit48
    };
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuppal);
        textviewUsuario = (TextView) findViewById(R.id.tvUsuario);
        //Bundle args = getIntent().getExtras();
        //String svalue = args.getString("key_usr");
        //textviewUsuario.setText(svalue);

        llenarmenu();
        registrarevento();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menuppal, menu);
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

    private void registrarevento() {
        ListView lv1 = (ListView) findViewById(R.id.lvmenuppal1);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                switch (position) {
                    case 0:
                        i = new Intent(MenuppalActivity.this, MenuSincActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(MenuppalActivity.this, ConsClienteActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(MenuppalActivity.this, ListaProductos.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(MenuppalActivity.this, Preventa.class);
                        //i = new Intent(MenuppalActivity.this, TabActivityClientes.class);
                        startActivity(i);
                        break;
                    case 4:
                        mensaje("En construccion");
                        break;
                    case 5:
                        mensaje("En construccion");
                        break;
                    case 6:
                        finish();
                        System.exit(0);
                }
            }
        });
    }

    private void mensaje(String smensaje){
        // muestra un mensaje
        Toast.makeText(getApplicationContext(), smensaje, Toast.LENGTH_SHORT).show();
    }
    private void llenarmenu() {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> hm;
        for(int i=0;i<6;i++){
            hm = new HashMap<String,String>();
            hm.put("titu", titulomenu[i]);
            hm.put("subt",subtitulomenu[i]);
            hm.put("imgn", Integer.toString(imagenmenu[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "imgn","titu","subt" };

        // Ids of views in listview_layout
        int[] to = { R.id.ivmenuppal,R.id.tvTitulomenuppal,R.id.tvSubtitulomnuppal};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(this, aList, R.layout.menuitem, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView li = ( ListView ) findViewById(R.id.lvmenuppal1);

        // Setting the adapter to the listView
        li.setAdapter(adapter);

    }
}
