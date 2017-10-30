
public class Annotation {
	
	private String id;
	private int chr;
	private char strand;
	private String super_id;
	
	public Annotation(String id, int chr, char strand){
		this.id = id;
		this.chr = chr;
		this.strand = strand;
		this.super_id = "";
	}
	
	public Annotation(String id, int chr, char strand, String super_id){
		this.id = id;
		this.chr = chr;
		this.strand = strand;
		this.super_id = super_id;
	}
	
	public String getId(){
		return id;
	}
	
	public int getChromosome(){
		return chr;
	}
	
	public char getStrand(){
		return strand;
	}
	
	public String getSuperId(){
		return super_id;
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
	
}
