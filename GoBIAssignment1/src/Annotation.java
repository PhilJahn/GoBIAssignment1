
public class Annotation {
	
	private String id;
	private int chr;
	private char strand;
	private String super_id;
	private String super_super_id;
	private String name;
	private String type;
	
	public Annotation(String id, String name, int chr, char strand, String type){
		this.id = id;
		this.name = name;
		this.chr = chr;
		this.strand = strand;
		this.super_id = "";
		this.super_super_id = "";
		this.type = type;
	}
	
	public Annotation(String id, String name, int chr, char strand, String super_id, String type){
		this.id = id;
		this.name = name;
		this.chr = chr;
		this.strand = strand;
		this.super_id = super_id;
		this.super_super_id = "";
		this.type = type;
	}
	
	public Annotation(String id, int chr, char strand, String super_id, String super_super_id, String type){
		this.id = id;
		this.name = "";
		this.chr = chr;
		this.strand = strand;
		this.super_id = super_id;
		this.super_super_id = super_super_id;
		this.type = type;
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
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
	
	public String getSuperSuperId(){
		return super_super_id;
	}
	
	public boolean isSup(Annotation a){
		if(a != null){
			return a.getSuperId().equals(id);
		}
		else{
			return false;
		}
	}
	
	public boolean isSub(Annotation a){
		if(a != null){
			return a.getId().equals(super_id);
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		return id + "; " + name;
	}
	
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
	
}
