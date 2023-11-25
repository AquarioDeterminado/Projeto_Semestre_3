package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.CoworkSpaceController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;

public class Company_Plan_Selelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_selelector_location);
    }
    /* ---  Widgets --- */
    private View view;
    RecyclerView compList = view.findViewById(R.id.plan_selector_company_list);

    /* --- Set Events --- */
    //Adapter

}
class CompanyListAdapter extends RecyclerView.Adapter<CompanyListAdapter.ViewHolder> {
    private final CoworkSpace[] companies;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Button companyButton;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            companyButton = (Button) view.findViewById(R.id.plan_row_item);
        }
    }
    public CompanyListAdapter(CoworkSpace[] companies) {
        this.companies = companies;
    }
    @NonNull
    @Override
    public CompanyListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plan_row_item, viewGroup, false);
        return new CompanyListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(CompanyListAdapter.ViewHolder holder, final int position) {
        /* --- Set Widgets --- */
        holder.companyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Floor_Plan_Availabibity.class);
                myIntent.putExtra("Floor Plan", companies[position]);
                startActivity(v.getContext(), myIntent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}