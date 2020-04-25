package android.inflabnet.basesqlite

import android.content.Context
import android.content.Intent
import android.inflabnet.basesqlite.model.Usuario
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var usuario = Usuario("Marcelo","Vergaa",12212122,1)
        var usuario2 = Usuario("Rodrigo","Vergaa",12212122,2)
        var usuario3 = Usuario("JP","Vergaa",12212122,3)

        //instancia da classe anotada @Database: AppDatabase
//        var appDatabase = AppDatabaseService.getInstance(applicationContext)

//        appDatabase
//            .usuarioDao().store(usuario)
//        appDatabase
//            .usuarioDao().store(usuario2)
//        appDatabase
//            .usuarioDao().store(usuario3)
//
//        appDatabase
//            .usuarioDao().update(usuario)
//        appDatabase
//            .usuarioDao().delete(usuario)

//        Log.i("SQLITE",appDatabase
//            .usuarioDao().all().size.toString())

        cadastroBtn.setOnClickListener {
            startActivity(Intent(this,CadastroUsuarioActivity::class.java))
        }

        verificarBtn.setOnClickListener {
            SetupListTask(applicationContext,it).execute()
        }
    }

    inner class SetupListTask(
        val context: Context, val view: View
    ): AsyncTask<Unit,Unit,Array<Usuario>>(){
        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(applicationContext,"Lista de usuarios sendo carregada",Toast.LENGTH_SHORT).show()
        }

        override fun doInBackground(vararg params: Unit?): Array<Usuario>? {
            var appDatabase = AppDatabaseService.getInstance(applicationContext)
            var usuarios = appDatabase.usuarioDao().all()
            return usuarios!!
        }

        override fun onPostExecute(result: Array<Usuario>?) {
            lstUsuarios.text=""
            result!!.forEach {
                lstUsuarios.append(it.nome.toString()+"\n")
            }
        }
    }

//    inner class SetupListTask: AsyncTask<()->Array<Usuario>,Unit,Array<Usuario>>(){
//        override fun doInBackground(vararg params: (() -> Array<Usuario>)?): Array<Usuario> {
//            var retorno  = params[0]?.let{
//                it()
//            }
//            return retorno!!
//        }
//
//        override fun onPostExecute(result: Array<Usuario>?) {
//            lstUsuarios.text=""
//            result!!.forEach {
//                lstUsuarios.append(it.nome.toString()+"\n")
//            }
//        }
//    }
}
