package geolab.lectures.assign2listview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import geolab.lectures.assign2listview.adapters.CustomDragonGlassAdapter;
import geolab.lectures.assign2listview.model.GameOfThroneCharacter;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<GameOfThroneCharacter> listViewData = getGameOfThroneData();
        CustomDragonGlassAdapter adapter = new CustomDragonGlassAdapter(this, listViewData);

        ListView listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("GameOfThroneCharacter", (GameOfThroneCharacter)parent.getAdapter().getItem(position));
                startActivity(intent);
            }
        });

    }

    private ArrayList<GameOfThroneCharacter> getGameOfThroneData(){
        ArrayList<GameOfThroneCharacter> list = new ArrayList<>();

        for(int j = 0; j < 8; j++) {
            for (int i = 0; i < WinterIsComing.names.length; i++) {
                GameOfThroneCharacter dragon = new GameOfThroneCharacter(WinterIsComing.names[i], WinterIsComing.descriptions[i], WinterIsComing.images[i]);
                list.add(dragon);
            }
        }

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
