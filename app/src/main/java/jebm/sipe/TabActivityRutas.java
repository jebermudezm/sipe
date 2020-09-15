package jebm.sipe;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class TabActivityRutas extends Activity {

    private EntidadItem[] arrayItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_activity_rutas);
        ConsultarRuta();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_activity_rutas, menu);
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

    private void ConsultarRuta() {
        DataBaseManager manager = new DataBaseManager(getApplicationContext());
        Cursor cur = manager.ObtenerRuta();

        arrayItems = new EntidadItem[cur.getCount()];
        EntidadItem objitem;
        int i = 0;
        while (cur.moveToNext()) {
            objitem = new EntidadItem();
            objitem.setItem1(cur.getString(0)+"-"+cur.getString(1));
            objitem.setitem2(cur.getString(0));
            arrayItems[i] = objitem;
            i++;
        }
        ListView li = (ListView) findViewById(R.id.lvRutasPreventa);
        //Adaptador
        AdaptadorItem adaptador = new AdaptadorItem(this, arrayItems);
        li.setAdapter(adaptador);
    }

    class AdaptadorItem extends ArrayAdapter<EntidadItem> {

        public AdaptadorItem(Context context, EntidadItem[] datos) {
            super(context, R.layout.listitem_titular, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(arrayItems[position].getItem1());

            TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(arrayItems[position].getpitem2());

            return(item);
        }
    }
}
