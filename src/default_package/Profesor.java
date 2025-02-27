package default_package;

public class Profesor {
    //Atributos
    private String nombre;
    private int edad;
    private String clave;

    //Constructor
    public Profesor(String nombre, int edad, String clave){
        this.nombre = nombre;
        this.edad = edad;
        this.clave = clave;
    }

    //----GETTERS Y SETTERS----
    //Getter y setter de atributo nombre
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Getter y setter de atributo edad
    public int getEdad() {
        return edad;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }


    //Getter y setter de atributo clave
    public String getClave() {
        return clave;
    }


    public void setClave(String clave) {
        this.clave = clave;
    }


    //Método para mostrar información de profesores registrados/disponibles
    public void mostrarInformacionProfesores() {
        System.out.print("Nombre profesor: " + this.nombre);
        System.out.print(", Edad: " + this.edad);
        System.out.println(", Clave: " + this.clave);
    }
}
