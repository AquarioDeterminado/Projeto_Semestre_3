package pt.iade.ricardodiasjoaocoelho.projetosolar.views.MainPage;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.LocationController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Location;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters.LocationListAdapter;

public class Company_Plan_Selelector_Fragment extends Fragment {

    private Activity currentActiviy;

    public Company_Plan_Selelector_Fragment() { super(R.layout.activity_plan_selelector_location); }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_plan_selelector_location, container, false);
        currentActiviy = getActivity();
        Intent intent = getActivity().getIntent();
        int userId = intent.getIntExtra("userID", 0);

        /* ---  Widgets --- */
        RecyclerView locationRecycle = view.findViewById(R.id.plan_selector_company_list);

        /* --- Set Events --- */
        //Adapter
        setSpacesRecycleView(userId, locationRecycle);

        return view;
    }

    private void setSpacesRecycleView(int userId, RecyclerView locationRecycle) {
        ArrayList<Location> locations = new ArrayList<>();
        Location[] locationsArray = locations.toArray(new Location[0]);
        LocationListAdapter adapter = new LocationListAdapter(locationsArray);
        adapter.setUserId(userId);
        locationRecycle.setAdapter(adapter);

        //Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        locationRecycle.setLayoutManager(layoutManager);

        locationRecycle.setHasFixedSize(true);

        LocationController.getUserAccessibleLocations(userId, new LocationController.ReturnLocations() {
            @Override
            public void response(ArrayList<Location> locations) {
                currentActiviy.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setLocations(locations);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

}
