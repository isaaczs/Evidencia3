package com.zermeno.isaac.evidencia3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        Usuarios u = intent.getParcelableExtra("user");

        ((TextView) findViewById(R.id.outputNombre)).setText(u.nombre);
        ((TextView) findViewById(R.id.outputPrimerApellido)).setText(u.pApellido);
        ((TextView) findViewById(R.id.outputSegundoApellido)).setText(u.sApellido);
        ((TextView) findViewById(R.id.outpuFecha)).setText(u.nFecha);
        ((TextView) findViewById(R.id.outputEstado)).setText(u.estado);
        ((TextView) findViewById(R.id.outputGenero)).setText(u.genero);

    }
    SQLiteDatabase db = DB_HELPER.getWritableDatabase();


    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
