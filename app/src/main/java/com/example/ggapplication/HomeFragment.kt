package com.example.ggapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    private lateinit var userName: EditText
    private lateinit var userLastName: EditText
    private lateinit var radioGroupSex: RadioGroup
    private lateinit var registroContenedor: LinearLayout
    private lateinit var checkboxCar: CheckBox
    private lateinit var checkboxMotorcycle: CheckBox
    private lateinit var checkboxTricycle: CheckBox
    private lateinit var spinnerAgeRange: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicialización de cualquier cosa que necesite hacer en el fragmento
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento y devolver la vista raíz
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas y configurar listeners
        userName = view.findViewById(R.id.user_name) // Inicializa el campo de entrada para el nombre
        userLastName = view.findViewById(R.id.user_lastname) // Inicializa el campo de entrada para el apellido
        radioGroupSex = view.findViewById(R.id.radioGroup_sexUser) // Inicializa el grupo de botones de radio para el sexo
        checkboxCar = view.findViewById(R.id.checkbox_car) // Inicializa el CheckBox para "Carro"
        checkboxMotorcycle = view.findViewById(R.id.checkbox_motorcycle) // Inicializa el CheckBox para "Moto"
        checkboxTricycle = view.findViewById(R.id.checkbox_tricycle) // Inicializa el CheckBox para "Triciclo"
        spinnerAgeRange = view.findViewById(R.id.spinner_ageRange) // Inicializa el Spinner para el rango de edad
        val btnIngresar = view.findViewById<Button>(R.id.btn_ingresar) // Inicializa el botón de "Ingresar"
        registroContenedor = view.findViewById(R.id.registro_contenedor) // Inicializa el contenedor para los registros




        // Configura el listener para el botón "Ingresar"
        btnIngresar.setOnClickListener {
            agregarRegistro() // Llama a la función para agregar un nuevo registro
        }
    }




    private fun agregarRegistro() {
        // Obtener valores de los campos
        val nombre = userName.text.toString() // Obtiene el texto del campo "Nombre"
        val apellido = userLastName.text.toString() // Obtiene el texto del campo "Apellido"
        val selectedRadioButtonId = radioGroupSex.checkedRadioButtonId // Obtiene el ID del botón de radio seleccionado
        val sexo = if (selectedRadioButtonId != -1) {
            val radioButton = view?.findViewById<RadioButton>(selectedRadioButtonId) // Encuentra el botón de radio por su ID
            radioButton?.text.toString() // Obtiene el texto del botón de radio seleccionado
        } else {
            "No especificado" // Valor por defecto si no se seleccionó ningún botón de radio
        }

        // Obtener los medios de transporte seleccionados
        val transportes = mutableListOf<String>()
        if (checkboxCar.isChecked) transportes.add("Carro") // Agrega "Carro" a la lista si está seleccionado
        if (checkboxMotorcycle.isChecked) transportes.add("Moto") // Agrega "Moto" a la lista si está seleccionado
        if (checkboxTricycle.isChecked) transportes.add("Triciclo") // Agrega "Triciclo" a la lista si está seleccionado
        val transporte = if (transportes.isEmpty()) "Ninguno" else transportes.joinToString(", ") // Une los transportes seleccionados en una cadena

        val rangoEdad = spinnerAgeRange.selectedItem.toString() // Obtiene el rango de edad seleccionado

        // Inflar la vista del registro y asignar valores
        val registroView = LayoutInflater.from(context).inflate(R.layout.registro_item, registroContenedor, false) // Infla la vista del registro
        val nombreTextView = registroView.findViewById<TextView>(R.id.nombre) // Inicializa el TextView para el nombre
        val apellidoTextView = registroView.findViewById<TextView>(R.id.apellido) // Inicializa el TextView para el apellido
        val sexoTextView = registroView.findViewById<TextView>(R.id.sexo) // Inicializa el TextView para el sexo
        val transporteTextView = registroView.findViewById<TextView>(R.id.medio_transporte) // Inicializa el TextView para el medio de transporte
        val rangoEdadTextView = registroView.findViewById<TextView>(R.id.rango_edad) // Inicializa el TextView para el rango de edad

        // Asignar los valores obtenidos a los TextViews correspondientes
        nombreTextView.text = nombre
        apellidoTextView.text = apellido
        sexoTextView.text = sexo
        transporteTextView.text = transporte
        rangoEdadTextView.text = rangoEdad


        // Agregar la vista del registro al contenedor
        registroContenedor.addView(registroView) // Añade la vista del registro al contenedor
    }
}
