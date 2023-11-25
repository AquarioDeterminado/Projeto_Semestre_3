package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import static pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.SubscriptionController.getUserSubscriptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;

public class Usr_Subscriptions extends Fragment {

        public Usr_Subscriptions()
        {
            super(R.layout.user_spaces_fragment);
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  super.onCreateView(inflater, container, savedInstanceState);

        /* ---  Widgets --- */
        RecyclerView recyclerView = view.findViewById(R.id.myspaces_spaces_list);

        /* ---  Subs List --- */
        //Adapter
        Subscription[] subslist = getUserSubscriptions(new User_Info("1")).toArray(new Subscription[0]);
        SubsListAdapter subsListAdapter = new SubsListAdapter(subslist);
        recyclerView.setAdapter(subsListAdapter);

        //Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        return view;
    }

    class SubsListAdapter extends RecyclerView.Adapter<SubsListAdapter.ViewHolder> {
        private Subscription[] subsDataSet;
        public class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView spaceName;
            private final TextView subTitle;
            private final ImageView subImage;
            private final Button subMoreInfo;
            public ViewHolder(View view) {
                super(view);
                spaceName = view.findViewById(R.id.sub_row_item_space_name);
                subTitle = view.findViewById(R.id.sub_row_item_sub);
                subImage = view.findViewById(R.id.sub_row_item_img);
                subMoreInfo = view.findViewById(R.id.sub_row_item_bttn);
            }

        }
        public SubsListAdapter(Subscription[] subsDataSet) {
            this.subsDataSet = subsDataSet;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sub_row_item, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SubsListAdapter.ViewHolder holder, int position) {
            /* --- Set Widgets --- */
            holder.subTitle.setText(subsDataSet[position].getTitle());
            holder.subImage.setImageIcon(subsDataSet[position].getImage());
            //holder.eventImage.setImageResource(eventDataSet[position].getImage());

            /* --- Navigation --- */
            holder.subMoreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext() , Subscription_Info.class);
                    intent.putExtra("subscription", subsDataSet[position]);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return subsDataSet.length;
        }
    }
}