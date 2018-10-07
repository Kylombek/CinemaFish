package kg.neobis.cinemafish.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


import kg.neobis.cinemafish.GridViewActivity;
import kg.neobis.cinemafish.MainActivity;
import kg.neobis.cinemafish.R;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> menuImageUrls ;
    private ArrayList<String> menuKinoteatrNames ;
    private Context mcontext;
    private OnItemClickListener listener;

    public RecyclerViewAdapter(ArrayList<String> menuImageUrls, ArrayList<String> menuKinoteatrNames, Context mcontext, OnItemClickListener listener) {
        this.menuImageUrls = menuImageUrls;
        this.menuKinoteatrNames = menuKinoteatrNames;
        this.mcontext = mcontext;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder : called");

        Glide.with(mcontext).asBitmap().load(menuImageUrls.get(position)).into(viewHolder.menuCircleImageView);
        viewHolder.menuText.setText(menuKinoteatrNames.get(position));
        viewHolder.bind(listener);



    }

    @Override
    public int getItemCount() {
        return menuKinoteatrNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView menuCircleImageView;
        private TextView menuText;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            menuCircleImageView = itemView.findViewById(R.id.menuImage);
            menuText = itemView.findViewById(R.id.rvItemText);
            parentLayout = itemView.findViewById(R.id.linear);
        }

        public void bind(final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!= null){
                    listener.openGridActivity();}
                }
            });
        }
    }
    public interface OnItemClickListener {
        void openGridActivity();
    }



}
