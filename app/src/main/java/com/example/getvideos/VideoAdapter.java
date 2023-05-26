package com.example.getvideos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    ArrayList<Video> video = new ArrayList<>();
    Context context;

    public VideoAdapter (Context context,ArrayList<Video> videos){
        this.context = context;
        this.video = videos;
    }
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_layout,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        Video videoModel = video.get(position);
        holder.titleText.setText(videoModel.getTitle());
        holder.pathText.setText(videoModel.getPath());
        String path = videoModel.getPath().toString();
        Glide.with(holder.itemView.getContext())
                .load(videoModel.getThumbnilUri())
                .placeholder(R.drawable.video_icon)
                .centerCrop()
                .into(holder.thumbnil_video);

        holder.crd_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,VideoplayerActivity.class);
                intent.putExtra("videoPath",path);
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return video.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder{

        TextView titleText,pathText;
        ImageView thumbnil_video;

        CardView crd_view;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.title_tv);
            pathText = itemView.findViewById(R.id.path_tv);
            thumbnil_video = itemView.findViewById(R.id.thumbnil_video);
            crd_view = itemView.findViewById(R.id.card_view);

        }
    }
}
