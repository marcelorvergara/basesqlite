package android.inflabnet.basesqlite

import android.inflabnet.basesqlite.model.Usuario
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //instancia da classe anotada @Database: AppDatabase
        var appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "appDatabase.sql"
        )
            .allowMainThreadQueries()
            .build()

        appDatabase
            .usuarioDao()
            .store(
                Usuario("Marcelo","Vergaa",12212122)
            )

        appDatabase
            .usuarioDao()
            .update(
                Usuario("Marcelo","Vergaa",13312512,1)
            )

    }
}
