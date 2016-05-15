package pe.cibertec.demo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import pe.cibertec.demo01.adapter.recyclerview.RVFirstAdapter;
import pe.cibertec.demo01.dao.DataBaseHelper;
import pe.cibertec.demo01.dao.DataBaseSingleton;
import pe.cibertec.demo01.dao.PersonaDAO;

public class FirstActivity extends AppCompatActivity {

    private RVFirstAdapter mRVFirstAdapter;
    private RecyclerView rvFirstPersons;
    private EditText etFirstSearch;
    private Button btFirstSearch;
    private PersonaDAO mPersonaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        mPersonaDAO = new PersonaDAO();

        DataBaseHelper dataBaseHelper = new DataBaseHelper(FirstActivity.this);
        try {
            dataBaseHelper.createDataBase();
            new DataBaseSingleton(FirstActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        rvFirstPersons = (RecyclerView) findViewById(R.id.rvFirstPersonas);
        etFirstSearch = (EditText) findViewById(R.id.etFirstSearch);
        btFirstSearch = (Button) findViewById(R.id.btFirstSearch);

        mRVFirstAdapter = new RVFirstAdapter(null);

        rvFirstPersons.setLayoutManager(new LinearLayoutManager(FirstActivity.this));
        rvFirstPersons.setHasFixedSize(true);
        rvFirstPersons.setAdapter(mRVFirstAdapter);

        mRVFirstAdapter.clearAndAddAll(mPersonaDAO.listPersona());

        btFirstSearch.setOnClickListener(btFirstSearchOnClickListener);
    }

    View.OnClickListener btFirstSearchOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (etFirstSearch.getText().toString().trim().isEmpty())
                mRVFirstAdapter.clearAndAddAll(mPersonaDAO.listPersona());
            else
                mRVFirstAdapter.clearAndAddAll(mPersonaDAO.listPersona(etFirstSearch.getText().toString().trim()));
        }
    };
}
