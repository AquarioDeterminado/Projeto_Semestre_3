package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

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
class CompanyListAdapter extends RecyclerView.Adapter<Company_Plan_Selelector.CompanyListAdapter.ViewHolder> {
    private
}