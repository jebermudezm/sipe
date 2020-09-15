package jebm.sipe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "BDSIPE.sqlite";
    private static final int DB_SCHEME_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creación de la base de datos
        db.execSQL(DataBaseManager.CONFIG);
        db.execSQL(DataBaseManager.ARTICU);
        db.execSQL(DataBaseManager.CLIENT);
        db.execSQL(DataBaseManager.COBRAN);
        db.execSQL(DataBaseManager.TIPDOC);
        db.execSQL(DataBaseManager.LINEAX);
        db.execSQL(DataBaseManager.SUCURX);
        db.execSQL(DataBaseManager.RUTAXX);
        db.execSQL(DataBaseManager.PAISXX);
        db.execSQL(DataBaseManager.DEPETO);
        db.execSQL(DataBaseManager.MUNPIO);
        db.execSQL(DataBaseManager.ENCDOC);
        db.execSQL(DataBaseManager.DETDOC);
        //Insertar conceptos y configuración

        db.execSQL(DataBaseManager.INSCON);
        db.execSQL(DataBaseManager.INSRU1);
        db.execSQL(DataBaseManager.INSRU2);
        db.execSQL(DataBaseManager.INSTD1);
        db.execSQL(DataBaseManager.INSTD2);
        db.execSQL(DataBaseManager.INSTD3);
        db.execSQL(DataBaseManager.INSTD4);
        db.execSQL(DataBaseManager.INSTD5);
        db.execSQL(DataBaseManager.MUNIC1);
        db.execSQL(DataBaseManager.MUNIC2);
        db.execSQL(DataBaseManager.ARTI01);
        db.execSQL(DataBaseManager.ARTI02);
        db.execSQL(DataBaseManager.ARTI03);
        db.execSQL(DataBaseManager.ARTI04);
        db.execSQL(DataBaseManager.ARTI05);
        db.execSQL(DataBaseManager.ARTI06);
        db.execSQL(DataBaseManager.ARTI07);
        db.execSQL(DataBaseManager.ARTI08);
        db.execSQL(DataBaseManager.ARTI09);
        db.execSQL(DataBaseManager.ARTI10);
        db.execSQL(DataBaseManager.CLIE01);
        db.execSQL(DataBaseManager.CLIE02);
        db.execSQL(DataBaseManager.CLIE03);
        db.execSQL(DataBaseManager.CLIE04);
        db.execSQL(DataBaseManager.CLIE05);
        db.execSQL(DataBaseManager.SUCU01);
        db.execSQL(DataBaseManager.SUCU02);
        db.execSQL(DataBaseManager.SUCU03);
        db.execSQL(DataBaseManager.SUCU04);
        db.execSQL(DataBaseManager.SUCU05);
        db.execSQL(DataBaseManager.SUCU06);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
