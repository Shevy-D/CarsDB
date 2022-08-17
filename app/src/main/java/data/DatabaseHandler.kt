package data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import model.Car
import utils.Util


@SuppressLint("NewApi")
class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        //SQL - Structured Query Language (Структурированный язык запросов)
        val CREATE_CARS_TABLE =
            "CREATE TABLE ${Util.TABLE_NAME} (${Util.KEY_ID} INTEGER PRIMARY KEY, ${Util.KEY_NAME} TEXT, ${Util.KEY_PRICE} TEXT)"
        db?.execSQL(CREATE_CARS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${Util.TABLE_NAME}")
        onCreate(db)
    }

    //CRUD - Create, Read, Update, Delete
    fun addCar(car: Car) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Util.KEY_NAME, car.name)
        contentValues.put(Util.KEY_PRICE, car.price)

        db.insert(Util.TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getCar(id: Int): Car {
        val db = this.readableDatabase
        val cursor = db.query(
            Util.TABLE_NAME, arrayOf(
                Util.KEY_ID, Util.KEY_NAME,
                Util.KEY_PRICE
            ), Util.KEY_ID + "=?", arrayOf(id.toString()),
            null, null,
            null, null
        )
        cursor?.moveToFirst()
        return Car(
            cursor.getString(0).toInt(),
            cursor.getString(1), cursor.getString(2)
        )
    }
}