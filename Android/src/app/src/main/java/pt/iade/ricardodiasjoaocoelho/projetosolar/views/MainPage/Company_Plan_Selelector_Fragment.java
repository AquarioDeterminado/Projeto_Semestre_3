package pt.iade.ricardodiasjoaocoelho.projetosolar.views.MainPage;


import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.LocationController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Location;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Floor_Plan_Availabibity;

public class Company_Plan_Selelector_Fragment extends Fragment {

    public Company_Plan_Selelector_Fragment() { super(R.layout.activity_plan_selelector_location); }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_plan_selelector_location, container, false);

        /* ---  Widgets --- */
        RecyclerView locationRecycle = view.findViewById(R.id.plan_selector_company_list);

        /* --- Set Events --- */
        //Adapter
        ArrayList<Location> locations = LocationController.getUserAccessibleLocations();
        Location[] locationsArray = locations.toArray(new Location[0]);
        LocationListAdapter adapter = new LocationListAdapter(locationsArray);
        locationRecycle.setAdapter(adapter);

        //Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        locationRecycle.setLayoutManager(layoutManager);

        locationRecycle.setHasFixedSize(true);

        return view;
    }

}
class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.ViewHolder> {
    private final Location[] locations;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout background;
        private final TextView capacityRate;
        private final TextView locationName;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            background = (ConstraintLayout) view.findViewById(R.id.plan_row_item_background);
            capacityRate = (TextView) view.findViewById(R.id.plan_row_item_capacity_rate);
            locationName = (TextView) view.findViewById(R.id.plan_row_item_location_name);
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
        holder.capacityRate.setText(locations[position].getCapacityRate() + "%");

        holder.locationName.setText(locations[position].getName());
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Floor_Plan_Availabibity.class);
                myIntent.putExtra("location", locations[position]);
                startActivity(v.getContext(), myIntent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locations.length;
    }
}