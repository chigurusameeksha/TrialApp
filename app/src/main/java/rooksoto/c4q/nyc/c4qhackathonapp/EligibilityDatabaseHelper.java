package rooksoto.c4q.nyc.c4qhackathonapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import rooksoto.c4q.nyc.c4qhackathonapp.model.Individual;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by ridita on 2/18/17.
 */

public class EligibilityDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "eligibility.db";
    private static final int DATABASE_VERSION = 1;

    private static EligibilityDatabaseHelper instance;

    public static synchronized EligibilityDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new EligibilityDatabaseHelper(context.getApplicationContext());
        }

        return instance;
    }

    private EligibilityDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        cupboard().register(Individual.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }
}