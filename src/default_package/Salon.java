package default_package;

public class Salon {
    //Atributos
    private String nombre;
    private String edificio;


    //Constructor
    public Salon(String nombre, String edificio){
        this.nombre = nombre;
        this.edificio = edificio;
    }


    //----GETTERS Y SETTERS----
    //Getter y setter de atributo nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Getter y setter de atributo edificio
    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }


    //Método para mostrar información de los salones disponibles
    public void mostrarInformacionSalones() {
        System.out.print("Salon: " + this.nombre);
        System.out.println(", Edificio: " + this.edificio);
    }
}
