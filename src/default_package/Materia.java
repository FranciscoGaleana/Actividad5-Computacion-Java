package default_package;

public class Materia {
    //Atributos 
    private String nombre;
    private Profesor profesor;
    private Salon salon;

    //Constructor
    public Materia(String nombre, Profesor profesor, Salon salon) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.salon = salon;
    }


    //----GETTERS Y SETTERS----
    //Getter y setter de atributo nombre
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Getter y setter de atributo profesor (objeto)
    public Profesor getProfesor() {
        return profesor;
    }


    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    //Getter y setter de atributo salon (objeto)
    public Salon getSalon() {
        return salon;
    }


    public void setSalon(Salon salon) {
        this.salon = salon;
    }


    //Metodo para mostrar información de las materias registradas
    public void mostrarInformacionMaterias() {
        System.out.println("\nMateria: " + this.nombre);
        System.out.print("Nombre profesor: " + profesor.getNombre());
        System.out.print(", Edad: " + profesor.getEdad());
        System.out.println(", Clave: " + profesor.getClave());

        System.out.print("Salon: " + salon.getNombre());
        System.out.println(", Edificio: " + salon.getEdificio());
    }
}
