package aplicacion.android.mpinto.listview_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    private List<String> nombres;
    private GridView gridView;
    private MyAdapter myAdapter;
    private int contador = 0;
    private int contar = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = (GridView) findViewById(R.id.gridView);
        nombres = new ArrayList<String>();
        nombres.add("diego");
        nombres.add("juan");
        nombres.add("jorge");
        nombres.add("matias");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridActivity.this, "clic en " + nombres.get(i), Toast.LENGTH_LONG).show();
            }
        });
        //Enlazamos con nuestro adaptador personalizado
        myAdapter = new MyAdapter(this, R.layout.grid_item, nombres);
        gridView.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                if(contador<0)
                    contador = 0;
                //agregamos nuevo nombre
                this.nombres.add("agregar nombre " + (++contador));
                 contar++;
                //Notificamos al adaptador del cambio producido
                this.myAdapter.notifyDataSetChanged();
                return true;
            case R.id.delete_item:
                //agregamos nuevo nombre
                this.nombres.remove(contar--);
                contador--;
                //Notificamos al adaptador del cambio producido
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
