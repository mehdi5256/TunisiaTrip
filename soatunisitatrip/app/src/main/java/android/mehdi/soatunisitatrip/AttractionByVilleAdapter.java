package android.mehdi.soatunisitatrip;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class AttractionByVilleAdapter extends RecyclerView.Adapter<AttractionByVilleAdapter.MyViewHolder> {

    RequestOptions options ;
    private Context mContext ;
    public  List<Attraction> mVille ;
    public static int a ;

    public AttractionByVilleAdapter(Context context, List lst)
    {

        this.mContext = context;
        this.mVille = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_attractionbyville,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.tvname.setText(mVille.get(position).getNomAttraction());
        holder.tvadresse.setText(mVille.get(position).getAdresse());
        Glide.with(mContext).load(mVille.get(position).getImage()).apply(options).into(holder.imageville);

        }

    @Override
    public int getItemCount() {
        return mVille.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvname,tvadresse;
        ImageView imageville;


        public MyViewHolder(View itemView){
            super(itemView);
            tvname=itemView.findViewById(R.id.nom_attraction);
            tvadresse=itemView.findViewById(R.id.adresse_attraction);
            imageville=itemView.findViewById(R.id.image_attraction);

        }
    }

}
