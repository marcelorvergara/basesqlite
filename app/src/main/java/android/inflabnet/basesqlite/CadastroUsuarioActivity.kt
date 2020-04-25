package android.inflabnet.basesqlite


import android.inflabnet.basesqlite.model.Usuario
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_cadastro_usuario.*

class CadastroUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        btnInserir.setOnClickListener {
            var nome = editText.text.toString()
            var sobrenome = editText2.text.toString()
            var matricula = editText3.text.toString()

            var usuario = Usuario(nome,sobrenome,matricula.toInt())


            var appDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "appDatabase.sql"
            )
                .allowMainThreadQueries()
                .build()
            appDatabase.usuarioDao().store(usuario)
        }
    }
}
