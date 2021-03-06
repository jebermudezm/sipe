package jebm.sipe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MenuSincActivity extends ActionBarActivity {

    String[] titulomenusinc = new String[]{
            "Iniciar Preventa","Finalizar Preventa", "Iniciar Reparto", "Finalizar Reparto", "Iniciar Cobranza","Finalizar Cobranza"
    };
    String[] subtitulomenusinc = new String[]{
            "Recibir rutas, clientes y articulos",
            "Enviar pedidos tomados",
            "Recibir pedidos a entregar",
            "Actualizar operaciones y stock",
            "recibir saldos de clientes",
            "Enviar cobranzas y actualizar saldos"
    };

    int[] imagenmenusinc = new int[]{
            R.drawable.sincronizar48,
            R.drawable.sincronizar48,
            R.drawable.sincronizar48,
            R.drawable.sincronizar48,
            R.drawable.sincronizar48,
            R.drawable.sincronizar48
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sinc);
        llenarmenu();
        registrarevento();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_sinc, menu);
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
        ListView lv1 = (ListView) findViewById(R.id.lvMenuSinc);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                switch (position) {
                    case 0:
                        mensaje("En construccion");
                        break;
                    case 1:
                        mensaje("En construccion");
                        break;
                    case 2:
                        mensaje("En construccion");
                        break;
                    case 3:
                        mensaje("En construccion");
                        break;
                    case 4:
                        mensaje("En construccion");
                        break;
                    case 5:
                        mensaje("En construccion");
                        break;
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
        for(int i=0;i<5;i++){
            hm = new HashMap<String,String>();
            hm.put("titu", titulomenusinc[i]);
            hm.put("subt",subtitulomenusinc[i]);
            hm.put("imgn", Integer.toString(imagenmenusinc[i]) );
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
        ListView li = ( ListView ) findViewById(R.id.lvMenuSinc);

        // Setting the adapter to the listView
        li.setAdapter(adapter);

    }
}
