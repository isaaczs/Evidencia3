package com.zermeno.isaac.evidencia3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    private int año;
    private int mes;
    private int dia;
    private EditText inputFecha;
    private Button bFecha;


    private static final int ID_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener recibeFecha;
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //se obtiene una instancia de los controles GUI dentro del Layout
        inputFecha = (EditText) findViewById(R.id.inputFecha);
        bFecha = (Button) findViewById(R.id.bFecha);

        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH)+1;
        dia = calendario.get(Calendar.DAY_OF_MONTH);

        mostrarFecha();

        recibeFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año = year;
                mes = month;
                dia = dayOfMonth;

                mostrarFecha();
            }

        };

        // AGREGANDO UN SPINNER QUE MANDA A LLAMAR EL ARREGLO CON TODOS LOS ESTADOS

        Spinner spinnerEstado;

        setContentView(R.layout.activity_main2);

        spinnerEstado = (Spinner)findViewById(R.id.spEstado);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_estados, android.R.layout.simple_spinner_item);
        spinnerEstado.setAdapter(adapter);
    }

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case 0:
                return new DatePickerDialog(this, recibeFecha, año, mes+1, dia);
        }
        return null;
    }

    public void mostrarCalendario (View control){
        showDialog(ID_DIALOGO);
    }

    public void mostrarFecha(){
        inputFecha.setText(dia+"/"+mes+"/"+año);
    }


    public void infoUsuario(View view) {
        Usuarios u = new Usuarios();

        u.nombre = ((EditText)findViewById(R.id.inputNombre)).getText().toString();
        u.pApellido = ((EditText)findViewById(R.id.inputPrimerApellido)).getText().toString();
        u.sApellido = ((EditText)findViewById(R.id.inputSegundoApellido)).getText().toString();
        u.nFecha = ((EditText)findViewById(R.id.inputFecha)).getText().toString();
        u.estado = ((Spinner)findViewById(R.id.spEstado)).getSelectedItem().toString();
        u.genero = ((RadioButton)findViewById(((RadioGroup)findViewById(R.id.grupoGenero)).getCheckedRadioButtonId())).getText().toString();

        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        intent.putExtra("user", u);
        startActivity(intent);

    }
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
    SQLiteDatabase db = DB_HELPER.getReadableDatabase();


}
