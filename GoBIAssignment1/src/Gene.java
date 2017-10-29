import AugmentedTree.IntervalTree;

public class Gene {

	private String id;
	private String name;
	private int start;
	private int stop;
	private char strand;
	private String type;
	
	
	public Gene(String id, String name, int start, int stop, char strand, String type){
		this.id = id;
		this.name = name;
		this.start = start;
		this.stop = stop;
		this.strand= strand;
		this.type = type;
	}
	
	public Gene(String id, String name, int start, int stop, char strand){
		this(id, name, start, stop, strand, "");

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the stop
	 */
	public int getStop() {
		return stop;
	}

	/**
	 * @param stop the stop to set
	 */
	public void setStop(int stop) {
		this.stop = stop;
	}

	/**
	 * @return the strand
	 */
	public char getStrand() {
		return strand;
	}

	/**
	 * @param strand the strand to set
	 */
	public void setStrand(char strand) {
		this.strand = strand;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
