package baas202.baspondman_pset5;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "ToDoList";
    public static final String TABLE_NAME2 = "MainList";

    // Table columns
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TODO = "task";

    public static final String COLUMN_ID2 = "_id";
    public static final String COLUMN_LIST = "list";

    // Database Information
    static final String DB_NAME = "ToDo.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + COLUMN_TODO + " TEXT NOT NULL);";

    private static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + "(" + COLUMN_ID2
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + COLUMN_LIST + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
