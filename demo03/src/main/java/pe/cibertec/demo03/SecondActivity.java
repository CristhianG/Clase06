package pe.cibertec.demo03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Android-SAB-PM on 14/05/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private Toolbar toolbar_item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        toolbar_item = (Toolbar) findViewById(R.id.toolbar_item);

        setSupportActionBar(toolbar_item);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar_item.setTitle("Hola");
        getSupportActionBar().setTitle(R.string.toolbar_title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        else if (item.getItemId()==R.id.ab_save)
            Toast.makeText(SecondActivity.this,"Presionó editar",Toast.LENGTH_SHORT).show();

        return true;
    }
}