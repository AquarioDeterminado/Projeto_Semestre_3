package pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Location;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Floor_Plan_Availabibity;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.ViewHolder> {
    private Location[] locations;
    private int userId;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout background;
        private final TextView locationName;

        private final TextView spaceOccupancyRate;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            background = (ConstraintLayout) view.findViewById(R.id.plan_row_item_background);
            locationName = (TextView) view.findViewById(R.id.plan_row_item_location_name);
            spaceOccupancyRate = (TextView) view.findViewById(R.id.plan_row_item_capacity_rate);
        }
    }
    public LocationListAdapter(Location[] locations) {
        this.locations = locations;
    }
    @NonNull
    @Override
    public LocationListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plan_row_item, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(LocationListAdapter.ViewHolder holder, final int position) {
        /* --- Set Widgets --- */
        holder.locationName.setText(locations[position].getName());
        double occupancyRate = locations[position].getOccupanctRate() * 100;
        holder.spaceOccupancyRate.setText(occupancyRate + "%");

        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Floor_Plan_Availabibity.class);
                myIntent.putExtra("location", locations[position]);
                myIntent.putExtra("userId", userId);
                startActivity(v.getContext(), myIntent, null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return locations.length;
    }

    public void setLocations(ArrayList<Location> locations){
        this.locations = locations.toArray(new Location[0]);
        notifyDataSetChanged();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
