package kg.neobis.cinemafish.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kg.neobis.cinemafish.R;


public class GridViewAdapter extends BaseAdapter {
    Context myContext;
    private ArrayList<String> mFilmsNames;
    private ArrayList<String> mFilmsUrlImages;
    View view;
    LayoutInflater layoutInflater;

    public GridViewAdapter(Context myContext, ArrayList<String> mFilmsNames, ArrayList<String> mFilmsUrlImages) {
        this.myContext = myContext;
        this.mFilmsNames = mFilmsNames;
        this.mFilmsUrlImages = mFilmsUrlImages;
        Log.d("GridViewAdapter", "getCount = "+ mFilmsNames.size());
    }

    @Override
    public int getCount() {
        return mFilmsNames.size();

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



            view = new View(myContext);
            view = layoutInflater.inflate(R.layout.gridview_single_item, null);
            ImageView filmImage = view.findViewById(R.id.film_image);
            TextView filmText =  view.findViewById(R.id.film_text);
            Glide.with(myContext).asBitmap().load(mFilmsUrlImages.get(position)).into(filmImage);
            filmText.setText(mFilmsNames.get(position));
            Log.d("GridViewAdapter", "getView if");


        return view;
    }
}