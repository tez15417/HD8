/** 
* Jorge Mario Tezen 15417
*/

public class Paciente implements Comparable<Paciente> {
    
    private String nombre;
    private String sintoma;
    private String codigo;
    
    public Paciente(String nombre, String sintoma, String codigo){
        
        this.nombre = nombre;
        this.sintoma =sintoma;
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sintoma
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * @param sintoma the sintoma to set
     */
    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String toString(){
    	String text= nombre+", "+sintoma+", "+codigo;
    	return text;
    }

	@Override
	
	//CompareTo para los codigos ASCII dentro de los metodos del VectorHeap
	public int compareTo(Paciente o) {
		String x=((Paciente)o).getCodigo();
		return codigo.compareTo(x);
	}
}
