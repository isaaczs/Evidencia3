package com.zermeno.isaac.evidencia3;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

public class Usuarios implements Parcelable {
    String nombre;
    String pApellido;
    String sApellido;
    //int edad;
    String nFecha;
    String estado;
    String genero;

    public Usuarios(){
        this.nombre = "";
        this.pApellido = "";
        this.sApellido = "";
        //this.edad = 0;
        this.nFecha = "";
        this.estado = "";
        this.genero = "";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(pApellido);
        dest.writeString(sApellido);
        //dest.writeInt(edad);
        dest.writeString(nFecha);
        dest.writeString(estado);
        dest.writeString(genero);
    }

    public static final Creator<Usuarios> CREATOR
            = new Creator<Usuarios>(){
        public Usuarios createFromParcel(Parcel in){
            return new Usuarios(in);
        }

        @Override
        public Usuarios[] newArray(int size) {
            return new Usuarios[size];
        }
    };

    public Usuarios(Parcel in){
        nombre = in.readString();
        pApellido = in.readString();
        sApellido = in.readString();
        //edad = in.readInt();
        nFecha = in.readString();
        estado = in.readString();
        genero = in.readString();
    }

}
