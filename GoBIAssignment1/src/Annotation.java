
public class Annotation {
	
	private String id;
	private String chr;
	private char strand;
	private String super_id;
	private String super_super_id;
	private String name;
	private String type;
	private String gene_name;
	
	public Annotation(String id, String name, String chr, char strand, String type){
		this.id = id;
		this.name = name;
		this.chr = chr;
		this.strand = strand;
		this.super_id = "";
		this.super_super_id = "";
		this.type = type;
		this.gene_name = name;
	}
	
	public Annotation(String id, String name, String chr, char strand, String super_id, String type, String gene_name){
		this.id = id;
		this.name = name;
		this.chr = chr;
		this.strand = strand;
		this.super_id = super_id;
		this.super_super_id = "";
		this.type = type;
		this.gene_name = gene_name;
	}
	
	public Annotation(String id, String chr, char strand, String super_id, String super_super_id, String type, String gene_name){
		this.id = id;
		this.name = "";
		this.chr = chr;
		this.strand = strand;
		this.super_id = super_id;
		this.super_super_id = super_super_id;
		this.type = type;
		this.gene_name = gene_name;
	}
	
	public Annotation(Annotation a, Annotation b) {
		this.id = a.getId() + "|" + b.getId();
		this.name = a.getName() + "|" + b.getName();
		this.chr = a.getChromosome();
		this.strand = a.getStrand();
		this.super_id = a.getSuperId();
		this.super_super_id = a.getSuperSuperId();
		this.gene_name = a.getGeneName();
		String typea = a.getType();
		String typeb = b.getType();
		if(typea.equals(typeb)){
			this.type = typea;
		}
		else{
			this.type = typea + "|" + typeb;
		}
	}

	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getChromosome(){
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
	
	public String getType(){
		return type;
	}
	
	public String getGeneName(){
		return gene_name;
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
		if(name.equals("")){
			return id + "; " + super_id;
		}
		else{
			return id + "; " + name + "; " + super_id;
		}
	}
	
	public boolean equals(Annotation a){
		return a.getId().equals(id) && a.getSuperId().equals(super_id) && a.getSuperSuperId().equals(super_super_id);
	}
	
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
	
}
