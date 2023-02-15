package com.zahidgurbuz.week07.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.zahidgurbuz.week07.R;
import com.zahidgurbuz.week07.models.HairModel;

import java.util.ArrayList;

public class HairModelAdapter extends RecyclerView.Adapter<HairModelAdapter.HairModelViewHolder>{
    //Props
    ArrayList<HairModel> mDataset;
    Context mContext;

    //Constants
    private static final int HEADER = 1;
    private static final int ITEM = 0;

    //Constructor
    public HairModelAdapter(ArrayList<HairModel> mDataset, Context mContext) {
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    //Inflater object created and implemented
    public HairModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        HairModelViewHolder holder;
        View itemView;
        switch (viewType){
            case ITEM:
                itemView = layoutInflater.inflate(R.layout.hairmodel_list_item, parent, false);
                holder = new HairModelViewHolderItem(itemView, mContext);
                break;
            case HEADER:
                itemView = layoutInflater.inflate(R.layout.hairmodel_list_header, parent, false);
                holder = new HairModelViewHolderHeader(itemView, mContext);
                break;
            default:
                itemView = layoutInflater.inflate(R.layout.hairmodel_list_item, parent, false);
                holder = new HairModelViewHolderItem(itemView, mContext);
                break;
        }
        return holder;
    }

    @Override
    //Get the position if the dataset item
    public void onBindViewHolder(@NonNull HairModelViewHolder holder, int position) {
        holder.bind(mDataset.get(position));
    }

    @Override
    //Get the size of the dataset - number of data
    public int getItemCount() {   return mDataset.size();    }

    @Override
    //Determines the dataset type by checking it from "HairModel" class
    public int getItemViewType(int position) {
        return mDataset.get(position).getIsHeader()?HEADER:ITEM; //if else operator ?:
    }

    //ViewHolder class
    public static abstract class HairModelViewHolder extends RecyclerView.ViewHolder{

        public HairModelViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public abstract void bind(HairModel item);
    }

    //ViewHolderItem xml file implementation extends ViewHolder
    public static class HairModelViewHolderItem extends HairModelViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout hairLayout;
        Context mComtext;
        public HairModelViewHolderItem(@NonNull View itemView, Context context) {
            super(itemView);
            this.mComtext=context;
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.hairLayout = (LinearLayout) itemView.findViewById(R.id.hairLayout);
        }

        public void bind(HairModel item){
            this.textView.setText(item.getTitle());
            this.hairLayout.setBackgroundColor(item.getColor());
            Glide.with(mComtext)
                    .load(item.getUrl())
                    .into(this.imageView);
        }
    }

    //ViewHolderHeader xml file implementation extends ViewHolder
    public static class HairModelViewHolderHeader extends HairModelViewHolder {
        TextView textView;
        LinearLayout hairLayout;
        Context mComtext;
        public HairModelViewHolderHeader(@NonNull View itemView, Context context) {
            super(itemView);
            this.mComtext=context;
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.hairLayout = (LinearLayout) itemView.findViewById(R.id.hairLayout);
        }

        public void bind(HairModel item){
            this.textView.setText(item.getTitle());
            this.hairLayout.setBackgroundColor(item.getColor());

        }
    }
}
