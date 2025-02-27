package default_package;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class App {

    public static BufferedReader entrada = new BufferedReader((new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception 
    {
        //Listas que almacenarán los objetos
        List<Profesor> profesores = new ArrayList<>();
        List<Salon> salones = new ArrayList<>();
        List<Materia> materias = new ArrayList<>();

        //Ciclo infinito para preguntar opciones hasta que el usuario desee salir del programa
        while(true) {
            System.out.println("\n---- Menu ----");
            System.out.println("1. Agregar un profesor");
            System.out.println("2. Agregar un salon");
            System.out.println("3. Agregar una materia");
            System.out.println("4. Mostrar materias registradas");
            System.out.println("5. Salir del programa\n");

            //Preguntando opción a realizar
            System.out.print("Ingrese una opción: ");
            int opcion = Integer.parseInt(entrada.readLine());

            //Validar opción ingresada
            while(opcion > 5 || opcion < 1) {
                System.out.print("Ingresar una opción válida: ");
                opcion = Integer.parseInt((entrada.readLine()));
            }

            //Condición para salir del programa
            if(opcion == 5) {
                break;
            }


            //switch case para manejar los casos de la opción ingresada
            switch(opcion) 
            {
                case 1:
                    //Preguntando nombre del profesor y guardando dato en variable
                    System.out.print("Ingresa el nombre del profesor: ");
                    String nombreProfesor = entrada.readLine();
                    
                    //Preguntando edad del profesor y guardando dato en variable
                    System.out.print("Ingresa la edad del profesor: ");
                    int edad = Integer.parseInt(entrada.readLine());

                    //Preguntando clave del profesor y guardando dato en variable
                    System.out.print("Ingresa la clave del profesor: ");
                    String clave = entrada.readLine();
                    
                    //Instanciando objeto profesor con los valores antes preguntados
                    //y guardandolo en un ArrayList de manera apilada
                    profesores.add(new Profesor(nombreProfesor, edad, clave));                    
                    break;

                case 2:
                    //Preguntando nombre del salon y guardando dato en variable
                    System.out.print("Ingresa el nombre del salón: ");
                    String nombreSalon = entrada.readLine();

                    //Preguntando edificio del salon y guardando dato en variable
                    System.out.print("Ingresa el edificio del salón: ");
                    String edificio = entrada.readLine();

                    
                    //Instanciando objeto salón con los valores antes preguntados
                    //y guardandolo en un ArrayList de manera apilada
                    salones.add(new Salon(nombreSalon, edificio));
                    break;

                case 3:
                    //Si alguna de las listas de profesores o salones está vacía no se puede 
                    //agregar una materia, por lo tanto finalizar ésta opción
                    if(profesores.isEmpty() || salones.isEmpty()) {
                        System.out.println("Error. No hay profesores y/o salones registrados.");
                    }

                    //De lo contrario (ambas listas contienen información)
                    else {
                        //Recorriendo lista que contiene los objetos de tipo profesor
                        System.out.println("Profesores disponibles:");
                        for(Object x : profesores)
                        {
                            //Llamando a método que muestra la información del profesor actual
                            //(nombre, edad y clave)
                            Profesor xx = (Profesor)x;
                            xx.mostrarInformacionProfesores();
                        }

                        //Recorriendo lista que contiene los objetos de tipo salón
                        System.out.println("\nSalones disponibles:");
                        for(Object x: salones) 
                        {
                            //Llamando a método que muestra la información del salón actual
                            //(nombre del salón y edificio en el que se encuentra)
                            Salon xx = (Salon)x;
                            xx.mostrarInformacionSalones();
                        }
                        
                        //Preguntando el nombre de la materia a registrar y guardando dato en variable
                        System.out.print("\nIngresa el nombre de la materia a registrar: ");
                        String nombreMateria = entrada.readLine();

                        //Preguntando la clave del profesor que impartirá la materia anteriormente indicada
                        System.out.print("Ingresa la clave del profesor que impartirá la" +
                        " asignatura de " + nombreMateria + ": ");
                        String claveProfesorSeleccionado = entrada.readLine();

                        //Llamando a método recursivo que obtendrá el índice en la lista de la clave
                        //buscada. Necesario para mandar esa posición de la lista como atributo para 
                        //el objeto Materia
                        int indiceProfesor = obtenerIndice(profesores, claveProfesorSeleccionado, entrada);
                        
                        //Preguntando salón en el que se impartirá la materia anteriormente indicada
                        System.out.print("Ingresa el nombre del salón en el que se impartirá" + 
                        " la materia de " + nombreMateria + ": ");
                        String nombreSalonSeleccionado = entrada.readLine();
                        
                        //Llamando a método recursivo que obtendrá el índice en la lista del salón
                        //buscado. Necesario para mandar esa posición de la lista como atributo para 
                        //el objeto Materia
                        int indiceSalon = obtenerIndice(salones, nombreSalonSeleccionado, entrada);

                        materias.add(new Materia(nombreMateria, profesores.get(indiceProfesor), salones.get(indiceSalon)));
                    }

                    break;


                case 4:
                    //Si la lista de materias está vacía no se puede mostrar información
                    if(materias.isEmpty()){
                        System.out.println("Error. No hay materias registradas.");
                    }

                    //De lo contrario (no está vacía)
                    else {
                        //Recorriendo lista de materias
                        for(Object x : materias)
                        {
                            //Llamando a método que muestra información de la materia actual
                            Materia xx = (Materia)x;
                            xx.mostrarInformacionMaterias();
                        }
                    }
                    break;

                
                default:
                    break;
            }
        }
    }

    
    //Método recursivo para buscar el índice
    private static <T> int obtenerIndice(List<T> lista, String valorPorBuscar, BufferedReader entrada) throws Exception {
        //Recorriendo lista recibida
        for (int i = 0; i < lista.size(); i++) {
            //Variable para comparar la clave/nombre con el valor buscado
            String valor = null;
            
    
            //Verificar si el objeto es un Profesor o un Salon y obtener el valor correspondiente
            if (lista.get(i) instanceof Profesor) {
                valor = ((Profesor) lista.get(i)).getClave();  // Obtener clave de Profesor
            } else if (lista.get(i) instanceof Salon) {
                valor = ((Salon) lista.get(i)).getNombre();  // Obtener nombre de Salon
            }
    
            //Si encontramos una coincidencia, se rompe la recursividad y se regresa el indice
            if (valor != null && valor.equalsIgnoreCase(valorPorBuscar)) {
                return i;
            }
        }

        //Mostrar mensaje de error dependiendo del tipo de objeto en la lista
        if (!lista.isEmpty() && lista.get(0) instanceof Profesor) 
        {
            System.out.println("Error. Profesor no encontrado.");
            System.out.print("Ingresa la clave del profesor nuevamente: ");
        } 
        
        else if (!lista.isEmpty() && lista.get(0) instanceof Salon) 
        {
            System.out.println("Error. Salon no encontrado.");
            System.out.print("Ingresa el nombre del salón nuevamente: ");
        }

        //Preguntar nuevamente el valor buscado
        valorPorBuscar = entrada.readLine();
    
        //Si no se encuentra el valor, volver a llamar a la misma función (llamada recursiva)
        return obtenerIndice(lista, valorPorBuscar, entrada);
    }
}
