package com.zermeno.isaac.evidencia3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class UsersContract {
    private UsersContract(){}

    public static class UsersEntry implements BaseColumns{
        public static String TABLE_NAME = "UsersDataBase";
        public static String Column_Nombre = "Nombre";
        public static String Column_pApellido = "Primer_apellido";
        public static String Column_sApellido = "Segundo_apellido";
        public static String Column_nFecha = "Fecha_de_Nacimiento";
        public static String Column_Estado = "Estado";
        public static String Column_Genero = "Genero";
    }

    private static final String SqlUser_CREATE_ENTRIES = "CREATE TABLE " + UsersEntry.TABLE_NAME + " (" +
            UsersEntry._ID + " INTEGER PRIMARY KEY," +
            UsersEntry.Column_Nombre + " TEXT, " +
            UsersEntry.Column_pApellido + " TEXT, " +
            UsersEntry.Column_sApellido + " TEXT, " +
            UsersEntry.Column_nFecha + " TEXT, " +
            UsersEntry.Column_Estado + " TEXT, " +
            UsersEntry.Column_Genero + " TEXT)";

    private static final String SqlUser_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UsersEntry.TABLE_NAME;


    //SQL_DB_HELPER DB_HELPER = new SQL_DB_HELPER(getContext());

    public class SQL_DB_HELPER extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "UsuariosBD.db";

        public SQL_DB_HELPER(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SqlUser_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(SqlUser_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

        //SQLiteDatabase db = DB_HELPER.getWritableDatabase();
        public void insertCurp(Usuarios user){
            ContentValues values = new ContentValues();
            values.put(UsersEntry.Column_Nombre, user.nombre);
            values.put(UsersEntry.Column_pApellido, user.pApellido);
            values.put(UsersEntry.Column_sApellido, user.sApellido);
            values.put(UsersEntry.Column_nFecha, user.nFecha);
            values.put(UsersEntry.Column_Estado, user.estado;
            values.put(UsersEntry.Column_Genero, user.genero);
        }
    }



    long Column_ID = db.insert(UsersEntry.TABLE_NAME, null, values);




    //SQLiteDatabase db = DB_HELPER.getReadableDatabase();

    String [] projection = {
            BaseColumns._ID,
            UsersEntry.Column_Nombre,
            UsersEntry.Column_pApellido,
            UsersEntry.Column_sApellido,
            UsersEntry.Column_nFecha,
            UsersEntry.Column_Estado,
            UsersEntry.Column_Genero
    };

    String FiltroSeleccion = UsersEntry.Column_Nombre + " = ?";
    String [] FiltroSeleccionado = { "Nombre-?"};

    String OrdenDeVista =
            UsersEntry.Column_pApellido + " DESC";

    Cursor cursor = db.query(
            UsersEntry.TABLE_NAME, //La tabla que se va a mandar  a llamar
            projection,             //Las columnas que se van a llamar
            FiltroSeleccion,              //Las columnas indicadas en el WHERE
            FiltroSeleccionado,           //Los valores indicados en el WHERE
            null,                //No se agruparan las filas
            null,                 //No filtar por grupos de filas
            OrdenDeVista                 //El orden en que se mostraran los elementos
    );

    List UsersIDs = new ArrayList<>();
    while(cursor.moveToNext()){
        long UserID = cursor.getLong(
                cursor.getColumnIndexOrThrow(UsersEntry._ID));
        UsersIDs.add(UserID);
        )
        cursor.close();
    }

    //Se define el WHERE de la consulta
    String getFiltroSeleccion = UsersEntry.Column_Nombre + " LIKE ?":
    //Se especifican los argumentos por orden
    String[] getFiltroSeleccionado = { "Nombre-?"};
    //Issue SQL statement
    int BorrarFilas = db.delete(UsersEntry.TABLE_NAME, FiltroSeleccion, FiltroSeleccionado);


    SQLiteDatabase db = DB_HELPER.getWritableDatabase();

    //Nuevo valor para la columna
    String Nombre = "NuevoNombre";
    ContentValues values = new ContentValues();
    values.put(UsersEntry.Column_Nombre, Nombre);

    //La columna que se actualiza basada en el Nombre
    String FiltroSeleccion = UsersEntry.Column_Nombre + " LIKE ?";
    String[] FiltroSeleccionado = { "NombreViejo"};

    int count = db.update(
            DB_HELPER.UsersEntry.TABLE_NAME,
            values,
            FiltroSeleccion,
            FiltroSeleccionado);

    @Override
    protected void onDestroy(){
        DB_HELPER.close();
        super.onDestroy();
    }




}

