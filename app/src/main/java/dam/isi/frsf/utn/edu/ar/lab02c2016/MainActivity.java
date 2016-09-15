package dam.isi.frsf.utn.edu.ar.lab02c2016;

import android.service.carrier.CarrierService;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    DecimalFormat f = new DecimalFormat("##.00");

    ElementoMenu[] listaBebidas;
    ElementoMenu[] listaPlatos;
    ElementoMenu[] listaPostre;



    ArrayAdapter<ElementoMenu> listaAdapter;
    RadioButton plato, postre, bebida;
    ListView lista;
    Button agregar, confirmarPedido, reiniciar;
    TextView agregados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plato = (RadioButton) findViewById(R.id.Plato);
        postre = (RadioButton) findViewById(R.id.Postre);
        bebida = (RadioButton) findViewById(R.id.Bebida);
        agregar = (Button) findViewById(R.id.Agregar);
        confirmarPedido = (Button) findViewById(R.id.ConfirmarPedido);
        reiniciar = (Button) findViewById(R.id.Reiniciar);
        agregados = (TextView) findViewById(R.id.Agregados);

        agregados.setMovementMethod(new ScrollingMovementMethod());


        lista = (ListView) findViewById(R.id.Lista);
        iniciarListas();
        agregados.setText("");
        listaAdapter = new ArrayAdapter<ElementoMenu>(this, android.R.layout.simple_list_item_single_choice, listaPlatos);
        lista.setAdapter(listaAdapter);

    }


    void eventoClick(View view) {

        switch (view.getId()) {


            case R.id.Plato: {

                listaAdapter = new ArrayAdapter<ElementoMenu>(this, android.R.layout.simple_list_item_single_choice, listaPlatos);
                lista.setAdapter(listaAdapter);


                break;
            }

            case R.id.Postre: {

                listaAdapter = new ArrayAdapter<ElementoMenu>(this, android.R.layout.simple_list_item_single_choice, listaPostre);
                lista.setAdapter(listaAdapter);

                break;
            }
            case R.id.Bebida: {

                listaAdapter = new ArrayAdapter<ElementoMenu>(this, android.R.layout.simple_list_item_single_choice, listaBebidas);
                lista.setAdapter(listaAdapter);

                break;
            }
        }
    }


void onClickAgregar(View view){


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()

                                     {
                                         @Override
                                         public void onItemClick (AdapterView adapterView, View view,int i, long l){

                                             agregados.append(lista.getItemAtPosition(i).toString() + "\n");
                                         }
                                     }

        );


    }


















    class ElementoMenu {
        private Integer id;
        private String nombre;
        private Double precio;


        public ElementoMenu() {
        }

        public ElementoMenu(Integer i, String n, Double p) {
            this.setId(i);
            this.setNombre(n);
            this.setPrecio(p);
        }

        public ElementoMenu(Integer i, String n) {
            this(i,n,0.0);
            Random r = new Random();
            this.precio= (r.nextInt(3)+1)*((r.nextDouble()*100));
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Double getPrecio() {
            return precio;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        @Override
        public String toString() {
            return this.nombre+ "( "+f.format(this.precio)+")";
        }
    }

    private void iniciarListas(){
        // inicia lista de bebidas
        listaBebidas = new ElementoMenu[7];
        listaBebidas[0]=new ElementoMenu(1,"Coca");
        listaBebidas[1]=new ElementoMenu(4,"Jugo");
        listaBebidas[2]=new ElementoMenu(6,"Agua");
        listaBebidas[3]=new ElementoMenu(8,"Soda");
        listaBebidas[4]=new ElementoMenu(9,"Fernet");
        listaBebidas[5]=new ElementoMenu(10,"Vino");
        listaBebidas[6]=new ElementoMenu(11,"Cerveza");
        // inicia lista de platos
        listaPlatos= new ElementoMenu[14];
        listaPlatos[0]=new ElementoMenu(1,"Ravioles");
        listaPlatos[1]=new ElementoMenu(2,"Gnocchi");
        listaPlatos[2]=new ElementoMenu(3,"Tallarines");
        listaPlatos[3]=new ElementoMenu(4,"Lomo");
        listaPlatos[4]=new ElementoMenu(5,"Entrecot");
        listaPlatos[5]=new ElementoMenu(6,"Pollo");
        listaPlatos[6]=new ElementoMenu(7,"Pechuga");
        listaPlatos[7]=new ElementoMenu(8,"Pizza");
        listaPlatos[8]=new ElementoMenu(9,"Empanadas");
        listaPlatos[9]=new ElementoMenu(10,"Milanesas");
        listaPlatos[10]=new ElementoMenu(11,"Picada 1");
        listaPlatos[11]=new ElementoMenu(12,"Picada 2");
        listaPlatos[12]=new ElementoMenu(13,"Hamburguesa");
        listaPlatos[13]=new ElementoMenu(14,"Calamares");
        // inicia lista de postres
        listaPostre= new ElementoMenu[15];
        listaPostre[0]=new ElementoMenu(1,"Helado");
        listaPostre[1]=new ElementoMenu(2,"Ensalada de Frutas");
        listaPostre[2]=new ElementoMenu(3,"Macedonia");
        listaPostre[3]=new ElementoMenu(4,"Brownie");
        listaPostre[4]=new ElementoMenu(5,"Cheescake");
        listaPostre[5]=new ElementoMenu(6,"Tiramisu");
        listaPostre[6]=new ElementoMenu(7,"Mousse");
        listaPostre[7]=new ElementoMenu(8,"Fondue");
        listaPostre[8]=new ElementoMenu(9,"Profiterol");
        listaPostre[9]=new ElementoMenu(10,"Selva Negra");
        listaPostre[10]=new ElementoMenu(11,"Lemon Pie");
        listaPostre[11]=new ElementoMenu(12,"KitKat");
        listaPostre[12]=new ElementoMenu(13,"IceCreamSandwich");
        listaPostre[13]=new ElementoMenu(14,"Frozen Yougurth");
        listaPostre[14]=new ElementoMenu(15,"Queso y Batata");

    }

}



