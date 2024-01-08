package pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;

public class SubscriptionListAdapter extends RecyclerView.Adapter<SubscriptionListAdapter.ViewHolder>{

    private ArrayList<Subscription> subscriptionArrayList;
    private ActivityResultLauncher<Intent> subscriptionActivityResultLauncher;

    public SubscriptionListAdapter(ArrayList<Subscription> subscriptions, ActivityResultLauncher<Intent> subscriptionActivityResultLauncher) {
        this.subscriptionArrayList = subscriptions;
        this.subscriptionActivityResultLauncher = subscriptionActivityResultLauncher;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView subscriptionTitle;
        private TextView subscriptionDescrip;
        private TextView subscriptionRenewal;
        private Button subscriptionPrice;


        public ViewHolder(View parent) {
            super(parent);
            subscriptionTitle = parent.findViewById(R.id.space_info_plan_1_title2);
            subscriptionDescrip = parent.findViewById(R.id.space_info_plan_1_decrip2);
            subscriptionRenewal = parent.findViewById(R.id.space_info_plan_1_renewal2);
            subscriptionPrice = parent.findViewById(R.id.space_info_plan_1_bttn2);
        }
    }

    @Override
    public SubscriptionListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_plan_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionListAdapter.ViewHolder holder, int position) {
        holder.subscriptionTitle.setText(subscriptionArrayList.get(position).getTitle());
        //holder.subscriptionDescrip.setText(subscriptionArrayList.get(position).getDescription());
        holder.subscriptionDescrip.setText("");
        holder.subscriptionRenewal.setText(subscriptionArrayList.get(position).getRenewal());
        holder.subscriptionPrice.setText(String.valueOf(subscriptionArrayList.get(position).getPrice()));
        holder.subscriptionPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Subscription.class);
                subscriptionActivityResultLauncher.launch(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subscriptionArrayList.size();
    }

    public void setSubscriptionArrayList(ArrayList<Subscription> subscriptionArrayList) {
        this.subscriptionArrayList = subscriptionArrayList;
    }

    public void setSubscriptionActivityResultLauncher(ActivityResultLauncher<Intent> subscriptionActivityResultLauncher) {
        this.subscriptionActivityResultLauncher = subscriptionActivityResultLauncher;
    }

}
