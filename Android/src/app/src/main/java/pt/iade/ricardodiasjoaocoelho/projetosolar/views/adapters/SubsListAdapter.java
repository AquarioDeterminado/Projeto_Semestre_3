package pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.RecyclerView;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Subscription_Info;

public class SubsListAdapter extends RecyclerView.Adapter<SubsListAdapter.ViewHolder> {
    private Subscription[] subsDataSet;
    private ActivityResultLauncher<Intent> subscriptionInfoLauncher;

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
        //holder.subImage.setImageIcon(subsDataSet[position].getImage());

        /* --- Navigation --- */
        holder.subMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() , Subscription_Info.class);
                intent.putExtra("subscription", subsDataSet[position]);
                subscriptionInfoLauncher.launch(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subsDataSet.length;
    }

    public void setSubscriptionInfoLauncher(ActivityResultLauncher<Intent> subscriptionInfoLauncher) {
        this.subscriptionInfoLauncher = subscriptionInfoLauncher;
    }

    public void setSubsDataSet(Subscription[] subsDataSet) {
        this.subsDataSet = subsDataSet;
    }
}
