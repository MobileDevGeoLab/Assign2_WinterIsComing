package geolab.lectures.assign2listview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import geolab.lectures.assign2listview.model.GameOfThroneCharacter;


public class DetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        GameOfThroneCharacter johnSnow = (GameOfThroneCharacter) getIntent().getExtras().getSerializable("GameOfThroneCharacter");

        TextView nameView = (TextView) findViewById(R.id.name);
        TextView descriptionView = (TextView) findViewById(R.id.description);
        ImageView imageView = (ImageView) findViewById(R.id.image);

        nameView.setText(johnSnow.getName());
        descriptionView.setText(johnSnow.getDescription());

        Picasso.with(this)
                .load(johnSnow.getImage())
                .resize(400, 400)
                .centerCrop()
                .into(imageView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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
