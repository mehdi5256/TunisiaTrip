package android.mehdi.soatunisitatrip;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.MyViewHolder> {
    RequestOptions options ;
    private Context mContext ;
    public List<experience> mExperience ;
    public static int id_usr ;
    public static String  nom_usr ;
    public static String  email_usr;
    public static String name_user;
    public static String  photo_usr;





    public  ExperienceAdapter(Context context,List lst)
    {
        this.mContext = context;
        this.mExperience = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.avatar);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.item_experience,parent,false);

        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.image_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id_usr = mExperience.get(viewHolder.getAdapterPosition()).getId();
                nom_usr = mExperience.get(viewHolder.getAdapterPosition()).getNom();
                email_usr = mExperience.get(viewHolder.getAdapterPosition()).getEmail();
                photo_usr =mExperience.get(viewHolder.getAdapterPosition()).getImage_profil();

                Intent intent = new Intent(mContext,UserProfilActivity.class);
                mContext.startActivity(intent);

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        id_usr = mExperience.get(position).getId();
        nom_usr = mExperience.get(position).getNom();
        email_usr = mExperience.get(position).getEmail();
        photo_usr =mExperience.get(position).getImage_profil();

        holder.username.setText(mExperience.get(position).getNom());

        holder.date_exp.setText(mExperience.get(position).getUpload_date());
        holder.description_exp.setText(mExperience.get(position).getDescription());

        Glide.with(mContext).load(mExperience.get(position).getNom_image()).apply(options).into(holder.image_exp);
        Glide.with(mContext).load(mExperience.get(position).getImage_profil()).apply(options).into(holder.image_profil);

    }

    @Override
    public int getItemCount() {
        return mExperience.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView username;
        TextView date_exp;
        TextView description_exp;

        ImageView image_exp,image_profil,photoprofil;



        public MyViewHolder(View itemView) {
            super(itemView);


            username=itemView.findViewById(R.id.post_user_name);

            date_exp=itemView.findViewById(R.id.post_date);
            description_exp=itemView.findViewById(R.id.descriptionn);

            image_exp=itemView.findViewById(R.id.post_image);
            image_profil=itemView.findViewById(R.id.post_profil_image);

        }
    }
}
