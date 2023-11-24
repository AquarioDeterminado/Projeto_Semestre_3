package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

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
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Company;

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
    private final Company[] companies;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            TextView companyName1 = (TextView) view.findViewById(R.id.plant_selector_coworking_name_1);
            TextView companyName2 = (TextView) view.findViewById(R.id.plant_selector_coworking_name_2);
            TextView companyName3 = (TextView) view.findViewById(R.id.plant_selector_coworking_name_3);
            TextView companyName4 = (TextView) view.findViewById(R.id.plant_selector_coworking_name_4);

            ImageView companyLogo1 = (ImageView) view.findViewById(R.id.plant_selector_office_preview_image_1);
            ImageView companyLogo2 = (ImageView) view.findViewById(R.id.plant_selector_office_preview_image_2);
            ImageView companyLogo3 = (ImageView) view.findViewById(R.id.plant_selector_office_preview_image_3);
            ImageView companyLogo4 = (ImageView) view.findViewById(R.id.plant_selector_office_preview_image_4);


            Button companyButton1 = (Button) view.findViewById(R.id.plant_selector_office_preview_button_company_1);
            Button companyButton2 = (Button) view.findViewById(R.id.plant_selector_office_preview_button_company_2);
            Button companyButton3 = (Button) view.findViewById(R.id.plant_selector_office_preview_button_company_3);
            Button companyButton4 = (Button) view.findViewById(R.id.plant_selector_office_preview_button_company_4);
        }
    }
    public CompanyListAdapter(Company[] companies) {
        this.companies = companies;
    }
    @Override
    public CompanyListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_plan_selelector_location, viewGroup, false);
        return new CompanyListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(CompanyListAdapter.ViewHolder holder, final int position) {
        /* --- Set Widgets --- */

        holder.companyName1.setText(companies[position].getName());
        holder.companyName2.setText(companies[position].getName());
        holder.companyName3.setText(companies[position].getName());
        holder.companyName4.setText(companies[position].getName());

        holder.companyLogo1.setImageResource(companies[position].getLogo());
        holder.companyLogo2.setImageResource(companies[position].getLogo());
        holder.companyLogo3.setImageResource(companies[position].getLogo());
        holder.companyLogo4.setImageResource(companies[position].getLogo());

        holder.companyButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Floor_Plan_Availabibity.class);

            }
        }
    }
}