package com.shevy.carsdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import data.DatabaseHandler
import model.Car

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val databaseHandler = DatabaseHandler(this)

        val count = databaseHandler.getCarsCount()
        Log.d("CarsCount", "cars in database $count")

/*        databaseHandler.addCar(Car(name = "Toyota", price = "30 000$"))
        databaseHandler.addCar(Car(name = "Opel", price = "25 000$"))
        databaseHandler.addCar(Car(name = "Mercedes", price = "50 000$"))
        databaseHandler.addCar(Car(name = "KIA", price = "28 000$"))
        databaseHandler.addCar(Car(name = "Mazda", price = "30 000$"))
        databaseHandler.addCar(Car(name = "Honda", price = "25 000$"))
        databaseHandler.addCar(Car(name = "Skoda", price = "50 000$"))
        databaseHandler.addCar(Car(name = "Hyundai", price = "28 000$"))*/

        /*val deletedCar = databaseHandler.getCar(1)
        databaseHandler.deleteCar(deletedCar)*/

        val cars = databaseHandler.getAllCars()
        for (car in cars) {
            Log.d("MyCar", "contains - ID: ${car.id}, NAME: ${car.name}, PRICE: ${car.price}")
        }

        /*val car = databaseHandler.getCar(1)
        car.name = "Tesla"
        car.price = "100 000$"
        databaseHandler.updateCar(car)

        val updatedCarId = databaseHandler.updateCar(car)

        Log.d(
            "MyCar",
            "contains - ID: ${car.id}, NAME: ${car.name}, PRICE: ${car.price} updatedCarId $updatedCarId"
        )*/


    }
}