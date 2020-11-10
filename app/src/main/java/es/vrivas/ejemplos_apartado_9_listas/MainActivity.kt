package es.vrivas.ejemplos_apartado_9_listas

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.iterator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.snackbar.Snackbar
import es.vrivas.ejemplos_apartado_9_listas.data.VehiculoContent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.celda_icono_marca_martricula.view.*

class MainActivity : AppCompatActivity() {

    // lista: widget incluido en el layout que permite ir poniendo los elementos
    private lateinit var lista: RecyclerView

    // adaptador: objeto que permite ir "adaptando" cada item a los datos concretos de cada elemento
    // del conjunto de datos
    private lateinit var adaptador: RecyclerView.Adapter<*>

    // gestor_layout: actividad (o fragmento) en que está incluido el RecyclerView
    private lateinit var gestor_layout: LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gestor_layout = LinearLayoutManager(this)
        adaptador = AdaptadorPersonalizado(VehiculoContent.ITEMS)

        lista = rv_lista.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            //setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = gestor_layout

            // specify an viewAdapter (see also next example)
            adapter = adaptador

        }
    }


        /*
    // Clase que permite gestionar cómo se verá cada elemento de la lista
    class AdaptadorPersonalizado(private val conjuntoDatos: MutableList<VehiculoContent.VehiculoItem>) :
            RecyclerView.Adapter<AdaptadorPersonalizado.ContenedorVistaItem>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                //val item = v.tag as VehiculoContent.VehiculoItem
                //Snackbar.make( v, item.matricula, Snackbar.LENGTH_LONG).show()
                //Log.d( "VICTOR", item.matricula)
                Log.d( "VICTOR", "Click")
            }
        }
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        // Each data item is just a string in this case that is shown in a TextView.
        class ContenedorVistaItem(val tv: TextView) : RecyclerView.ViewHolder(tv)

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): AdaptadorPersonalizado.ContenedorVistaItem {
            // create a new view
            val tv = LayoutInflater.from(parent.context)
                    .inflate(R.layout.celda, parent, false) as TextView
            // set the view's size, margins, paddings and layout parameters
            //...
            tv.textSize=30F
            tv.setTextColor(Color.rgb(200,0,0))
            tv.setBackgroundColor(Color.argb(20,200,0,0))
            return ContenedorVistaItem(tv)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(contenedor: ContenedorVistaItem, position: Int) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            contenedor.tv.text = conjuntoDatos[position].toString()
            contenedor.tv.setOnClickListener(onClickListener)
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = conjuntoDatos.size
    }
    */

    // El adaptador es el encargado de definir CÓMO se van a mostrar los datos en cada celda
    // y QUÉ eventos soportarán los mismos.
    @SuppressLint("NewApi")
    inner class AdaptadorPersonalizado(private val conjuntoDatos: MutableList<VehiculoContent.VehiculoItem>) :
        RecyclerView.Adapter<AdaptadorPersonalizado.ContenedorVistaItem>() {

            private val onClickListener: View.OnClickListener

            init {
                onClickListener = View.OnClickListener { v ->
                    // POnemos nuevamente de color blanco el fondo de TODAS las celdas.
                    for( l in lista ) {
                        l.setBackgroundColor(Color.argb(0,0,0,0))
                    }
                    val item = v.tag as VehiculoContent.VehiculoItem
                    v.setBackgroundColor(Color.argb(70,100,100,255))
                    Snackbar.make( v, item.matricula, Snackbar.LENGTH_LONG).show()
                }

            }

        // ContenedorVistaItem es el objeto que permite acceder a los widgets necesarios para
            // mostrar los datos de cada celda
        inner class ContenedorVistaItem(val layout: View) : RecyclerView.ViewHolder(layout)

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): AdaptadorPersonalizado.ContenedorVistaItem {
            // Instancia el layout que contiene todos los elementos de la celda
            val layout = LayoutInflater.from(parent.context)
                .inflate(R.layout.celda_icono_marca_martricula, parent, false) as View
            // En este momento podemos cambiar las propiedades de los elementos del layout de la celda

            // Asociamos eventos a cada elemento de la lsita
            layout.setOnClickListener(onClickListener)
            return ContenedorVistaItem(layout)
        }

        // Permite reemplazar el contenido de los widgets de la celda
        // cada vez que le pasamos la posición de un nuevo elemento de la lista de datos

        override fun onBindViewHolder(contenedor: ContenedorVistaItem, position: Int) {
            // Modificamos el contenido de los widgets que hay en cada celda de la lsita
            with( contenedor.layout ) {
                tv_matricula.text = conjuntoDatos[position].matricula
                tv_marca.text = conjuntoDatos[position].marca
                im_icono.setImageResource(conjuntoDatos[position].icono)

                // tag Almacena el objeto que está representado en cada posición de la lista
                tag=conjuntoDatos[position]


            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = conjuntoDatos.size
    }
}