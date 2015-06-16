package geolab.lectures.assign2listview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import geolab.lectures.assign2listview.R;
import geolab.lectures.assign2listview.model.GameOfThroneCharacter;

/**
 * Created by Jay on 6/16/2015.
 */
public class CustomDragonGlassAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GameOfThroneCharacter> listData;
    private LayoutInflater inflater;

    public CustomDragonGlassAdapter(Context context, ArrayList<GameOfThroneCharacter> data) {
        this.context = context;
        this.listData = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.listData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        ViewHolder viewHolder;

        if(convertView == null){
            itemView = View.inflate(context, R.layout.listview_item, null);
            viewHolder = new ViewHolder();

            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            TextView nameView = (TextView) itemView.findViewById(R.id.name);

            viewHolder.imageView = imageView;
            viewHolder.nameView = nameView;

            itemView.setTag(viewHolder);
        } else {
            itemView = convertView;
            viewHolder = (ViewHolder) itemView.getTag();
        }

        GameOfThroneCharacter jonSnow = (GameOfThroneCharacter) getItem(position);

        viewHolder.nameView.setText(jonSnow.getName());

        Picasso.with(context)
                .load(jonSnow.getImage())
                .resize(200, 200)
                .centerCrop()
                .into(viewHolder.imageView);

        return itemView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView nameView;
    }
}
