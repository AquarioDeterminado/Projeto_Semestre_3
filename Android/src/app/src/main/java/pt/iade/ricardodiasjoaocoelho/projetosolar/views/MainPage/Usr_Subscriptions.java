package pt.iade.ricardodiasjoaocoelho.projetosolar.views.MainPage;

import static android.app.Activity.RESULT_OK;
import static pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.SubscriptionController.getUserSubscriptions;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters.SubsListAdapter;

public class Usr_Subscriptions extends Fragment {

        public Usr_Subscriptions()
        {
            super(R.layout.user_subscriptions_fragment);
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        /* ---  Widgets --- */
        RecyclerView recyclerView = view.findViewById(R.id.myspaces_spaces_list);
        ArrayList<Subscription> subslist = getUserSubscriptions(User_Info.getUserById(1, ""));


        /* ---  Navigation --- */
        ActivityResultLauncher<Intent> subscriptionInfoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        Subscription sub = data.getExtras().getParcelable("subscription");
                        Log.d("Sub Deleted", "sub deleted " + subslist.remove(sub));
                        AtomicReference<Subscription> match = new AtomicReference<>();
                        subslist.forEach(s -> {
                            if (Subscription.equals(s, sub)) match.set(s);
                        });
                        subslist.remove(match.get());
                        SubsListAdapter subsListAdapter = (SubsListAdapter) recyclerView.getAdapter();
                        subsListAdapter.subsDataSet = subslist.toArray(new Subscription[0]);
                        recyclerView.swapAdapter(subsListAdapter, true);
                    }
                });

        /* ---  Subs List --- */
        //Adapter
        Subscription[] subsDataSet = subslist.toArray(new Subscription[0]);
        SubsListAdapter subsListAdapter = new SubsListAdapter(subsDataSet);
        subsListAdapter.setSubscriptionInfoLauncher(subscriptionInfoLauncher);
        recyclerView.setAdapter(subsListAdapter);

        //Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        return view;
    }
}
