package pe.cibertec.demo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.cibertec.demo02.adapter.recycleview.RVFirstAdapter;
import pe.cibertec.demo02.dao.DataBaseHelper;
import pe.cibertec.demo02.dao.DataBaseSingleton;
import pe.cibertec.demo02.dao.PersonaDAO;

public class FirstActivity extends AppCompatActivity {

    private EditText etFirstSearch;
    private Button btFirstSearch;
    private RecyclerView rvFirstPerson;
    private RVFirstAdapter mRVFirstAdapter;
    private PersonaDAO mPersonaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(FirstActivity.this);
            dataBaseHelper.createDataBase();
            new DataBaseSingleton(FirstActivity.this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        etFirstSearch = (EditText) findViewById(R.id.etFirstSearch);
        btFirstSearch = (Button) findViewById(R.id.btFirstSearch);
        rvFirstPerson = (RecyclerView) findViewById(R.id.rvFirstPerson);

        mRVFirstAdapter = new RVFirstAdapter();
        rvFirstPerson.setLayoutManager(new LinearLayoutManager(FirstActivity.this));
        rvFirstPerson.setAdapter(mRVFirstAdapter);

        mPersonaDAO = new PersonaDAO();

        mRVFirstAdapter.clearAllAndAdd(mPersonaDAO.listPersonas(""));

        btFirstSearch.setOnClickListener(btFirstSearchOnClickListener);
    }

    View.OnClickListener btFirstSearchOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            mRVFirstAdapter.clearAllAndAdd(mPersonaDAO.listPersonas(etFirstSearch.getText().toString().trim()));
        }
    };
}
