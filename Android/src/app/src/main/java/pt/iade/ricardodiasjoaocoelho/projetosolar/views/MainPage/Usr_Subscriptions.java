package pt.iade.ricardodiasjoaocoelho.projetosolar.views.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.SubscriptionController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters.SubsListAdapter;

public class Usr_Subscriptions extends Fragment {

    private RecyclerView recyclerView;
    private Activity currentActivity;

    public Usr_Subscriptions()
        {
            super(R.layout.user_subscriptions_fragment);
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        Intent intent = getActivity().getIntent();
        int userId = intent.getIntExtra("userID", 0);
        currentActivity = getActivity();

        /* ---  Widgets --- */
        recyclerView = view.findViewById(R.id.myspaces_spaces_list);


        /* ---  Navigation --- */
        ActivityResultLauncher<Intent> subscriptionInfoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    SubscriptionController.getUserSubscriptions(userId, subs -> {
                        currentActivity.runOnUiThread(() -> {
                            SubsListAdapter subsListAdapter = (SubsListAdapter) recyclerView.getAdapter();
                            subsListAdapter.setSubsDataSet(subs.toArray(new Subscription[0]));
                            recyclerView.swapAdapter(subsListAdapter, true);
                        });
                    });
                });

        /* ---  Subs List --- */
        //Adapter
        setSubscriptionsRecycle(userId, subscriptionInfoLauncher);

        return view;
    }

    private void setSubscriptionsRecycle(int userId, ActivityResultLauncher<Intent> subscriptionInfoLauncher) {
        ArrayList<Subscription> subsDataSet = new ArrayList<>();
        SubsListAdapter subsListAdapter = new SubsListAdapter(subsDataSet.toArray(new Subscription[0]));
        subsListAdapter.setSubscriptionInfoLauncher(subscriptionInfoLauncher);
        recyclerView.setAdapter(subsListAdapter);

        //Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        SubscriptionController.getUserSubscriptions(userId, subs -> {
            currentActivity.runOnUiThread(() -> {
                subsListAdapter.setSubsDataSet(subs.toArray(new Subscription[0]));
                recyclerView.swapAdapter(subsListAdapter, true);
                subsListAdapter.notifyDataSetChanged();
            });
        });
    }
}
