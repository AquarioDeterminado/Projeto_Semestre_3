package pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Space_Info;

public class SpaceListAdapter extends RecyclerView.Adapter<SpaceListAdapter.ViewHolder> {
    private CoworkSpace[] coworkSpaceDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView spaceName;
        private final ImageView spaceImage;
        private final Button spaceBttn;

        public ViewHolder(View view) {
            super(view);
            spaceName = view.findViewById(R.id.space_row_item_name);
            spaceImage = view.findViewById(R.id.space_row_item_img);
            spaceBttn = view.findViewById(R.id.space_row_item_button);
        }

    }
    public SpaceListAdapter(CoworkSpace[] coworkSpaceDataSet) {
        this.coworkSpaceDataSet = coworkSpaceDataSet;
    }

    @Override
    public SpaceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.space_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SpaceListAdapter.ViewHolder holder, int position) {
        /* --- Set Widgets --- */
        holder.spaceName.setText(coworkSpaceDataSet[position].getName());
        //holder.spaceImage.setImageResource(spaceDataSet[position].getImage());

        holder.spaceBttn.setText((R.string.mainpage_spaces_show_me_more_bttn));
        /* --- Navigation --- */
        holder.spaceBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() , Space_Info.class);
                String eventId = coworkSpaceDataSet[position].getId();
                intent.putExtra("eventID", eventId);
                startActivity(v.getContext(), intent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coworkSpaceDataSet.length;
    }
}
